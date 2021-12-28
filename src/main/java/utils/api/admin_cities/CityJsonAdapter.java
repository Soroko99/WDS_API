package utils.api.admin_cities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.api.navigation.NavigationActions;

import static com.google.gson.JsonParser.parseString;

public class CityJsonAdapter {

    NavigationActions navigationActions = new NavigationActions();
    JSONParser jsonParser = new JSONParser();

    public JSONArray objToArray(String param, JSONObject jsonObject){
        JSONArray jsonArray = (JSONArray) jsonObject.get(param);
        return jsonArray;
    }

    public JSONObject arrayToObject(int index, JSONArray jsonArray){
        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        return jsonObject;
    }

    public String getCityIdForPutAdminCities(){
        String response = navigationActions.getApiNavigationV1Countries();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parseString(String.valueOf(arrayToObject(0, objToArray("cities", arrayToObject(0, jsonArray)))))
                .getAsJsonObject().getAsJsonPrimitive("id").getAsString();
    }
}

