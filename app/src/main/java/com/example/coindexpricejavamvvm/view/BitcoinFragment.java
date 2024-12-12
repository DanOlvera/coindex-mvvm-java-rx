package com.example.coindexpricejavamvvm.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coindexpricejavamvvm.R;
import com.example.coindexpricejavamvvm.model.data.BitcoinResponse;
import com.example.coindexpricejavamvvm.viewmodel.BitcoinViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class BitcoinFragment extends Fragment {
    private RecyclerView recyclerView;
    private BitcoinAdapter bitcoinAdapter;
    private BitcoinViewModel bitcoinViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_bitcoin, container, false);
        recyclerView = root.findViewById(R.id.bitcoinRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bitcoinViewModel = new ViewModelProvider(this).get(BitcoinViewModel.class);

        bitcoinViewModel.getBitcoinResponse().observe(getViewLifecycleOwner(), response -> {
            List<BitcoinResponse> bitcoinList = new ArrayList<>();
            for (int i = 0; i < 5; i++) { // Duplicate it 5 times
                bitcoinList.add(response);
            }
            bitcoinAdapter = new BitcoinAdapter(bitcoinList);
            recyclerView.setAdapter(bitcoinAdapter);
        });

        return root;
    }
}