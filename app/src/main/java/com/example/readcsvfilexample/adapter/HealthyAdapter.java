package com.example.readcsvfilexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readcsvfilexample.R;
import com.example.readcsvfilexample.model.HealthyData;

import java.util.ArrayList;
import java.util.List;

public class HealthyAdapter extends RecyclerView.Adapter<HealthyAdapter.HealthyHolder> {

    private Context context;
    private List<HealthyData> dataList = new ArrayList<>();

    public HealthyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HealthyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false);
        return new HealthyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthyHolder holder, int position) {
        HealthyData data = dataList.get(position);
        holder.tvName.setText(data.getName());
        holder.tvCode.setText(data.getCode());
        holder.tvAddress.setText(data.getAddress());
        holder.tvPhone.setText(data.getPhone());
        holder.tvType.setText(data.getType());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setDataList(List<HealthyData> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    class HealthyHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvCode, tvAddress, tvPhone, tvType;

        public HealthyHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvType = itemView.findViewById(R.id.tv_type);
        }
    }

}
