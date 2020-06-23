package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.browsequotes.BoundLeg;

public class Quotes {

    @JsonProperty("QuoteId")
    public String quoteId;

    @JsonProperty("MinPrice")
    public Double minPrice;

    @JsonProperty("Direct")
    public String direct;

    @JsonProperty("OutboundLeg")
    public BoundLeg outboundLeg;

    @JsonProperty("InboundLeg")
    public BoundLeg inboundLeg;

    @JsonProperty("QuoteDateTime")
    public String QuoteDateTime;
}
