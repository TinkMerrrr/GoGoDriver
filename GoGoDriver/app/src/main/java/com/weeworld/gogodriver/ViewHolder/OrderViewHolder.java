package com.weeworld.gogodriver.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.weeworld.gogodriver.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    public TextView txtOrderId, txtOrderStatus, txtOrderPhone, txtOrderAddress, txtOrderDate;
    public Button btn_shipping;


    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        txtOrderId = (TextView) itemView.findViewById(R.id.order_id);
        txtOrderStatus = (TextView) itemView.findViewById(R.id.order_status);
        txtOrderPhone = (TextView) itemView.findViewById(R.id.order_phone);
        txtOrderAddress = (TextView) itemView.findViewById(R.id.order_address);
        txtOrderDate = (TextView) itemView.findViewById(R.id.order_date);
        btn_shipping = itemView.findViewById(R.id.btn_shipping);

    }

}
