/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import com.google.gson.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Nikolaj
 */
@Provider
public class QuoteExceptionMapper implements ExceptionMapper<QuoteException>{

    @Override
    public Response toResponse(QuoteException e) {
        JsonObject json = new JsonObject();
        json.addProperty("message", e.getMessage());
        return Response.status(e.getStatusCode()).entity(json.toString()).build();
    }
    
}
