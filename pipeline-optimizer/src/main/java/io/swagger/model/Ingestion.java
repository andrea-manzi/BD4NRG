package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ingestion specification
 */
@Schema(description = "Ingestion specification")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-04T07:50:43.523Z[GMT]")


public class Ingestion   {
  @JsonProperty("userMessage")
  private String userMessage = null;

  @JsonProperty("technicalMessage")
  private String technicalMessage = null;

  public Ingestion userMessage(String userMessage) {
    this.userMessage = userMessage;
    return this;
  }

  /**
   * Message to show to the end-users in the UI 
   * @return userMessage
   **/
  @Schema(description = "Message to show to the end-users in the UI ")
  
    public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public Ingestion technicalMessage(String technicalMessage) {
    this.technicalMessage = technicalMessage;
    return this;
  }

  /**
   * Detailed message that is useful for developers to understand the problem 
   * @return technicalMessage
   **/
  @Schema(description = "Detailed message that is useful for developers to understand the problem ")
  
    public String getTechnicalMessage() {
    return technicalMessage;
  }

  public void setTechnicalMessage(String technicalMessage) {
    this.technicalMessage = technicalMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ingestion ingestion = (Ingestion) o;
    return Objects.equals(this.userMessage, ingestion.userMessage) &&
        Objects.equals(this.technicalMessage, ingestion.technicalMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userMessage, technicalMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ingestion {\n");
    
    sb.append("    userMessage: ").append(toIndentedString(userMessage)).append("\n");
    sb.append("    technicalMessage: ").append(toIndentedString(technicalMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
