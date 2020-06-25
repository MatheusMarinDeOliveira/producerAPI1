package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.browsequotes.BoundLeg;

public class Quotes {

    @JsonProperty("QuoteId")
    private String quoteId;

    @JsonProperty("MinPrice")
    private Double minPrice;

    @JsonProperty("Direct")
    private String direct;

    @JsonProperty("OutboundLeg")
    private BoundLeg outboundLeg;

    @JsonProperty("InboundLeg")
    private BoundLeg inboundLeg;

    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public BoundLeg getOutboundLeg() {
        return outboundLeg;
    }

    public void setOutboundLeg(BoundLeg outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

    public BoundLeg getInboundLeg() {
        return inboundLeg;
    }

    public void setInboundLeg(BoundLeg inboundLeg) {
        this.inboundLeg = inboundLeg;
    }

    public String getQuoteDateTime() {
        return quoteDateTime;
    }

    public void setQuoteDateTime(String quoteDateTime) {
        quoteDateTime = quoteDateTime;
    }
}
