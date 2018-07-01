package tech.claudioed.springbootopentracing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author claudioed on 01/07/18.
 * Project spring-boot-opentracing
 */
@RestController
@RequestMapping("/istio/message")
public class MessageResource {

  private final String message;

  private final String stack;

  private final String version;

  public MessageResource(@Value("message.message") String message,@Value("message.stack") String stack,@Value("message.version") String version) {
    this.message = message;
    this.stack = stack;
    this.version = version;
  }

  @GetMapping
  public Message message(){
    return Message.builder().message(this.message).stack(this.stack).version(this.version).build();
  }

}
