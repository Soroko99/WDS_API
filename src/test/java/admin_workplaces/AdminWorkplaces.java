package admin_workplaces;

import org.testng.annotations.Test;
import utils.api.HTTPMethods;
import utils.api.admin_workplaces.AdminWorkplacesActions;
import utils.api.navigation.NavigationJsonAdapter;
import utils.data.WdsApiPojoHelper;

public class AdminWorkplaces {
    AdminWorkplacesActions adminWorkplacesActions = new AdminWorkplacesActions();
    NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();

    @Test(priority = 8)
    public void postAdminWorkplace(){
        adminWorkplacesActions.postAdminWorkplaces(WdsApiPojoHelper.generatePojoForAdminWorkplaces("132", navigationJsonAdapter.getRoomId()));
    }

    @Test(priority = 8)
    public void putAdminWorkplaces(){
        adminWorkplacesActions.putApiAdminWorkplaces(HTTPMethods.mapForPutAdminWorkplaces());
    }

    @Test(priority = 9)
    public void deleteAdminWorkplaces(){
        adminWorkplacesActions.deleteAdminWorkplaces();
    }
}
