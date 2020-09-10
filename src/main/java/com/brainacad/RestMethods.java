package com.brainacad;

import static com.brainacad.BaseURL.baseURI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class RestMethods {

 /* GET метод который принимает на вход ендпоинт, список хедеров и pathParameter
   https://techeplanet.com/rest-assured-pathparam-example/ */

  public static Response get(String endpoint, Map<String, String> headersForRequest,
      String paramName, String paramValue) {
    //Создаем реквест спецификацию на основе которой будем делать реквест
    RequestSpecification httpRequest = RestAssured.given();
    //Добавляем хедеры в реквест, сетаем параметры, и выполняем метод GET - > на выходе получаем обьект типа Response
    Response response = httpRequest
        .baseUri(baseURI)
        .basePath(endpoint)
        .headers(headersForRequest)
        .pathParam(paramName, paramValue)
        .get();
    return response;
  }

  public static int getStatusCodeFromResponse(Response response) {
    return response.getStatusCode();
  }

  //TODO написать метод который возвращает body с респонса в виде String

  //TODO зделать оверлоад метода get(), который использовал бы по умолчнию хедер
  // Accept со значением application/json и хедер Сontent-Type со значением application/json
  // дополнительная информация тут - https://habr.com/ru/post/421005/

   //TODO написать метод getWithQueryParams() который будет работать с query parameter https://techeplanet.com/how-to-pass-query-parameter-in-rest-assured/

  //TODO разобраться как работае метод post()
  //Метод пост, который отправляет на сервер тело запроса и возвращает респонс
  public static Response post(String endpoint, String requestBody) {
    //Создаем реквест спецификацию на основе которой будем делать реквест
    RequestSpecification httpRequest = RestAssured.given();
    //Добавляем Accept хедер в запрос со значением JSON
    Response response = httpRequest
        .baseUri(baseURI)
        .basePath(endpoint)
        .accept(ContentType.JSON)
        .contentType(ContentType.JSON)
        .body(requestBody)
        .post();
    return response;
  }

  //TODO Заимплементировать методы для PUT и DELETE

}
