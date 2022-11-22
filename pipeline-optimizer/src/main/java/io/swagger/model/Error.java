package io.swagger.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Generic error response object for server side errors
 */
@Schema(description = "Generic error response object for server side errors")
@Validated
public class Error   {
  @JsonProperty("errorCode")
  private Integer errorCode = null;

  @JsonProperty("userMessage")
  private String userMessage = null;

  @JsonProperty("technicalMessage")
  private String technicalMessage = null;

  public Error errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
   **/
  @Schema(description = "")
  
    public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public Error userMessage(String userMessage) {
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

  public Error technicalMessage(String technicalMessage) {
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
    Error error = (Error) o;
    return Objects.equals(this.errorCode, error.errorCode) &&
        Objects.equals(this.userMessage, error.userMessage) &&
        Objects.equals(this.technicalMessage, error.technicalMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, userMessage, technicalMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
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
