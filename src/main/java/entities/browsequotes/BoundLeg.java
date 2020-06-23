package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BoundLeg {

    @JsonProperty("CarrierIds")
    public List<String> carriesIds;

    @JsonProperty("OriginId")
    public String originId;

    @JsonProperty("DestinationId")
    public String destinationId;

    @JsonProperty("DepartureDate")
    public String departureDate;
}
