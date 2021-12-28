package utils.api.navigation;

import utils.BaseAdminActions;

/**
 * Wrapper class for all possible actions in WDS API
 */
public class NavigationActions extends BaseAdminActions {

  public String getApiNavigationV1Countries(){
    return getAdminActions("get_api_navigation_v1_countries");
  }

  public String getApiNavigationV1BuildingById(String buildingId){
    return getAdminActionsWithId("get_api_navigation_v1_building", buildingId);
  }

  public String getApiNavigationV1BuildingBYCityNameByBuildingName(String cityNameBuildingName){
    return getAdminActionsWithId("get_api_navigation_v1_building", cityNameBuildingName);
  }

  public String getApiNavigationV1RoomById(String roomId){
    return getAdminActionsWithId("get_api_navigation_v1_room_by_id", roomId);
  }

  public String getApiNavigationV1WorkplacesById(String roomId){
    return getAdminActionsWithId("get_api_navigation_v1_workplaces_by_roomId", roomId);
  }
}
