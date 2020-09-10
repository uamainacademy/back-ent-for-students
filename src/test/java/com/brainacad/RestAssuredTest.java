package com.brainacad;

import static com.brainacad.EndPoints.singleUser;
import static com.brainacad.RestMethods.get;
import static com.brainacad.RestMethods.getStatusCodeFromResponse;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RestAssuredTest {


  @Test // Тест #1 - Проверка статус кода GET респонса (GET-SINGLE USER)
  public void checkStatusCodeOfResponseForSingleUserRequest() {
    //создаем мапу с хедерами, которые отправляються в запросе
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    headers.put("Accept", "application/json");
    //Делаем реквест и получаем респонс
    Response response = get(singleUser, headers, "id", "2");
    //Получаем статус код с респонса и проверяем, что он равен 200
    response.getBody().prettyPrint();

    assertEquals("Wrong status code", 200, getStatusCodeFromResponse(response));
  }

  //TODO Написать тест с GET запросом для полчуения статус кода с метода SINGLE USER NOT FOUND
  // проверить что статус код равен 404
  @Test
  public void checkUserNotFound() {
  }

  //TODO Сделать тест с новым GET методом и id юзера - 6, проверить что имя даного юзера Tracey, а фамилия Ramos
  // использовать методы с класса JsonUtils
  @Test
  public void checkUserFirstAndLastName() {

  }

  //TODO Написать тест с GET запросом для полчуения списка юзеров со страницы №2 (LIST USERS)
  // проверить, что в body респонса есть фамилия Howell (использовать методы с JsonUtils)

  @Test
  public void checkLastNameOnSecondPage() {

  }

  //TODO Написать тест с POST запроса для создания юзера CREATE (/api/users)
  // проверить Status Line на значение HTTP/1.1 201 Created

  @Test
  public void createUser() {
    //создаем body для реквеста
    String requestBody = "{\"name\": \"someName\", \"job\": \"someJob\"}";
  }

  //TODO Написать тест с POST запроса для создания юзера CREATE (/api/users)
  // проверить, что дата создания пользователя совпадаэт с сегодняшней датой

  @Test
  public void checkCreatingDate() {
    //создаем body для реквеста
    String requestBody = "{\"name\": \"someName\", \"job\": \"someJob\"}";
  }


  //TODO Сделать тест с методом PUT. Проверить что в значении updatedAt сегодняшняя дата
  @Test
  public void updateUser() {
    //создаем body для реквеста
    String requestBody = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";
  }

  //TODO Сделать тест с методом DELETE (/api/users/2) проверить что статус код равен 204
  @Test
  public void deleteUser() {

  }

  //TODO POST REGISTER - проверить что значение в токене 17 символов
  @Test
  public void checkPositiveRegister() {
  }

  //TODO POST REGISTER (без пароля) проверить, что боди содержит ерору Missing password
  @Test
  public void checkNegativeRegister() {
  }
}
