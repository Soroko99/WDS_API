package utils.api.admin_workplaces;

import pojo.WorkplacesFields;
import utils.BaseAdminActions;
import utils.api.navigation.NavigationJsonAdapter;

import java.util.Map;

public class AdminWorkplacesActions extends BaseAdminActions {

    public String postAdminWorkplaces(WorkplacesFields fields) {
        return postAdminActions("admin_workplaces", fields);
    }

    public String putApiAdminWorkplaces(Map<String, String> map) {
        return putAdminActions("admin_workplaces", map);
    }

    public String deleteAdminWorkplaces() {
        NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
        return deleteAdminActions("admin_workplaces", navigationJsonAdapter.getWorkplaceID());
    }
}
