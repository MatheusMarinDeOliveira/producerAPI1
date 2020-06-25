package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrowseQuotesResponse {

    @JsonProperty("Quotes")
    private List<Quotes> quotes;

    @JsonProperty("Places")
    private List<PlacesQuoteApi> places;

    @JsonProperty("Carriers")
    private List<Carriers> carriers;

    @JsonProperty("Currencies")
    private List<Currencies> currencies;

    public List<Quotes> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quotes> quotes) {
        this.quotes = quotes;
    }

    public List<PlacesQuoteApi> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlacesQuoteApi> places) {
        this.places = places;
    }

    public List<Carriers> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carriers> carriers) {
        this.carriers = carriers;
    }

    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currencies> currencies) {
        this.currencies = currencies;
    }
}
