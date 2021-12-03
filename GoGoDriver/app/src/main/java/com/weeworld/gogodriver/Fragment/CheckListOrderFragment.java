package com.weeworld.gogodriver.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.weeworld.gogodriver.Adapter.ListOrderAdapter;
import com.weeworld.gogodriver.Model.ListOrderModel;
import com.weeworld.gogodriver.R;

import java.util.ArrayList;
import java.util.List;

public class CheckListOrderFragment extends Fragment {

    RecyclerView recyclerViewCheckListOrder;
    List<ListOrderModel> listOrderModelList;
    ListOrderAdapter listOrderAdapter;

    //Khai báo Firebase
    FirebaseDatabase database;
    DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_check_list_order, container, false);

        recyclerViewCheckListOrder = root.findViewById(R.id.listOrderCheck_Rec);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("OrderDetails");


        recyclerViewCheckListOrder.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        listOrderModelList = new ArrayList<>();
        listOrderAdapter = new ListOrderAdapter(getActivity(), listOrderModelList);
        recyclerViewCheckListOrder.setAdapter(listOrderAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for( DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ListOrderModel OrderModel = dataSnapshot.getValue(ListOrderModel.class);
                    listOrderModelList.add(OrderModel);
                }

                listOrderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return root;
    }
}