package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrowseRoutesResponse {
    @JsonProperty("Quotes")
    private List<Quotes> quotes;

    @JsonProperty("Places")
    private List<PlacesQuoteApi> places;

    @JsonProperty("Carriers")
    private List<Carriers> carriers;

    @JsonProperty("Currencies")
    private List<Currencies> currencies;

    @JsonIgnore(value = true)
    @JsonProperty("Routes")
    private List<Quotes> Routes;
}
