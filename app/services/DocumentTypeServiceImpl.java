package services;

import com.google.inject.Inject;
import model.DocumentType;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

/**
 * Created by js on 20/12/2016.
 */
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Inject
    services.EntityManager entityManager;

    @Override
    public List<DocumentType> getAll(String doctype, String role) {
        List<DocumentType> documentTypes = getAll();
        List<DocumentType> filtered = new ArrayList<>();
        if (nonNull(documentTypes) && nonNull(doctype)) {
            filtered = documentTypes.stream()
                    .filter(dt -> dt.getDocumentType().contains(doctype))
                    .collect(Collectors.toList());
            documentTypes = filtered;
        }
        if (nonNull(documentTypes) && nonNull(role)) {
            filtered = documentTypes.stream()
                    .filter(dt -> role.contains(dt.getRole().getRole()))
                    .collect(Collectors.toList());
            documentTypes = filtered;
        }
        return documentTypes;
    }

    @Override
    public List<DocumentType> getAll() {
        TypedQuery<DocumentType> query = entityManager.em().createNamedQuery("DocumentType.findAll", DocumentType.class);
        List<DocumentType> documentTypes = query.getResultList();
        return documentTypes;
    }

    @Override
    public DocumentType get(String docType) {
        TypedQuery<DocumentType> query = entityManager.em().createNamedQuery("DocumentType.findType", DocumentType.class);
        query.setParameter("docType", docType);
        DocumentType documentType = query.getSingleResult();
        return documentType;
    }

}
