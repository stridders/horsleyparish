package services;

import com.google.inject.Inject;
import model.DocumentGroup;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


/**
 * Created by js on 19/12/2016.
 */
public class DocumentGroupServiceImpl implements DocumentGroupService {

    @Inject
    services.EntityManager entityManager;

    @Override
    public DocumentGroup getDocumentGroup(String groupName) throws NoResultException {
        TypedQuery<DocumentGroup> query = entityManager.em().createNamedQuery("DocumentGroup.findByGroupName", DocumentGroup.class);
        query.setParameter("groupName", groupName);
        DocumentGroup documentGroup = query.getSingleResult();
        return documentGroup;
    }

}
