package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlacesQuoteApi {

    @JsonProperty("PlaceId")
    public String placeId;

    @JsonProperty("IataCode")
    public String iataCode;

    @JsonProperty("Name")
    public String name;

    @JsonProperty("Type")
    public String type;

    @JsonProperty("SkyscannerCode")
    public String skyscannerCode;

    @JsonProperty("CityName")
    public String cityName;

    @JsonProperty("CityId")
    public String cityId;

    @JsonProperty("CountryName")
    public String countryName;

}
