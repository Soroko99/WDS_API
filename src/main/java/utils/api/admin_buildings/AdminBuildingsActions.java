package utils.api.admin_buildings;

import pojo.CityFields;
import utils.BaseAdminActions;
import utils.api.navigation.NavigationJsonAdapter;

import java.util.Map;

public class AdminBuildingsActions extends BaseAdminActions {

    public String postApiAdminBuildings(CityFields fields){
        return postAdminActions("admin_buildings", fields);
    }

    public String putApiAdminBuildings(Map<String, String> map){
        return putAdminActions("admin_buildings", map);
    }

    public String deleteAdminBuildings(){
        NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
        return deleteAdminActions("admin_buildings", navigationJsonAdapter.getBuildingId());
    }
}
