package utils.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import utils.framework.PropertyManager;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Authorization {

  public static String JSESSIONID;
  public static String BASE_IDENTITY_URI = "https://wds-backend-identity.azurewebsites.net";
  static final Logger logger = Logger.getLogger(Authorization.class);

  public static HashMap<String, String> getCredentials(){
    HashMap<String, String> credentials = new HashMap<>();
    credentials.put("client_id", "WdsSecretId");
    credentials.put("client_secret", "WdsHashedSecretCode");
    credentials.put("grant_type", "password");
    credentials.put("username", "_nabil.gasanov@itechart-group.com");
    credentials.put("password", "6pz6nbQ!@");
    credentials.put("scope", "WdsApi offline_access");
    return credentials;
  }

  public static void login() {
    PropertyManager propertyManager = new PropertyManager();
    RestAssured.baseURI = BASE_IDENTITY_URI;
    JSESSIONID =
            given().
                    contentType(ContentType.URLENC).
                    formParams(getCredentials()).
                    when().
                    post(propertyManager.getApiPaths("get_token")).
                    then().statusCode(200).contentType(ContentType.JSON).extract().path("access_token");

    logger.info("\nAUTHORIZATION TOKEN: " + Authorization.JSESSIONID);
  }
}
