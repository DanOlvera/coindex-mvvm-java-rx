
package com.example.coindexpricejavamvvm.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bpi {

    @SerializedName("USD")
    @Expose
    private Usd usd;
    @SerializedName("GBP")
    @Expose
    private Gbp gbp;
    @SerializedName("EUR")
    @Expose
    private Eur eur;

    public Usd getUsd() {
        return usd;
    }

    public void setUsd(Usd usd) {
        this.usd = usd;
    }

    public Gbp getGbp() {
        return gbp;
    }

    public void setGbp(Gbp gbp) {
        this.gbp = gbp;
    }

    public Eur getEur() {
        return eur;
    }

    public void setEur(Eur eur) {
        this.eur = eur;
    }

}
