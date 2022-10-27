package com.test.testtask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.test.testtask.database.model.Reponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class ReponseAdapter extends RecyclerView.Adapter<ReponseAdapter.BalanceViewHolder>{
    private List<Reponse> reponses;
    public ReponseAdapter(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    @NonNull
    @Override
    public BalanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BalanceViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_code, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull BalanceViewHolder holder, int position) {
        Reponse code= reponses.get(position);
        holder.code.setText(code.getCode());
    }

    @Override
    public int getItemCount() {
         return reponses == null? 0: reponses.size();
    }

    public static class BalanceViewHolder extends RecyclerView.ViewHolder {
        TextView code;
        public BalanceViewHolder(View itemView) {
            super(itemView);
            code = itemView.findViewById(R.id.code);
        }
    }
}


