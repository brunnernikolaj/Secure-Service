/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Quote;
import exceptions.QuoteException;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Nikolaj
 */
@Path("quote")
public class QuoteService {
    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public QuoteService() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }

    /**
     * Retrieves representation of an instance of REST.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getQuotes() {
        return Response.ok(gson.toJson(Facade.getQuotes()))
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }

    @POST
    @Consumes("application/json")
    public void createQuote(String b) {
        Facade.createQuote(gson.fromJson(b, Quote.class));
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteQuote(@PathParam("id") int id) throws QuoteException {
        return Response.status(Response.Status.OK).entity(gson.toJson(Facade.deleteQuote(id))).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getQuote(@PathParam("id") int id) throws QuoteException{
        return Response.status(Response.Status.OK).entity(gson.toJson(Facade.getQuote(id))).build();
    }
    
    @GET
    @Path("random")
    @Produces("application/json")
    public Response getRandomQuote() throws QuoteException {
        return Response.status(Response.Status.OK).entity(gson.toJson(Facade.getRandomQuote())).build();
    }
    
    @PUT
    @Path("{id}")
    @Produces("application/json")
    public Response updateQuote(@PathParam("id") int id, String q) throws QuoteException {
        return Response.status(Response.Status.OK).entity(Facade.updateQuote(gson.fromJson(q, Quote.class))).build();
    }
}
