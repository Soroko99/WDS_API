package utils.api.admin_countries;

import pojo.Name;
import utils.BaseAdminActions;

import java.util.Map;

public class AdminCountriesActions extends BaseAdminActions {

    public String postAdminCountries(Name name){
        return postAdminActions("post_admin_countries_v1", name);
    }

    public String putAdminCountries(Map<String, String> map){
        return putAdminActions("post_admin_countries_v1", map);
    }

    public String deleteAdminCountries(){
        JsonAdapter jsonAdapter = new JsonAdapter();
        return deleteAdminActions("post_admin_countries_v1", jsonAdapter.getCreatedCountryIdForDelete());
    }
}
