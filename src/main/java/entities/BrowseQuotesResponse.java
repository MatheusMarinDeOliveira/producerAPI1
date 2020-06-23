package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrowseQuotesResponse {

    @JsonProperty("Quotes")
    public List<Quotes> quotes;

    @JsonProperty("Places")
    public List<PlacesQuoteApi> places;

    @JsonProperty("Carriers")
    public List<Carriers> carriers;

    @JsonProperty("Currencies")
    public List<Currencies> currencies;

}
