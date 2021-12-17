package com.weeworld.gogodriver.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weeworld.gogodriver.Model.MessageUserModel;
import com.weeworld.gogodriver.R;

import java.util.List;

public class MessageUserAdapter extends RecyclerView.Adapter<MessageUserAdapter.ViewHolder> {

    Context context;
    List<MessageUserModel> messageUserModelList;

    public MessageUserAdapter(Context context, List<MessageUserModel> messageUserModelList) {
        this.context = context;
        this.messageUserModelList = messageUserModelList;
    }

    @NonNull
    @Override
    public MessageUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_user, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageUserAdapter.ViewHolder holder, int position) {
        holder.name_user_message.setText(messageUserModelList.get(position).getMessageNameUser());
        holder.content_user_message.setText(messageUserModelList.get(position).getMessageText());
        holder.time_send_message.setText(Long.toString(messageUserModelList.get(position).getMessageTime()));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name_user_message, content_user_message, time_send_message ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_user_message = itemView.findViewById(R.id.name_message_User);
            content_user_message = itemView.findViewById(R.id.content_message_user);
            time_send_message = itemView.findViewById(R.id.time_send_message);
        }
    }
}
