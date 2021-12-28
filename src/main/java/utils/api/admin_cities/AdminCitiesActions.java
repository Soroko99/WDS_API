package utils.api.admin_cities;

import pojo.Fields;
import utils.BaseAdminActions;

import java.util.Map;

public class AdminCitiesActions extends BaseAdminActions {

    public String postAdminCities(Fields fields){
        return postAdminActions("admin_cities", fields);
    }

    public String putAdminCities(Map<String, String> mapForPutAdminCities){
        return putAdminActions("admin_cities", mapForPutAdminCities);
    }

    public String deleteAdminCities(){
        CityJsonAdapter cityJsonAdapter = new CityJsonAdapter();
        return deleteAdminActions("admin_cities", cityJsonAdapter.getCityIdForPutAdminCities());
    }


}
