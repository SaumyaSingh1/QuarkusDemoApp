package org.acme;

import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trySomeLongEndPointTESTDESIGN")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @ServerRequestFilter
    public void quarkusFilter(ContainerRequestContext ctx) {
        // only allow GET methods for now
        if(ctx.getMethod().equals(HttpMethod.GET)) {
            ctx.abortWith(Response.status(Response.Status.METHOD_NOT_ALLOWED).build());
        }
    }

    @ServerRequestFilter
    public void myNewFilter(ContainerRequestContext ctx) {
        // only allow GET methods for now
        if(ctx.getMethod().equals(HttpMethod.GET)) {
            ctx.abortWith(Response.status(Response.Status.METHOD_NOT_ALLOWED).build());
        }
    }
}