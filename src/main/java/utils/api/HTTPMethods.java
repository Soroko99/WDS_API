package utils.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import pojo.Pojo;
import utils.api.admin_cities.CityJsonAdapter;
import utils.api.admin_countries.JsonAdapter;
import utils.api.admin_floors.AdminFloorsJsonAdapter;
import utils.api.navigation.NavigationJsonAdapter;
import utils.data.WdsApiPojoHelper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Wrapper class for all possible actions in JIRA API
 */
public class HTTPMethods {

  static final Logger logger = Logger.getLogger(HTTPMethods.class);
  public static String BASE_AZUREWEBSITES_URI = "https://wds-backend.azurewebsites.net";

  public static ValidatableResponse get(String urlPath) {
    RestAssured.baseURI =  BASE_AZUREWEBSITES_URI;
    ValidatableResponse response = given().
        header("Content-Type", ContentType.JSON).
        header("Authorization", "Bearer " + Authorization.JSESSIONID).
        when().
        get(urlPath).
        then();

    String responseBody = response.extract().asString();
    logger.info("RESPONSE URL: " + Authorization.BASE_IDENTITY_URI + urlPath);
    logger.info("RESPONSE BODY: " + responseBody);
    return response;
  }

  public static Map<String, String> mapForPutAdminCountries(){
    JsonAdapter jsonAdapter = new JsonAdapter();
    HashMap<String, String> map = new HashMap<>();
    map.put("id", jsonAdapter.getCreatedCountryIdForPut());
    map.put("name", "autoTestCountry");
    return map;
  }

  public static Map<String, String> mapForPutAdminCities(){
    CityJsonAdapter cityJsonAdapter = new CityJsonAdapter();
    JsonAdapter jsonAdapter = new JsonAdapter();
    HashMap<String, String> map = new HashMap<>();
    map.put("id", cityJsonAdapter.getCityIdForPutAdminCities());
    map.put("name", "putAutoTestCity");
    map.put("countryId", jsonAdapter.getCreatedCountryIdForDelete());
    return map;
  }

  public static Map<String, String> mapForPutAdminBuildings(){
    HashMap<String, String> map = new HashMap<>();
    NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
    CityJsonAdapter cityJsonAdapter = new CityJsonAdapter();
    map.put("id", navigationJsonAdapter.getBuildingId());
    map.put("title", "putAutoTestBuilding");
    map.put("cityId", cityJsonAdapter.getCityIdForPutAdminCities());
    return map;
  }

  public static Map<String, String> mapForPutAdminFloors(){
    HashMap<String, String> map = new HashMap<>();
    AdminFloorsJsonAdapter adminFloorsJsonAdapter = new AdminFloorsJsonAdapter();
    NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
    map.put("id", adminFloorsJsonAdapter.getCreatedFloorId());
    map.put("number", "13");
    map.put("buildingId", navigationJsonAdapter.getBuildingId());
    return map;
  }

  public static Map<String, String> mapForPutAdminRooms(){
    HashMap<String, String> map = new HashMap<>();
    AdminFloorsJsonAdapter adminFloorsJsonAdapter = new AdminFloorsJsonAdapter();
    NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
    map.put("id", navigationJsonAdapter.getRoomsId());
    map.put("name", "09");
    map.put("floorId", adminFloorsJsonAdapter.getCreatedFloorId());
    return map;
  }

  public static Map<String, String> mapForPutAdminWorkplaces(){
    HashMap<String, String> map = new HashMap<>();
    NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
    map.put("id", navigationJsonAdapter.getWorkplaceID());
    map.put("title", "10");
    map.put("roomId", navigationJsonAdapter.getRoomsId());
    return map;
  }

  public static ValidatableResponse put(String urlPath, Map<String, String> map){
    RestAssured.baseURI =  BASE_AZUREWEBSITES_URI;
    ValidatableResponse response = given().
            header("Content-Type", ContentType.JSON).
            header("Authorization", "Bearer " + Authorization.JSESSIONID).
            body(map).
            put(urlPath).
            then();

    String responseBody = response.extract().asString();
    logger.info("RESPONSE URL: " + Authorization.BASE_IDENTITY_URI + urlPath);
    logger.info("RESPONSE BODY: " + responseBody);

    return response;
  }

  public static ValidatableResponse post(String urlPath, Pojo body) {
    RestAssured.baseURI =  BASE_AZUREWEBSITES_URI;
    ValidatableResponse response = given().
        header("Content-Type", ContentType.JSON).
        header("Authorization", "Bearer " + Authorization.JSESSIONID).
        body(body).
        when().
        post(urlPath).
        then();

    String responseBody = response.extract().asString();
    logger.info("RESPONSE URL: " + Authorization.BASE_IDENTITY_URI + urlPath);
    logger.info("RESPONSE BODY: " + responseBody);
    logger.info("REQUEST BODY: " + WdsApiPojoHelper.extractPOJO(body));

    return response;
  }

  public static ValidatableResponse delete(String urlPath) {
    RestAssured.baseURI =  BASE_AZUREWEBSITES_URI;
    ValidatableResponse response = given().
        header("Content-Type", ContentType.JSON).
        header("Authorization", "Bearer " + Authorization.JSESSIONID).
        when().
        delete(urlPath).
        then();

    String responseBody = response.extract().asString();
    logger.info("RESPONSE URL: " + Authorization.BASE_IDENTITY_URI + urlPath);
    logger.info("RESPONSE BODY: " + responseBody);

    return response;
  }

}
