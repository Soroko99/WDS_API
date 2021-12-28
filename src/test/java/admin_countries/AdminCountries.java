package admin_countries;

import org.testng.annotations.Test;
import pojo.Name;
import utils.api.HTTPMethods;
import utils.api.admin_countries.AdminCountriesActions;
import utils.data.WdsApiPojoHelper;

public class AdminCountries {
    AdminCountriesActions adminCountriesActions = new AdminCountriesActions();

    @Test(priority = 2)
    public void postAdminCountries(){
        Name polshaCountry = WdsApiPojoHelper.generateJSONForPojo("Polsha");
        adminCountriesActions.postAdminCountries(polshaCountry);
    }

    @Test(priority = 2)
    public void putAdminActions(){
        adminCountriesActions.putAdminCountries(HTTPMethods.mapForPutAdminCountries());
    }

    @Test(priority = 14)
    public void deleteAdminActions(){
        adminCountriesActions.deleteAdminCountries();
    }
}
