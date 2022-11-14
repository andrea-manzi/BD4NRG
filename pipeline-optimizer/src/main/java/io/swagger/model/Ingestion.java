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
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("dataSource")
  private String dataSource = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("payload")
  private String payload = null;

  /**
   * Ingestion state
   * @return state
   **/
  @Schema(description = "Return the ingestion state ")
  
    public String getStatus() {
    return status;
  }

  public void setState(String status) {
    this.status = status;
  }

 /**
   * datasource
   * @return datasource
   **/
  @Schema(description = "Return the ingestion datasource ")
  
    public String getDataSource() {
    return dataSource;
  }

  public void setDatasource(String dataSource) {
    this.dataSource = dataSource;
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
        Objects.equals(this.dataSource, ingestion.dataSource) && 
        Objects.equals(this.payload, ingestion.payload) &&
        Objects.equals(this.status, ingestion.status) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataSource,payload, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ingestion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    datasource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    state: ").append(toIndentedString(status)).append("\n");
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
