package com.rustled.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("1")
public class RustledService {
    @GET
    @Path("foo")
    @Produces("application/json")
    public Response getFoo() {
        return Response.ok().build();
    }
}
