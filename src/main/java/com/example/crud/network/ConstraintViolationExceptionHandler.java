
package com.example.crud.network;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ConstraintViolationExceptionHandler  implements ExceptionMapper<ConstraintViolationException> {
  @Override
  public Response toResponse(ConstraintViolationException ex) {
    String message = ex.getConstraintViolations().iterator().next().getMessage();
    
    
    return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
  }
}