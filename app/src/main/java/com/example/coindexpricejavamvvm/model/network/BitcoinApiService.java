package com.example.coindexpricejavamvvm.model.network;

import com.example.coindexpricejavamvvm.model.data.BitcoinResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

// https://api.coindesk.com/v1/bpi/currentprice.json
public interface BitcoinApiService {

    @GET("currentprice.json")
    Single<BitcoinResponse> getCurrentPrice();
}
