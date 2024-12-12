package com.example.coindexpricejavamvvm.viewmodel;

import com.example.coindexpricejavamvvm.model.data.BitcoinResponse;
import com.example.coindexpricejavamvvm.repo.BitcoinRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BitcoinViewModel extends ViewModel {

    private final BitcoinRepository bitcoinRepository;

    private final MutableLiveData<BitcoinResponse> _bitcoinLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> _errorLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();

    public BitcoinViewModel() {
        this.bitcoinRepository = new BitcoinRepository();

        loadBitcoins();
    }

    private void loadBitcoins() {
        disposable.add(
                bitcoinRepository.getBitcoinResponse()
                        .subscribe(
                                _bitcoinLiveData::setValue,
                                throwable -> _errorLiveData.setValue("Failed to load posts")
                        )
        );
    }

    public LiveData<BitcoinResponse> getBitcoinResponse() {
        return _bitcoinLiveData;
    }

    public LiveData<String> getErrorResponse() {
        return _errorLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
