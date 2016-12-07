package services.transformers;

import controllers.Root;
import dto.DocumentTypeDto;
import dto.DocumentTypesDto;
import dto.HrefDto;
import model.DocumentType;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Created by jstride on 06/12/2016.
 */
public class DocumentTypeTransformer {

    public static String transformDocumentTypeListToHalJson (List<DocumentType> documentTypes,
                                                             String filter) {

        DocumentTypesDto dto = new DocumentTypesDto();
        HrefDto self = new HrefDto(Root.stripApiContext(controllers.routes.Document.listDocumentTypes(filter).url()));

        dto.get_links().setSelf(self);

        List<DocumentTypeDto> docTypes = new ArrayList<>();

        if (nonNull(documentTypes)) {
            documentTypes.forEach(dt -> {
                if (filter == null || dt.getDocumentType().toLowerCase().contains(filter.toLowerCase())) {
                    DocumentTypeDto docType = new DocumentTypeDto(dt);
                    docTypes.add(docType);
                }
            });
        }
        dto.setDocumentTypes(docTypes);

        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();
    }

}
