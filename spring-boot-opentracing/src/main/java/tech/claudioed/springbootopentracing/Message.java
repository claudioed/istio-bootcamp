package tech.claudioed.springbootopentracing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudioed on 01/07/18.
 * Project spring-boot-opentracing
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

  private String message;

  private String stack;

  private String version;

}
