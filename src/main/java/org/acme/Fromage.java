package org.acme;


import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

class FroMage {
   public String name;

   public FroMage(String name) {
      this.name = name;
   }
}

@Path("cheese")
class Endpoint {

   @GET
   public FroMage sayCheese() {
      return new FroMage("Cheeeeeese");
   }

   @PUT
   public void addCheese(FroMage fromage) {
      System.err.println("Received a new cheese: " + fromage.name);
   }
}
