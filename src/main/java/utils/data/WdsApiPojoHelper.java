package utils.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.*;

public class WdsApiPojoHelper {

  public static Name generateJSONForPojo(String countryName){
    Name adminCountries = new Name(countryName);
    return adminCountries;
  }

  public static Fields generatePojoForPostAdminCities(String cityName, String id){
    Fields fields = new Fields(cityName, id);
    return fields;
  }

  public static CityFields generatePojoForPostAdminBuildings(String cityId, String title){
    CityFields cityFields = new CityFields(cityId, title);
    return cityFields;
  }

  public static FloorFields generatePojoForAdminFloors(String buildingId, String number){
    FloorFields fields = new FloorFields(buildingId, number);
    return fields;
  }

  public static RoomsFields generatePojoForAdminRooms(String floorId, String name){
    RoomsFields fields = new RoomsFields(floorId, name);
    return fields;
  }

  public static WorkplacesFields generatePojoForAdminWorkplaces(String title, String roomId){
    WorkplacesFields workplacesFields = new WorkplacesFields(title, roomId);
    return workplacesFields;
  }

  public static String extractPOJO(Pojo pojo) {
    ObjectMapper mapper = new ObjectMapper();
    String result = null;
    try {
      result = mapper.writeValueAsString(pojo);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return result;
  }

}