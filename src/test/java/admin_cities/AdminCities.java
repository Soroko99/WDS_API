package admin_cities;

import org.testng.annotations.Test;
import utils.api.HTTPMethods;
import utils.api.admin_cities.AdminCitiesActions;
import utils.api.admin_countries.JsonAdapter;
import utils.data.WdsApiPojoHelper;

public class AdminCities {
    AdminCitiesActions adminCitiesActions = new AdminCitiesActions();

    @Test(priority = 3)
    public void postAdminCity() {
        JsonAdapter jsonAdapter = new JsonAdapter();
        adminCitiesActions.postAdminCities(WdsApiPojoHelper.generatePojoForPostAdminCities("autoTestCity", jsonAdapter.getCreatedCountryIdForDelete()));
    }

    @Test(priority = 4)
    public void putAdminCities() {
        adminCitiesActions.putAdminCities(HTTPMethods.mapForPutAdminCities());
    }

    @Test(priority = 13)
    public void deleteAdminCities(){
        adminCitiesActions.deleteAdminCities();
    }
}

