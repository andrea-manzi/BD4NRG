package io.swagger.api;


import java.nio.charset.Charset;
import java.util.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import io.swagger.configuration.HTAPConfiguration;
public class RestClient {

  private String url;
  private RestTemplate rest;
  private HttpHeaders headers;
  private HttpStatus status;
  private static RestClient client;

  public RestClient() {
    rest = new RestTemplate();
  }

  public static RestClient getClient(HTAPConfiguration configuration) {

    if (client == null) {
      client = new RestClient();
      client.url = configuration.getUrl();
      client.headers = RestClient.createHeaders(configuration.getUser(), configuration.getPassword());
      client.headers.add("Content-Type", "application/json");
      client.headers.add("Accept", "*/*");
    }

      
    return client;
  }

  public String get(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(client.url + uri, HttpMethod.GET, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public String post(String uri, String json) {
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
    ResponseEntity<String> responseEntity = rest.exchange(client.url  + uri, HttpMethod.POST, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public void put(String uri, String json) {
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
    ResponseEntity<String> responseEntity = rest.exchange(client.url  + uri, HttpMethod.PUT, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());   
  }

  public void delete(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(client.url  + uri, HttpMethod.DELETE, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  } 
  
  static HttpHeaders createHeaders(final String username, final String password){
    return new HttpHeaders() {{
          String auth = username + ":" + password;
          final byte[] encodedAuth = Base64.getEncoder().encode( 
             auth.getBytes(Charset.forName("US-ASCII")) );
          String authHeader = "Basic " + new String( encodedAuth );
          set( "Authorization", authHeader );
       }};

}
}