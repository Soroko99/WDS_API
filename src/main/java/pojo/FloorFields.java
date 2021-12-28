package pojo;

public class FloorFields implements Pojo{
    public String buildingId;
    public String number;

    public FloorFields(String buildingId, String number) {
        this.buildingId = buildingId;
        this.number = number;
    }
}
