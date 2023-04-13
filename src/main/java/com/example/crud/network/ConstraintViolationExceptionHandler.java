
package com.example.crud.network;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ConstraintViolationExceptionHandler  implements ExceptionMapper<ConstraintViolationException> {
  @Override
  public Response toResponse(ConstraintViolationException ex) {
    String message = ex.getConstraintViolations().iterator().next().getMessage();
    
    
    return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
  }
}