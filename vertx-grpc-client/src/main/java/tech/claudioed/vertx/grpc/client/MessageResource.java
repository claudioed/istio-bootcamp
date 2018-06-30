
package tech.claudioed.vertx.grpc.client;

import io.grpc.ManagedChannel;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.grpc.VertxChannelBuilder;
import tech.claudioed.grpc.vertx.MessageGrpc;
import tech.claudioed.grpc.vertx.MessageRequest;
import tech.claudioed.grpc.vertx.MessageResponse;

/**
 * @author Claudio Eduardo de Oliveira (claudioed.oliveira@gmail.com)
 */
public class MessageResource extends AbstractVerticle {

  private MessageGrpc.MessageVertxStub stub;

  @Override
  public void start() {
    Router router = Router.router(this.vertx);
    router.route().handler(BodyHandler.create());
    router.get("/istio/message").handler(this::processMessage);
    this.vertx.createHttpServer().requestHandler(router::accept).listen(9090);
    ManagedChannel channel = VertxChannelBuilder
        .forAddress(vertx, System.getenv("GRPC_HOST"), Integer.valueOf(System.getenv("GRPC_PORT")))
        .usePlaintext(true)
        .build();
    this.stub =  MessageGrpc.newVertxStub(channel);
  }

  private void processMessage(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    final MessageRequest request = MessageRequest.newBuilder().build();
    this.stub.getMessage(request, asyncResult -> {
      final MessageResponse messageResponse = asyncResult.result();
      response.end(new JsonObject().put("message",messageResponse.getMessage()).put("stack",messageResponse.getStack()).put("version",messageResponse.getVersion()).encodePrettily());
    });
  }

}
