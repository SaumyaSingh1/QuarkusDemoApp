package org.acme;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

class UnknownCheeseException extends RuntimeException {
   public final String name;

   public UnknownCheeseException(String name) {
      this.name = name;
   }
}

@ApplicationScoped
class CheeseService {
   private static final Map<String, String> cheeses =
           Map.of("camembert", "Camembert is a very nice cheese",
                   "gouda", "Gouda is acceptable too, especially with cumin");

   public String findCheese(String name) {
      String ret = cheeses.get(name);
      if(ret != null)
         return ret;
      throw new UnknownCheeseException(name);
   }
}

