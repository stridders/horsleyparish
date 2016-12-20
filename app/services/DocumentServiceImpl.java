package services;

import com.google.inject.Inject;
import exceptionHandlers.ApplicationException;
import model.Document;
import model.DocumentGroup;
import model.DocumentType;
import model.User;
import play.Logger;
import play.mvc.Http;
import security.model.UserProfile;
import services.transformers.DocumentTransformer;
import services.transformers.UserTransformer;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;



public class DocumentServiceImpl implements DocumentService {

    @Inject
    UserTransformer documentTransformer;

    @Inject
    services.EntityManager entityManager;

    @Inject
    UserService userService;

    @Inject
    DocumentGroupService documentGroupService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Override
    public List<DocumentType> getDocumentTypes(String filter) {
        List<DocumentType> documentTypes = getDocumentTypes();
        if (nonNull(documentTypes) && nonNull(filter)) {
            documentTypes.stream().filter(dt -> dt.getDocumentType().contains(filter));
        }
        return documentTypes;
    }

    @Override
    public List<DocumentType> getDocumentTypes() {
        TypedQuery<DocumentType> query = entityManager.em().createNamedQuery("DocumentType.findAll", DocumentType.class);
        List<DocumentType> documentTypes = query.getResultList();
        return documentTypes;
    }

    @Override
    public DocumentType getDocumentType(String docType) {
        TypedQuery<DocumentType> query = entityManager.em().createNamedQuery("DocumentType.findType", DocumentType.class);
        query.setParameter("docType", docType);
        DocumentType documentType = query.getSingleResult();
        return documentType;
    }

    /**
     * Creates, saves and returns a document POJO
     * @param body
     * @return
     */
    @Override
    public Document create(Http.MultipartFormData<File> body) throws IOException, ApplicationException {
        logger.debug("Entered create (document)");

        Http.MultipartFormData.FilePart<File> filePart = body.getFile("file");
        if (filePart != null) {
            String fileName = filePart.getFilename();
            String contentType = filePart.getContentType();
            File file = filePart.getFile();
            String filePath = "public/uploads/" + fileName;
            copy(file.getAbsolutePath(), filePath);
            Document document = new Document();
            Map<String, DocumentType> docTypes = mapDocumentTypes();
            UserProfile userProfile = UserProfile.getUserProfileFromHttpContext();
            User user = userService.getUser(userProfile.getEmail());
            document = DocumentTransformer.createDocument(body, docTypes, user, filePath);
            try {
                DocumentGroup documentGroup = documentGroupService.getDocumentGroup(document.getDocumentGroup().getGroupName());
                if (nonNull(documentGroup)) {
                    documentGroup.getDocuments().add(document);
                    document.setDocumentGroup(documentGroup);
                }
            } catch(NoResultException nre) {
                // do nothing
            }
            entityManager.em().merge(document);
            entityManager.em().flush();
            return document;
        } else {
            logger.error("error", "Missing file");
            throw new ApplicationException("Unable to find file in request body");
        }

    }

    /**
     * Copy a file from one location to another
     * @param sourcePath
     * @param destinationPath
     * @throws IOException
     */
    public static void copy(String sourcePath, String destinationPath) throws IOException {
        Files.copy(Paths.get(sourcePath), new FileOutputStream(destinationPath));
    }

    /**
     * List Documents, optionally filtered by document type and/or group
     * @param docType
     * @param docGroup
     * @return
     */
    @Override
    public List<Document> getDocuments(String docType, String docGroup) {
        logger.debug("Entered getDocuments");
        if (docType == null) {
            docType="";
        }
        TypedQuery<Document> query = entityManager.em().createNamedQuery("Document.findDocuments", Document.class);
        query.setParameter("docType", '%'+docType+'%');
        List<Document> documents = query.getResultList();
        return documents;
    }

    /**
     * Get Document by document ID. Returns document image with metadata
     * @param id
     * @return
     */
    @Override
    public Document getDocumentById(Long id) {
        logger.debug("Entered getDocumentById");
        TypedQuery<Document> query = entityManager.em().createNamedQuery("Document.findByDocumentId", Document.class);
        query.setParameter("id", id);
        Document document = query.getSingleResult();
        return document;
    }

    /**
     * Returns a map of documentType POJOs, keyed on documentType
     * @return
     */
    public Map<String, DocumentType> mapDocumentTypes() {
        Map<String, DocumentType> docTypes = new HashMap<>();
        List<DocumentType> types = getDocumentTypes();
        types.forEach(type -> {
            docTypes.put(type.getDocumentType(),type);
        });
        return docTypes;
    }



}
