package io.swagger.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.configuration.HTAPConfiguration;
import io.swagger.model.Ingestion;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class DruidApiController implements DruidApi {

    private static final Logger log = LoggerFactory.getLogger(DruidApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private  HTAPConfiguration configuration;

    private RestClient restClient;

    /**
     * @param objectMapper
     * @param request
     */
    @org.springframework.beans.factory.annotation.Autowired
    public DruidApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;

    }

    public ResponseEntity<Ingestion> createIngestion(@Parameter(in = ParameterIn.DEFAULT, description = "The name of the ingestion", required=true, schema=@Schema()) @Valid @RequestBody Ingestion body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Ingestion>(objectMapper.readValue("{\n  \"userMessage\" : \"userMessage\",\n  \"technicalMessage\" : \"technicalMessage\"\n}", Ingestion.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ingestion>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ingestion>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ingestion> getDruidIngestions() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                this.restClient = new RestClient("http://"+configuration.getUser()
                +":"
                +configuration.getPassword()
                +"@"
                +configuration.getServer()
                +":"
                +configuration.getPort());
                System.out.println(configuration.getServer());
                System.out.println(this.restClient.get("/druid/indexer/v1/tasks"));
                return new ResponseEntity<Ingestion>(objectMapper.readValue("{\n  \"userMessage\" : \"userMessage\",\n  \"technicalMessage\" : \"technicalMessage\"\n}", Ingestion.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Ingestion>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Ingestion>(HttpStatus.NOT_IMPLEMENTED);
    }

}
