package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import exceptionHandlers.ApplicationException;
import model.Document;
import model.DocumentType;
import model.User;
import model.UserRole;
import play.Logger;
import play.api.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;
import play.mvc.Http;
import security.OAuthCredentials;
import security.model.UserProfile;
import services.transformers.DocumentTransformer;
import services.transformers.UserTransformer;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;


public class DocumentServiceImpl implements DocumentService {

    @Inject
    UserTransformer documentTransformer;

    @Inject
    UserService userService;

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
        TypedQuery<DocumentType> query = em().createNamedQuery("DocumentType.findAll", DocumentType.class);
        List<DocumentType> documentTypes = query.getResultList();
        return documentTypes;
    }

    @Override
    public DocumentType getDocumentType(String docType) {
        TypedQuery<DocumentType> query = em().createNamedQuery("DocumentType.findType", DocumentType.class);
        query.setParameter("docType", docType);
        DocumentType documentType = query.getSingleResult();
        return documentType;
    }

    /**
     * Creates, saves and returns a document POJO
     * @param form
     * @return
     */
    @Override
    public Document create(Http.MultipartFormData form) throws IOException, ApplicationException {
        logger.debug("Entered create (document)");

        if (form == null || form.getFile("file") == null ) {
            throw new ApplicationException(ApplicationException.DOCUMENT__MISSING_MULTIPART_DATA);
        }

        Document document = new Document();
        Map<String, DocumentType> docTypes = mapDocumentTypes();
        UserProfile userProfile = UserProfile.getUserProfileFromHttpContext();
        User user = userService.getUser(userProfile.getEmail());
        document = DocumentTransformer.createDocument(form, docTypes, user);
        em().persist(document);
        em().flush();
        return document;
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
        TypedQuery<Document> query = em().createNamedQuery("Document.findDocuments", Document.class);
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
        TypedQuery<Document> query = em().createNamedQuery("Document.findByDocumentId", Document.class);
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

    private static EntityManager em() {
        JPAApi jpaApi = Play.current().injector().instanceOf(JPAApi.class);
        EntityManager em = jpaApi.em();
        em.setFlushMode(FlushModeType.COMMIT);
        return (em);
    }

//    private static EntityManager em() {
//        EntityManager em = JPA.em();
//        em.setFlushMode(FlushModeType.COMMIT);
//        return (em);
//    }


}
