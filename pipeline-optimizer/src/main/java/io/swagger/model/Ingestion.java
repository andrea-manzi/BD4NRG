package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Ingestion specification
 */
@Schema(description = "Ingestion specification")
@Validated
public class Ingestion   {
  @JsonProperty("state")
  private String state = null;

  @JsonProperty("datasource")
  private String datasource = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("payload")
  private String payload = null;

  /**
   * Ingestion state
   * @return state
   **/
  @Schema(description = "Return the ingestion state ")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

 /**
   * datasource
   * @return datasource
   **/
  @Schema(description = "Return the ingestion datasource ")
  
    public String getDatasource() {
    return datasource;
  }

  public void setDatasource(String datasource) {
    this.datasource = datasource;
  }

  /**
   * id
   * @return id
   **/
  @Schema(description = "Return the ingestion id ")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

   /**
   * id
   * @return id
   **/
  @Schema(description = "Return the ingestion payload ")
  
    public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
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
    return Objects.equals(this.id, ingestion.id) &&
        Objects.equals(this.datasource, ingestion.datasource) && 
        Objects.equals(this.payload, ingestion.payload) &&
        Objects.equals(this.state, ingestion.state) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, datasource,payload, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ingestion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    datasource: ").append(toIndentedString(datasource)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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
