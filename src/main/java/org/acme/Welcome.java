package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.Templates;

@Path("HelloRESTEasy")
public class Welcome {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String welcomeHere(){
        return "Welcome to Quarkus :)";
    }

}
