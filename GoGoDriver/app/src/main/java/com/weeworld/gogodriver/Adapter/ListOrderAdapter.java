package com.weeworld.gogodriver.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weeworld.gogodriver.Model.ListOrderModel;
import com.weeworld.gogodriver.R;

import java.util.List;

public class ListOrderAdapter extends RecyclerView.Adapter<ListOrderAdapter.ViewHolder> {

    Context context;
    List<ListOrderModel> listOrderModelList;

    public ListOrderAdapter(Context context, List<ListOrderModel> listOrderModelList) {
        this.context = context;
        this.listOrderModelList = listOrderModelList;
    }

    @NonNull
    @Override
    public ListOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_order, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListOrderAdapter.ViewHolder holder, int position) {
        holder.NameOrder.setText(listOrderModelList.get(position).getFullnameUser());
        holder.PhoneOrder.setText(listOrderModelList.get(position).getNumberPhone());
        holder.AddressOrder.setText(listOrderModelList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return listOrderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Status , NameOrder , PhoneOrder , AddressOrder;
        ///Button ship;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            NameOrder = itemView.findViewById(R.id.nameUser_Order);
            PhoneOrder = itemView.findViewById(R.id.Phone_Order);
            AddressOrder = itemView.findViewById(R.id.Address_Order);
            //Status = itemView.findViewById(R.id.Status_Order);
            //ship = itemView.findViewById(R.id.btn_shipping);

        }
    }
}
