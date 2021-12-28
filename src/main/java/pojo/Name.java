package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name implements Pojo{
    @JsonProperty("name")
    public String name;

    public Name(String name){
        this.name = name;
    }
}
