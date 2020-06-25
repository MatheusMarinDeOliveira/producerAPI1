package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrowseQuotesRequest {

    @JsonProperty("country")
    private String country;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("originplace")
    private String originPlace;

    @JsonProperty("destinationplace")
    private String destinationPlace;

    @JsonProperty("outboundpartialdate")
    private String outboundpartialDate;

    @JsonProperty("inboundpartialdate")
    private String inboundpartialDate;


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
