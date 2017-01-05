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
    DocumentTypeService documentTypeService;

    @Inject
    UserService userService;

    @Inject
    DocumentGroupService documentGroupService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    /**
     * Creates, saves and returns a document POJO.
     * Also creates or updates a documentGroup POJO, as required.
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

            Document document = new Document();
            Map<String, DocumentType> docTypes = mapDocumentTypes();
            UserProfile userProfile = UserProfile.getUserProfileFromHttpContext();
            User user = userService.getUser(userProfile.getEmail());
            document = DocumentTransformer.createPOJO(body, docTypes, user);
            copy(file.getAbsolutePath(), document.getDocumentPath());
            DocumentGroup documentGroup = documentGroupService.getOrCreate(document,body);
            if (documentGroup != null) {
                document.setDocumentGroup(documentGroup);
            }
            entityManager.em().persist(document);
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
    public List<Document> getAll(String docType, String docGroup) {
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
    public Document get(Long id) {
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
    @Override
    public Map<String, DocumentType> mapDocumentTypes() {
        Map<String, DocumentType> docTypes = new HashMap<>();
        List<DocumentType> types = documentTypeService.getAll();
        types.forEach(type -> {
            docTypes.put(type.getDocumentType(),type);
        });
        return docTypes;
    }

}
