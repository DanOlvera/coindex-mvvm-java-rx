package com.example.coindexpricejavamvvm.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coindexpricejavamvvm.R;
import com.example.coindexpricejavamvvm.model.data.BitcoinResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BitcoinAdapter extends RecyclerView.Adapter<BitcoinAdapter.BitcoinViewHolder> {

    private List<BitcoinResponse> bitcoinList;
    public BitcoinAdapter(List<BitcoinResponse> bitcoinList) {
        for (BitcoinResponse item:bitcoinList) {
            Log.d("Dang", "BitcoinAdapter: " + item.getBpi());
        }
        this.bitcoinList = bitcoinList;
    }

    @NonNull
    @Override
    public BitcoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bitcoin_item, parent, false);
        return new BitcoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BitcoinViewHolder holder, int position) {
        BitcoinResponse bitcoinResponse = bitcoinList.get(position);
        holder.time.setText(bitcoinResponse.getTime().getUpdated());
        holder.bpi.setText(bitcoinResponse.getBpi().getUsd().getDescription());
    }

    @Override
    public int getItemCount() {
        for (int i = 0; i < 5; i++) {
            bitcoinList.add(new BitcoinResponse());
        }
        return bitcoinList.size();
    }

    public class BitcoinViewHolder extends RecyclerView.ViewHolder {
        TextView time, bpi;
        public BitcoinViewHolder(@NonNull View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.bitcoinTime);
            bpi = itemView.findViewById(R.id.bitcoinBpi);
        }
    }
}
