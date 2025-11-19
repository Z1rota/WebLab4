package org.ziro.backend.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import org.ziro.backend.dto.PointRequestDTO;

import org.ziro.backend.models.Point;
import org.ziro.backend.service.PointService;
import org.ziro.backend.util.Secured;

import java.util.List;

@Path("/points")
@Secured
public class PointController {

    private final PointService pointService;


    public PointController() {
        pointService = null;
    }


    @Inject
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }


    @POST
    public Response addPoint(PointRequestDTO point, @Context SecurityContext context) {
        String creator = context.getUserPrincipal().getName();
        Point savedPoint=pointService.addPoint(point, creator);
        return Response.ok(savedPoint).build();
    }

    @GET
    public Response getPoints() {
        List<Point> points= pointService.getAllPoints();
        return Response.ok(points).build();
    }


    @DELETE
    public Response deletePoint() {
        pointService.deleteAllPoints();
        return Response.ok().build();
    }


}
