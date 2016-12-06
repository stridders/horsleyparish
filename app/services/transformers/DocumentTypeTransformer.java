package services.transformers;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import controllers.Root;
import controllers.routes;
import model.DocumentType;
import model.User;

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

        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation rep = rf.newRepresentation();

        rep.withLink("self", Root.stripApiContext(controllers.routes.Document.listDocumentTypes(filter).url()));

        List<Representation> repDocTypes = new ArrayList<>();

        if (nonNull(documentTypes)) {
            documentTypes.forEach(dt -> {
                Representation r = rf.newRepresentation();
                r.withProperty("documentType",dt.getDocumentType());
                r.withProperty("description", dt.getDescription());
                repDocTypes.add(r);
            });
        }

        rep.withRepresentation("documentTypes",repDocTypes);

        StringWriter sw = new StringWriter();
        rep.toString(RepresentationFactory.HAL_JSON,sw);
        return sw.toString();
    }

}
