package entities.country;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("name")
    private String name;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("phoneCode")
    private String phoneCode;
    @JsonProperty("language")
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
