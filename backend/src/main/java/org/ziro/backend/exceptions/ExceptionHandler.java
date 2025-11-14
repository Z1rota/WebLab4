package org.ziro.backend.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<ApplicationException> {

  @Override
  public Response toResponse(ApplicationException e) {
    return Response.status(e.getStatus()).entity(e.getMessage()).build();
  }

}
