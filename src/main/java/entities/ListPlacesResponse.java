package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListPlacesResponse {

    @JsonProperty("Places")
    List<Places> placesList;
}
