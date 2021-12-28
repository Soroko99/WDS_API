package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields implements Pojo{
    @JsonProperty("name")
    public String name;
    @JsonProperty("countryId")
    public String id;

    public Fields(String countryName, String id) {
        this.id = id;
        this.name = countryName;
    }

    public Fields setId(String countryId) {
        this.id = countryId;
        return this;
    }

    public Fields setName(String countryName) {
        this.name = countryName;
        return this;
    }
}
