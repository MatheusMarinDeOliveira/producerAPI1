package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrowseQuotesRequest {

    @JsonProperty("country")
    public String country;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("locale")
    public String locale;

    @JsonProperty("originplace")
    public String originPlace;

    @JsonProperty("destinationplace")
    public String destinationPlace;

    @JsonProperty("outboundpartialdate")
    public String outboundpartialDate;

    @JsonProperty("inboundpartialdate")
    public String inboundpartialDate;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getOutboundpartialDate() {
        return outboundpartialDate;
    }

    public void setOutboundpartialDate(String outboundpartialDate) {
        this.outboundpartialDate = outboundpartialDate;
    }

    public String getInboundpartialDate() {
        return inboundpartialDate;
    }

    public void setInboundpartialDate(String inboundpartialDate) {
        this.inboundpartialDate = inboundpartialDate;
    }
}
