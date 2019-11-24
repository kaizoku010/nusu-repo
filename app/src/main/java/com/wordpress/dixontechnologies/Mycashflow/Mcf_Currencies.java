package com.wordpress.dixontechnologies.Mycashflow;

/**
 * Created by ${Dixon} on 2/24/2017.
 */
public class Mcf_Currencies {

    private final String symbol;
    private final String desc;

    public Mcf_Currencies(String symbol, String desc){
        this.symbol = symbol;
        this.desc = desc;
}

    public String getSymbol() {
        return symbol;
    }

    public String getDesc() {
        return desc;
    }
}

