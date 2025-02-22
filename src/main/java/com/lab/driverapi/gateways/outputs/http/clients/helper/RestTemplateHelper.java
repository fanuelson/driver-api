package com.lab.driverapi.gateways.outputs.http.clients.helper;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestTemplateHelper {

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  public <T> T getForEntity(Class<T> clazz, String url, Object... uriVariables) {
    try {
      ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriVariables);
      JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
      return readValue(response, javaType);
    } catch (HttpClientErrorException exception) {
      if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
        log.info("No data found {}", url);
      } else {
        log.info("rest client exception", exception.getMessage());
      }
    }
    return null;
  }

  public <T> List<T> getForList(Class<T> clazz, String url, Object... uriVariables) {
    try {
      ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriVariables);
      CollectionType collectionType =
          objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
      return readValue(response, collectionType);
    } catch (HttpClientErrorException exception) {
      if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
        log.info("No data found {}", url);
      } else {
        log.info("rest client exception", exception.getMessage());
      }
    }
    return null;
  }

  public <T, R> T postForEntity(Class<T> clazz, String url, R body, Object... uriVariables) {
    HttpEntity<R> request = new HttpEntity<>(body);
    ResponseEntity<String> response =
        restTemplate.postForEntity(url, request, String.class, uriVariables);
    JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
    return readValue(response, javaType);
  }

  public <T, R> T putForEntity(Class<T> clazz, String url, R body, Object... uriVariables) {
    HttpEntity<R> request = new HttpEntity<>(body);
    ResponseEntity<String> response =
        restTemplate.exchange(url, HttpMethod.PUT, request, String.class, uriVariables);
    JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
    return readValue(response, javaType);
  }

  public void delete(String url, Object... uriVariables) {
    try {
      restTemplate.delete(url, uriVariables);
    } catch (RestClientException exception) {
      log.info(exception.getMessage());
    }
  }

  private <T> T readValue(ResponseEntity<String> response, JavaType javaType) {
    T result = null;
    if (response.getStatusCode() == HttpStatus.OK
        || response.getStatusCode() == HttpStatus.CREATED) {
      try {
        result = objectMapper.readValue(response.getBody(), javaType);
      } catch (IOException e) {
        log.info(e.getMessage());
      }
    } else {
      log.info("No data found {}", response.getStatusCode());
    }
    return result;
  }
}
