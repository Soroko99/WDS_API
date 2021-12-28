package navigation;

import org.testng.annotations.Test;
import utils.api.navigation.NavigationActions;
import utils.api.navigation.NavigationJsonAdapter;

public class Navigation {
    NavigationJsonAdapter navigationJsonAdapter = new NavigationJsonAdapter();
    NavigationActions navigationActions = new NavigationActions();

    @Test(priority = 1)
    public void getApiNavigationV1Countries() {
        navigationActions.getApiNavigationV1Countries();
    }

    @Test(priority = 1)
    public void getApiNavigationV1BuildingById() {
        navigationActions.getApiNavigationV1BuildingById(navigationJsonAdapter.getBuildingId());
    }

    @Test(priority = 1)
    public void getApiNavigationV1BuildingBYCityNameByBuildingName() {
        navigationActions.getApiNavigationV1BuildingBYCityNameByBuildingName(navigationJsonAdapter.getCityNameBuildingName());
    }

    @Test(priority = 1)
    public void getApiNavigationV1RoomById(){
        navigationActions.getApiNavigationV1RoomById(navigationJsonAdapter.getRoomsId());
    }

    @Test(priority = 1)
    public void getApiNavigationV1WorkplacesByRoomId(){
        navigationActions.getApiNavigationV1WorkplacesById(navigationJsonAdapter.getRoomsId());
    }
}




