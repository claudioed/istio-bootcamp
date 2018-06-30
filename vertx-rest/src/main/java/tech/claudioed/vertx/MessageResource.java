
package tech.claudioed.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * @author Claudio Eduardo de Oliveira (claudioed.oliveira@gmail.com)
 */
public class MessageResource extends AbstractVerticle {

  @Override
  public void start() {
    Router router = Router.router(this.vertx);
    router.route().handler(BodyHandler.create());
    router.get("/istio/message").handler(this::processMessage);
    this.vertx.createHttpServer().requestHandler(router::accept).listen(8080);
  }

  private void processMessage(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    final String message = System.getenv("MESSAGE");
    final String stack = System.getenv("STACK");
    final String version = System.getenv("VERSION");
    response.end(new JsonObject().put("message",message).put("stack",stack).put("version",version).encodePrettily());
  }

}
