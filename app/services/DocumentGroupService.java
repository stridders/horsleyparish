package services;

import model.Document;
import model.DocumentGroup;
import play.mvc.Http;

import javax.persistence.NoResultException;
import java.io.File;

/**
 * Created by js on 19/12/2016.
 */
public interface DocumentGroupService {

    /**
     * Returns an instance of a Document Group POJO, by groupName and DocumentType
     * @param groupName
     * @param documentType
     * @return
     * @throws NoResultException
     */
    DocumentGroup get(String groupName, String documentType) throws NoResultException;

    /**
     * Returns an instance of a new or updated Document Group.
     * If the form data does not contain a groupName, then null is returned.
     * @param document
     * @param form
     * @return
     */
    DocumentGroup getOrCreate(Document document, Http.MultipartFormData<File> form);

}
