package admin_floors;

import org.testng.annotations.Test;
import utils.api.HTTPMethods;
import utils.api.admin_floors.AdminFloorsActions;
import utils.api.navigation.NavigationJsonAdapter;
import utils.data.WdsApiPojoHelper;

public class AdminFloors {
    AdminFloorsActions adminFloors = new AdminFloorsActions();

    @Test(priority = 6)
    public void postApiAdminFloors(){
        NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
        adminFloors.postAdminFloors(WdsApiPojoHelper.generatePojoForAdminFloors(navigationJsonAdapter.getBuildingId(), "22"));
    }

    @Test(priority = 6)
    public void putAdminFloors(){
        adminFloors.putAdminFloors(HTTPMethods.mapForPutAdminFloors());
    }

    @Test(priority = 11)
    public void deleteAdminFloors(){
        adminFloors.deleteAdminFloors();
    }
}
