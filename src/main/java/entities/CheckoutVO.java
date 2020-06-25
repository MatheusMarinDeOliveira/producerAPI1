package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.browsequotes.PlacesQuoteApi;
import entities.browsequotes.Quotes;

public class CheckoutVO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("expirationDate")
    private String expirationDate;

    @JsonProperty("quotes")
    private Quotes quotes;

    @JsonProperty("placesQuoteApi")
    private PlacesQuoteApi placesQuoteApi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    public PlacesQuoteApi getPlacesQuoteApi() {
        return placesQuoteApi;
    }

    public void setPlacesQuoteApi(PlacesQuoteApi placesQuoteApi) {
        this.placesQuoteApi = placesQuoteApi;
    }
}
