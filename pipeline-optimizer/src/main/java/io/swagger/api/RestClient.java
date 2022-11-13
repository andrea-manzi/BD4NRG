package io.swagger.api;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

  private String Url;
  private RestTemplate rest;
  private HttpHeaders headers;
  private HttpStatus status;

  public RestClient(String Url, String username, String password) {
    this.Url=Url;
    this.rest = new RestTemplate();
    this.headers = RestClient.createHeaders(username, password);
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
  }

  public String get(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(Url + uri, HttpMethod.GET, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public String post(String uri, String json) {   
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
    ResponseEntity<String> responseEntity = rest.exchange(Url + uri, HttpMethod.POST, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public void put(String uri, String json) {
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
    ResponseEntity<String> responseEntity = rest.exchange(Url + uri, HttpMethod.PUT, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());   
  }

  public void delete(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(Url + uri, HttpMethod.DELETE, requestEntity, String.class);
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