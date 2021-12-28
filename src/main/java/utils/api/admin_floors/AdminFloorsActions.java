package utils.api.admin_floors;

import pojo.FloorFields;
import utils.BaseAdminActions;

import java.util.Map;

public class AdminFloorsActions extends BaseAdminActions {

    public String postAdminFloors(FloorFields fields){
        return postAdminActions("admin_floors", fields);
    }

    public String putAdminFloors(Map<String,String> map){
        return putAdminActions("admin_floors", map);
    }

    public String deleteAdminFloors(){
        AdminFloorsJsonAdapter adminFloorsJsonAdapter = new AdminFloorsJsonAdapter();
        return deleteAdminActions("admin_floors", adminFloorsJsonAdapter.getCreatedFloorId());
    }
}
