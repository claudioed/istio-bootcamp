package tech.claudioed.grpc.vertx;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: message.proto")
public final class MessageGrpc {

  private MessageGrpc() {}

  private static <T> io.grpc.stub.StreamObserver<T> toObserver(final io.vertx.core.Handler<io.vertx.core.AsyncResult<T>> handler) {
    return new io.grpc.stub.StreamObserver<T>() {
      private volatile boolean resolved = false;
      @Override
      public void onNext(T value) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture(value));
        }
      }

      @Override
      public void onError(Throwable t) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.failedFuture(t));
        }
      }

      @Override
      public void onCompleted() {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture());
        }
      }
    };
  }

  public static final String SERVICE_NAME = "message.Message";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<tech.claudioed.grpc.vertx.MessageRequest,
      tech.claudioed.grpc.vertx.MessageResponse> METHOD_GET_MESSAGE = getGetMessageMethod();

  private static volatile io.grpc.MethodDescriptor<tech.claudioed.grpc.vertx.MessageRequest,
      tech.claudioed.grpc.vertx.MessageResponse> getGetMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<tech.claudioed.grpc.vertx.MessageRequest,
      tech.claudioed.grpc.vertx.MessageResponse> getGetMessageMethod() {
    io.grpc.MethodDescriptor<tech.claudioed.grpc.vertx.MessageRequest, tech.claudioed.grpc.vertx.MessageResponse> getGetMessageMethod;
    if ((getGetMessageMethod = MessageGrpc.getGetMessageMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getGetMessageMethod = MessageGrpc.getGetMessageMethod) == null) {
          MessageGrpc.getGetMessageMethod = getGetMessageMethod = 
              io.grpc.MethodDescriptor.<tech.claudioed.grpc.vertx.MessageRequest, tech.claudioed.grpc.vertx.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "message.Message", "getMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tech.claudioed.grpc.vertx.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tech.claudioed.grpc.vertx.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MessageMethodDescriptorSupplier("getMessage"))
                  .build();
          }
        }
     }
     return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageStub newStub(io.grpc.Channel channel) {
    return new MessageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessageFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static MessageVertxStub newVertxStub(io.grpc.Channel channel) {
    return new MessageVertxStub(channel);
  }

  /**
   */
  public static abstract class MessageImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMessage(tech.claudioed.grpc.vertx.MessageRequest request,
        io.grpc.stub.StreamObserver<tech.claudioed.grpc.vertx.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                tech.claudioed.grpc.vertx.MessageRequest,
                tech.claudioed.grpc.vertx.MessageResponse>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageStub extends io.grpc.stub.AbstractStub<MessageStub> {
    public MessageStub(io.grpc.Channel channel) {
      super(channel);
    }

    public MessageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageStub(channel, callOptions);
    }

    /**
     */
    public void getMessage(tech.claudioed.grpc.vertx.MessageRequest request,
        io.grpc.stub.StreamObserver<tech.claudioed.grpc.vertx.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageBlockingStub extends io.grpc.stub.AbstractStub<MessageBlockingStub> {
    public MessageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    public MessageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageBlockingStub(channel, callOptions);
    }

    /**
     */
    public tech.claudioed.grpc.vertx.MessageResponse getMessage(tech.claudioed.grpc.vertx.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageFutureStub extends io.grpc.stub.AbstractStub<MessageFutureStub> {
    public MessageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    public MessageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<tech.claudioed.grpc.vertx.MessageResponse> getMessage(
        tech.claudioed.grpc.vertx.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class MessageVertxImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMessage(tech.claudioed.grpc.vertx.MessageRequest request,
        io.vertx.core.Future<tech.claudioed.grpc.vertx.MessageResponse> response) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), MessageGrpc.toObserver(response.completer()));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new VertxMethodHandlers<
                tech.claudioed.grpc.vertx.MessageRequest,
                tech.claudioed.grpc.vertx.MessageResponse>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageVertxStub extends io.grpc.stub.AbstractStub<MessageVertxStub> {
    public MessageVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    public MessageVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageVertxStub(channel, callOptions);
    }

    /**
     */
    public void getMessage(tech.claudioed.grpc.vertx.MessageRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<tech.claudioed.grpc.vertx.MessageResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, MessageGrpc.toObserver(response));
    }
  }

  private static final int METHODID_GET_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((tech.claudioed.grpc.vertx.MessageRequest) request,
              (io.grpc.stub.StreamObserver<tech.claudioed.grpc.vertx.MessageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class VertxMethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(MessageVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((tech.claudioed.grpc.vertx.MessageRequest) request,
              (io.vertx.core.Future<tech.claudioed.grpc.vertx.MessageResponse>) io.vertx.core.Future.<tech.claudioed.grpc.vertx.MessageResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<tech.claudioed.grpc.vertx.MessageResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return tech.claudioed.grpc.vertx.MessageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Message");
    }
  }

  private static final class MessageFileDescriptorSupplier
      extends MessageBaseDescriptorSupplier {
    MessageFileDescriptorSupplier() {}
  }

  private static final class MessageMethodDescriptorSupplier
      extends MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageFileDescriptorSupplier())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
