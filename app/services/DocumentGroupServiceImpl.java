package services;

import com.google.inject.Inject;
import model.Document;
import model.DocumentGroup;
import play.mvc.Http;
import services.transformers.DocumentGroupTransformer;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.File;

import static java.util.Objects.nonNull;
import static org.springframework.util.Assert.notNull;


/**
 * Created by js on 19/12/2016.
 */
public class DocumentGroupServiceImpl implements DocumentGroupService {

    @Inject
    services.EntityManager entityManager;

    @Inject
    DocumentGroupTransformer documentGroupTransformer;

    /**
     * Returns an instance of a Document Group POJO, by groupName and DocumentType
     * @param groupName
     * @param documentType
     * @return
     * @throws NoResultException
     */
    @Override
    public DocumentGroup get(String groupName, String documentType) throws NoResultException {
        TypedQuery<DocumentGroup> query = entityManager.em().createNamedQuery("DocumentGroup.findByGroupAndType", DocumentGroup.class);
        query.setParameter("groupName", groupName);
        query.setParameter("documentType", documentType);
        DocumentGroup documentGroup = query.getSingleResult();
        return documentGroup;
    }

    /**
     * Returns an instance of a new or updated Document Group.
     * If the form data does not contain a groupName, then null is returned.
     * @param document
     * @param form
     * @return
     */
    @Override
    public DocumentGroup getOrCreate(Document document, Http.MultipartFormData<File> form) {
        DocumentGroup newDocumentGroup = documentGroupTransformer.create(form,document);
        try {
            if (newDocumentGroup != null) {
                DocumentGroup existingDocumentGroup = get(newDocumentGroup.getGroupName(), newDocumentGroup.getDocumentType().getDocumentType());
                existingDocumentGroup.getDocuments().add(document);
                return existingDocumentGroup;
            }
        } catch(NoResultException nre) {
            // No action required;
        }
        return newDocumentGroup;
    }

}
