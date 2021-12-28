package admin_rooms;

import org.testng.annotations.Test;
import utils.api.HTTPMethods;
import utils.api.admin_floors.AdminFloorsJsonAdapter;
import utils.api.admin_rooms.AdminRoomsActions;
import utils.data.WdsApiPojoHelper;

public class AdminRooms {
    AdminRoomsActions adminRoomsActions = new AdminRoomsActions();

    @Test(priority = 7)
    public void postAdminRooms(){
        AdminFloorsJsonAdapter adminFloorsJsonAdapter = new AdminFloorsJsonAdapter();
        adminRoomsActions.postAdminRooms(WdsApiPojoHelper.generatePojoForAdminRooms(adminFloorsJsonAdapter.getCreatedFloorId(), "21"));
    }

    @Test(priority = 7)
    public void putAdminRooms(){
        adminRoomsActions.putApiAdminRooms(HTTPMethods.mapForPutAdminRooms());
    }

    @Test(priority = 10)
    public void deleteAdminRooms(){
        adminRoomsActions.deleteAdminRooms();
    }
}
