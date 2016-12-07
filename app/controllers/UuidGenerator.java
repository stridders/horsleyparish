package controllers;

import dto.HrefDto;
import dto.UuidDto;
import play.Logger;
import play.mvc.Result;

import java.io.StringWriter;
import java.util.UUID;

import static play.mvc.Results.ok;

/**
 * Created by js on 08/11/2016.
 */
public class UuidGenerator {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    public Result randomUUID() {
        String uuid = UUID.randomUUID().toString();

        UuidDto dto = new UuidDto();
        HrefDto href = new HrefDto(routes.UuidGenerator.randomUUID().url());
        dto.get_links().setSelf(href);
        dto.setUuid(uuid);

        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return ok(sw.toString()).as("application/hal+json");
    }

}
