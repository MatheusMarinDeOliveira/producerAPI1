package entities.browsequotes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currencies {
    @JsonProperty("Code")
    private String code;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("ThousandsSeparator")
    private String thousandsSeparator;

    @JsonProperty("DecimalSeparator")
    private String decimalSeparator;

    @JsonProperty("SymbolOnLeft")
    private String symbolOnLeft;

    @JsonProperty("SpaceBetweenAmountAndSymbol")
    private String spaceBetweenAmountAndSymbol;

    @JsonProperty("RoundingCoefficient")
    private String roundingCoefficient;

    @JsonProperty("DecimalDigits")
    private String decimalDigits;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public void setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getSymbolOnLeft() {
        return symbolOnLeft;
    }

    public void setSymbolOnLeft(String symbolOnLeft) {
        this.symbolOnLeft = symbolOnLeft;
    }

    public String getSpaceBetweenAmountAndSymbol() {
        return spaceBetweenAmountAndSymbol;
    }

    public void setSpaceBetweenAmountAndSymbol(String spaceBetweenAmountAndSymbol) {
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    }

    public String getRoundingCoefficient() {
        return roundingCoefficient;
    }

    public void setRoundingCoefficient(String roundingCoefficient) {
        this.roundingCoefficient = roundingCoefficient;
    }

    public String getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(String decimalDigits) {
        this.decimalDigits = decimalDigits;
    }
}
