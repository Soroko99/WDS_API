package utils.api.navigation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static com.google.gson.JsonParser.parseString;

public class NavigationJsonAdapter {
    JSONParser jsonParser = new JSONParser();
    NavigationActions navigationActions = new NavigationActions();

    public JSONArray objToArray(String param, JSONObject jsonObject){
        JSONArray jsonArray = (JSONArray) jsonObject.get(param);
        return jsonArray;
    }

    public JSONObject arrayToObject(int index, JSONArray jsonArray){
        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        return jsonObject;
    }

    public JSONArray getRooms(){
        String response = navigationActions.getApiNavigationV1BuildingById(getBuildingId());
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return objToArray("rooms", arrayToObject(0, objToArray("floors", jsonObject)));
    }

    public String getRoomId(){
        String response = navigationActions.getApiNavigationV1BuildingById(getBuildingId());
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parseString(String.valueOf(arrayToObject(0, objToArray("rooms", arrayToObject(0, objToArray("floors", jsonObject)))))).getAsJsonObject().getAsJsonPrimitive("id").getAsString();
    }

    public JSONArray getBuildings() {
        String response = navigationActions.getApiNavigationV1Countries();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return objToArray("buildings",
                arrayToObject(0, objToArray("cities", arrayToObject(0, jsonArray))));
    }

    public String getRoomsId(){
        return parseString(String.valueOf(arrayToObject(0, getRooms()))).getAsJsonObject()
                .getAsJsonPrimitive("id").getAsString();
    }

    public String getWorkplaceID() {
        String response = navigationActions.getApiNavigationV1WorkplacesById(getRoomId());
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = (JSONArray) jsonParser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parseString(String.valueOf(arrayToObject(0, jsonArray))).getAsJsonObject().getAsJsonPrimitive("id").getAsString();
    }


    public String getBuildingId(){
        return parseString(String.valueOf(arrayToObject(0, getBuildings())))
                .getAsJsonObject().getAsJsonPrimitive("id").getAsString();
    }

    public String getCityNameBuildingName(){
        JSONObject jsonObject = arrayToObject(0, getBuildings());
        return parseString(String.valueOf(jsonObject)).getAsJsonObject().getAsJsonPrimitive("cityName").getAsString()
                + "/" + parseString(String.valueOf(jsonObject)).getAsJsonObject().getAsJsonPrimitive("title").getAsString();
    }

}
