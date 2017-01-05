package services;

import model.DocumentType;

import java.util.List;

/**
 * Created by js on 20/12/2016.
 */
public interface DocumentTypeService {

    /**
     * Returns a list of all documentTypes filtered on documentType and/or user role(s)
     * @param type
     * @param role
     * @return
     */
    List<DocumentType> getAll(String type, String role);

    /**
     * Returns a list of all documentTypes
     * @return
     */
    List<DocumentType> getAll();

    /**
     * returns a DocumentType object for a given document type
     * @param docType
     * @return
     */
    DocumentType get(String docType);

}
