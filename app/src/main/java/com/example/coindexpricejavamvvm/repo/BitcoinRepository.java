package com.example.coindexpricejavamvvm.repo;

import com.example.coindexpricejavamvvm.model.data.BitcoinResponse;
import com.example.coindexpricejavamvvm.model.network.BitcoinApiClient;
import com.example.coindexpricejavamvvm.model.network.BitcoinApiService;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BitcoinRepository {
    private final BitcoinApiService bitcoinApiService;

    public BitcoinRepository() {
        this.bitcoinApiService = BitcoinApiClient.getBitcoinApiService();
    }

    public Single<BitcoinResponse> getBitcoinResponse() {
        return bitcoinApiService.getCurrentPrice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
