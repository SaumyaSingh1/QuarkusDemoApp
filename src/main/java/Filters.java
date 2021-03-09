import org.jboss.resteasy.reactive.server.ServerRequestFilter;
import org.jboss.resteasy.reactive.server.ServerResponseFilter;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.Response;
import java.net.URI;

public class Filters {
   @ServerRequestFilter(preMatching = true)
   public void preMatchingFilter(ContainerRequestContext requestContext) {
      // make sure we don't lose cheese lovers
      if("yes".equals(requestContext.getHeaderString("Cheese"))) {
         requestContext.setRequestUri(URI.create("/cheese"));
      }
   }

   @ServerRequestFilter(preMatching = true)
   public void addingOneMoreFilter(ContainerRequestContext requestContext) {
      // make sure we don't lose cheese lovers
      if("yes".equals(requestContext.getHeaderString("Cheese"))) {
         requestContext.setRequestUri(URI.create("/cheese"));
      }
   }

   @ServerRequestFilter
   public void sampleFilter(ContainerRequestContext ctx) {
      // only allow GET methods for now
      if(ctx.getMethod().equals(HttpMethod.GET)) {
         ctx.abortWith(Response.status(Response.Status.METHOD_NOT_ALLOWED).build());
      }
   }

   @ServerRequestFilter
   public void extraFilter(ContainerRequestContext ctx) {
      // only allow GET methods for now
      if(ctx.getMethod().equals(HttpMethod.GET)) {
         ctx.abortWith(Response.status(Response.Status.METHOD_NOT_ALLOWED).build());
      }
   }

   @ServerResponseFilter
   public void getFilter(ContainerResponseContext responseContext) {
      Object entity = responseContext.getEntity();
      if(entity instanceof String) {
         // make it shout
         responseContext.setEntity(((String)entity).toUpperCase());
      }
   }

   @ServerResponseFilter
   public void myFilter(ContainerResponseContext responseContext) {
      Object entity = responseContext.getEntity();
      if(entity instanceof String) {
         // make it shout
         responseContext.setEntity(((String)entity).toUpperCase());
      }
   }

   @ServerResponseFilter
   public void thirdResponseFilter(ContainerResponseContext responseContext) {
      Object entity = responseContext.getEntity();
      if(entity instanceof String) {
         // make it shout
         responseContext.setEntity(((String)entity).toUpperCase());
      }
   }
}
