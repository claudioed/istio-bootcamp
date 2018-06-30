package tech.claudioed.grpc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;
import java.io.IOException;
import tech.claudioed.grpc.vertx.MessageGrpc;
import tech.claudioed.grpc.vertx.MessageRequest;
import tech.claudioed.grpc.vertx.MessageResponse;

/**
 * @author claudioed on 06/05/18.
 * Project grpc-vertx-bootcamp
 */
public class MessageVerticle extends AbstractVerticle {

  @Override
  public void start() throws IOException {

    MessageGrpc.MessageVertxImplBase messageService = new MessageGrpc.MessageVertxImplBase(){
      @Override
      public void getMessage(MessageRequest request, Future<MessageResponse> response) {
        final String message = System.getenv("MESSAGE");
        final String stack = System.getenv("STACK");
        final String version = System.getenv("VERSION");
        response.complete(MessageResponse.newBuilder().setMessage(message).setStack(stack).setVersion(version).build());
      }
    };

    VertxServer rpcServer = VertxServerBuilder
        .forAddress(vertx, "localhost", 8080)
        .addService(messageService)
        .build();

    rpcServer.start();

  }
}
