/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Nikolaj
 */
public class QuoteException extends Exception{

    private Status statusCode;
    
    public QuoteException(String string, Status statusCode) {
        super(string);
        this.statusCode = statusCode;
    }

    public Status getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Status statusCode) {
        this.statusCode = statusCode;
    }   
       
}
