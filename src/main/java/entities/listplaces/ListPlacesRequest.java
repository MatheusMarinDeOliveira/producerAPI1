package entities.listplaces;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListPlacesRequest {

    @JsonProperty("queryParameter")
    public String queryParameter;

    @JsonProperty("locale")
    public String locale;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("country")
    public String country;

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
