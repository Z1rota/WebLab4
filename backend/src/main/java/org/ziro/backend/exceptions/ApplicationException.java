package org.ziro.backend.exceptions;

import jakarta.ws.rs.core.Response;

public class ApplicationException extends RuntimeException {

    private final Response.Status status;

    public ApplicationException(Response.Status status, String message) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
