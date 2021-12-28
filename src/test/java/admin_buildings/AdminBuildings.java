package admin_buildings;

import org.testng.annotations.Test;
import utils.api.HTTPMethods;
import utils.api.admin_buildings.AdminBuildingsActions;
import utils.api.admin_cities.CityJsonAdapter;
import utils.data.WdsApiPojoHelper;

public class AdminBuildings {
    AdminBuildingsActions adminBuildingsActions = new AdminBuildingsActions();

    @Test(priority = 5)
    public void postAdminBuildings(){
        CityJsonAdapter cityJsonAdapter = new CityJsonAdapter();
        adminBuildingsActions.postApiAdminBuildings(WdsApiPojoHelper.generatePojoForPostAdminBuildings(cityJsonAdapter.getCityIdForPutAdminCities(), "autoTestBuilding"));
    }

    @Test(priority = 5)
    public void putAdminBuildings(){
        adminBuildingsActions.putApiAdminBuildings(HTTPMethods.mapForPutAdminBuildings());
    }

    @Test(priority = 12)
    public void deleteAdminBuildings(){
        adminBuildingsActions.deleteAdminBuildings();
    }
}
