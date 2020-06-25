package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BoundLeg {

    @JsonProperty("CarrierIds")
    private List<String> carriesIds;

    @JsonProperty("OriginId")
    private String originId;

    @JsonProperty("DestinationId")
    private String destinationId;

    @JsonProperty("DepartureDate")
    private String departureDate;

    public List<String> getCarriesIds() {
        return carriesIds;
    }

    public void setCarriesIds(List<String> carriesIds) {
        this.carriesIds = carriesIds;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}
