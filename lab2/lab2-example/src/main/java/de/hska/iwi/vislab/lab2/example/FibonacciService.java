package de.hska.iwi.vislab.lab2.example;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fibonacci")
public class FibonacciService {

    private static final int INITIAL_N = 1;

    //In-memory database of resource
    private int n = INITIAL_N;

    @POST @Produces(MediaType.APPLICATION_JSON)
    public Response next() {
        this.n++;

        return generateResponse();
    }

    @GET @Produces(MediaType.APPLICATION_JSON)
    public Response current() {
        return generateResponse();
    }

    @DELETE 
    public void restore() {
        this.n = INITIAL_N;
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private Response generateResponse() {
        FibonacciResponse response = new FibonacciResponse(n, fibonacci(n));
        return Response.ok(response.toString(), MediaType.APPLICATION_JSON).build();
    }
}