package com.example.healthcare2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare2.data.model.Notification;
import com.example.healthcare2.databinding.ItemNotificationBinding;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Notification> list;
    private int layout;

    public NotificationAdapter(Context context, List<Notification> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNotificationBinding binding = ItemNotificationBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notification notification = list.get(position);
        holder.bind(notification);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNotificationBinding binding;

        public ViewHolder(@NonNull ItemNotificationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Notification notification){
            binding.imgPicture.setImageResource(notification.getPicture());
            String content = "<b>"+notification.getName()+ "</b>" + " commented on your post abcg hghghghghgiigbnvbfytetyrfhjbnmb";
            binding.txtContent.setText(android.text.Html.fromHtml(content));
        }
    }
}
