package entities.listplaces;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListPlacesRequest {

    @JsonProperty("queryParameter")
    private String queryParameter;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("country")
    private String country;

    public String getQueryParameter() {
        return queryParameter;
    }

    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
