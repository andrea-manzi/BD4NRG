
package io.swagger.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.model.Error;
import io.swagger.model.Ingestion;
import io.swagger.model.IngestionReport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Validated
public interface DruidApi {

    /**
     * @param body
     * @return
     */
    @Operation(summary = "Create a new Ingestion specification", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "ingestions" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/druid/ingestion",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    String createIngestion(@Parameter(in = ParameterIn.DEFAULT, description = "The ingestion", required=true, schema=@Schema()) @Valid @RequestBody Ingestion body);

     /**
     * @param id
     * @return
     */
    @Operation(summary = "Resubmit an Ingestion specification", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "ingestions" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK") })
    @RequestMapping(value = "/druid/reingestion/{id}",
        method = RequestMethod.PUT)
    String resubmitIngestion(@PathVariable String id);


    @Operation(summary = "Retrieve information about Ingestions from Druid", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ingestion.class))),
        
        @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "419", description = "Re-delegate credentials", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "503", description = "Try again later", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/druid/ingestions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Ingestion[]> getDruidIngestions();

    @Operation(summary = "Retrieve report about an Ingestion from Druid", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = IngestionReport.class))),
        
        @ApiResponse(responseCode = "401", description = "Not authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "419", description = "Re-delegate credentials", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "503", description = "Try again later", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/druid/ingestion/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<IngestionReport> getDruidIngestionReport(@PathVariable String id);

}

