package entities.country;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoreInformationCountryVO {

    @JsonProperty("information")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
