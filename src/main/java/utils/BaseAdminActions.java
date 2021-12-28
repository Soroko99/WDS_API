package utils;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import pojo.Pojo;
import utils.api.HTTPMethods;
import utils.framework.PropertyManager;

import java.util.Map;

public class BaseAdminActions {
    PropertyManager propertyManager = new PropertyManager();

    public String getAdminActions(String propertyName){
        ValidatableResponse response = HTTPMethods.get(propertyManager.getApiPaths(propertyName));
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }

    public String getAdminActionsWithId(String propertyName, String id){
        ValidatableResponse response = HTTPMethods.get(propertyManager.getApiPaths(propertyName) + id);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }

    public String postAdminActions(String propertyName, Pojo pojo){
        ValidatableResponse response = HTTPMethods.post(propertyManager.getApiPaths(propertyName), pojo);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }

    public String putAdminActions(String propertyName, Map<String, String> map){
        ValidatableResponse response = HTTPMethods.put(propertyManager.getApiPaths(propertyName), map);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }

    public String deleteAdminActions(String propertyName, String id){
        ValidatableResponse response = HTTPMethods.delete(propertyManager.getApiPaths(propertyName) + id);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }
}
