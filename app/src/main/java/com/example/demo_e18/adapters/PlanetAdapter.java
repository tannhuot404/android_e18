package com.example.demo_e18.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_e18.R;
import com.example.demo_e18.models.PlanetModel;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private List<PlanetModel> data;
    private OnItemClickListener itemClickListener;

    public PlanetAdapter(List<PlanetModel> data, OnItemClickListener itemClickListener) {
        this.data = data;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_planet_item,
                        parent,
                        false);
        return new PlanetAdapter.PlanetViewHolder(itemView, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class PlanetViewHolder extends  RecyclerView.ViewHolder {
        private ImageView imgView;
        private TextView txtName;
        private TextView txtTotalMoon;
        public PlanetViewHolder(@NonNull View itemView, OnItemClickListener itemClickListener) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
            txtName = itemView.findViewById(R.id.tvName);
            txtTotalMoon = itemView.findViewById(R.id.tvTotalMoon);

            itemView.setOnClickListener(v -> {
                if (itemClickListener != null) {
                    int postion = getBindingAdapterPosition();

                    if (postion != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(postion);
                    }
                }
            });
        }

        public void setData(PlanetModel item) {
            imgView.setImageResource(item.getImage());
            txtName.setText(item.getName());

            txtTotalMoon.setText(item.getTotalMoon() + (item.getTotalMoon() > 1 ? " Moons" : " Moon"));
        }
    }
}
