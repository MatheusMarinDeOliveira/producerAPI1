package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currencies {
    @JsonProperty("Code")
    public String code;

    @JsonProperty("Symbol")
    public String symbol;

    @JsonProperty("ThousandsSeparator")
    public String thousandsSeparator;

    @JsonProperty("DecimalSeparator")
    public String decimalSeparator;

    @JsonProperty("SymbolOnLeft")
    public String symbolOnLeft;

    @JsonProperty("SpaceBetweenAmountAndSymbol")
    public String spaceBetweenAmountAndSymbol;

    @JsonProperty("RoundingCoefficient")
    public String roundingCoefficient;

    @JsonProperty("DecimalDigits")
    public String decimalDigits;

}
