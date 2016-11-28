package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import model.Document;
import model.DocumentType;
import model.User;
import model.UserRole;
import play.Logger;
import play.api.Play;
import play.db.jpa.JPAApi;
import security.OAuthCredentials;
import security.model.UserProfile;
import services.transformers.DocumentTransformer;
import services.transformers.UserTransformer;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DocumentServiceImpl implements DocumentService {

    @Inject
    UserTransformer documentTransformer;

    @Inject
    UserService userService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

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
     * @param json
     * @return
     */
    @Override
    public Document create(JsonNode json) throws IOException {
        logger.debug("Entered create (document)");
        Document document = new Document();
        Map<String, DocumentType> docTypes = mapDocumentTypes();
        UserProfile userProfile = UserProfile.getUserProfileFromHttpContext();
        User user = userService.getUser(userProfile.getEmail());
        document = DocumentTransformer.transformJsonToDocument(json, docTypes, user);
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


}
