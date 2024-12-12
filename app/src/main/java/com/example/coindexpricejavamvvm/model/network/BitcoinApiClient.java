package com.example.coindexpricejavamvvm.model.network;

import com.example.coindexpricejavamvvm.model.utils.ApiUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BitcoinApiClient {

    private static BitcoinApiService bitcoinApiService;

    //Singleton instance
    public static BitcoinApiService getBitcoinApiService() {
        if (bitcoinApiService == null) {
            //Retrofit instance
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();

            bitcoinApiService = retrofit.create(BitcoinApiService.class);
        }

        return bitcoinApiService;
    }
}
