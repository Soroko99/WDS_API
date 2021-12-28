package utils.api.admin_floors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.api.navigation.NavigationActions;
import utils.api.navigation.NavigationJsonAdapter;

import static com.google.gson.JsonParser.parseString;

public class AdminFloorsJsonAdapter {

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

    public String getCreatedFloorId(){
        NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
        String response = navigationActions.getApiNavigationV1BuildingById(navigationJsonAdapter.getBuildingId());

        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parseString(String.valueOf(arrayToObject(0, objToArray("floors", jsonObject))))
                .getAsJsonObject().getAsJsonPrimitive("id").getAsString();
    }
}
