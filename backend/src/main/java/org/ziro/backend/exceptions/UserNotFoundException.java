package org.ziro.backend.exceptions;

import jakarta.ws.rs.core.Response;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException(Response.Status status, String message) {
        super(Response.Status.NOT_FOUND,message);
    }
}
