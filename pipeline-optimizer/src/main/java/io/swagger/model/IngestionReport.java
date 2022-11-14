package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Ingestion specification
 */
@Schema(description = "Ingestion report")
@Validated
public class IngestionReport {
    @JsonProperty("ingestionStatsAndErrors")
    private JsonNode report = null;
    
    /**
   * Ingestion report
   * @return report
   **/
  @Schema(description = "Return the ingestion report ")
  
  public JsonNode getReport() {
  return report;
  }

  public void setReport(JsonNode report) {
  this.report = report;
 }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngestionReport ingestion = (IngestionReport) o;
    return Objects.equals(this.report, ingestion.report) ;
  }
  @Override
  public int hashCode() {
    return Objects.hash(report);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ingestion {\n");
    
    sb.append("    report: ").append(toIndentedString(report)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /* Convert the given object to string with each line indented by 4 spaces
  * (except the first line).
  */
 private String toIndentedString(java.lang.Object o) {
   if (o == null) {
     return "null";
   }
   return o.toString().replace("\n", "\n    ");
 }
}
