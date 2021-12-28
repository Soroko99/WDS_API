package utils.api.admin_rooms;

import pojo.RoomsFields;
import utils.BaseAdminActions;
import utils.api.navigation.NavigationJsonAdapter;

import java.util.Map;

public class AdminRoomsActions extends BaseAdminActions {

    public String postAdminRooms(RoomsFields fields) {
        return postAdminActions("admin_rooms", fields);
    }

    public String putApiAdminRooms(Map<String, String> map) {
        return putAdminActions("admin_rooms", map);
    }

    public String deleteAdminRooms() {
        NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
        return deleteAdminActions("admin_rooms", navigationJsonAdapter.getRoomId());
    }

}
