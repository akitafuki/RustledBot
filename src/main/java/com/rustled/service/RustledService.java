package com.rustled.service;

import com.rustled.application.RustledTwitchClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("foo")
public class RustledService {
    @Inject
    RustledTwitchClient twitchClient;

    /**
     * Only here to help initialize the client. Temporary.
     */
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response getFoo() {
        return Response.ok().build();
    }
}
