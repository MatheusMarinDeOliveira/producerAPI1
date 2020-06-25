package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carriers {

    @JsonProperty("CarrierId")
    private String carrierId;

    @JsonProperty("Name")
    private String name;

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
