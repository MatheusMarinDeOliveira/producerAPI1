package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carriers {

    @JsonProperty("CarrierId")
    public String carrierId;

    @JsonProperty("Name")
    public String name;
}
