package services.transformers;

import model.Document;
import model.DocumentGroup;
import play.mvc.Http;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * Created by js on 20/12/2016.
 */
public class DocumentGroupTransformer {

    public DocumentGroup create(Http.MultipartFormData<File> form, Document document) {

        Map<String,String[]> formData = form.asFormUrlEncoded();
        DocumentGroup documentGroup = null;
        String group;
        if (isNull(formData.get("fileGroup"))) {
            group = "null";
        } else {
            group = Arrays.asList(formData.get("fileGroup")).toString().replaceAll("[\\[\\]]","");
        }
        documentGroup = new DocumentGroup();
        documentGroup.getDocuments().add(document);
        documentGroup.setGroupName(group);
        documentGroup.setDocumentType(document.getDocumentType());

        return documentGroup;
    }


}


//}
