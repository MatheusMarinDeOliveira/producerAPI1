package entities.listplaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListPlacesResponse {

    @JsonProperty("Places")
    private List<PlacesApiListPlace> placesList;

    public List<PlacesApiListPlace> getPlacesList() {
        return placesList;
    }

    public void setPlacesList(List<PlacesApiListPlace> placesList) {
        this.placesList = placesList;
    }
}
