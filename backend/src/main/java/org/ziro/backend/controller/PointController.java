package org.ziro.backend.controller;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.ziro.backend.dto.PointRequestDTO;
import org.ziro.backend.models.Point;
import org.ziro.backend.util.Secured;

@Path("/points")
@Secured
public class PointController {

    public PointController() {}


    @POST
    public Response addPoint(PointRequestDTO point) {
        return null;
    }


}
