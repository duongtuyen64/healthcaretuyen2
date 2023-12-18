package com.example.healthcare2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare2.R;
import com.example.healthcare2.data.model.Post;
import com.example.healthcare2.databinding.ItemPostHomeBinding;

import java.util.List;

public class PostHomeAdapter extends RecyclerView.Adapter<PostHomeAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Post> list;
    private int layout;

    public PostHomeAdapter(Context context, List<Post> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostHomeBinding binding = ItemPostHomeBinding.inflate(inflater, parent, false);
//        ViewHolder viewHolder = new ViewHolder();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = list.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemPostHomeBinding binding;

        public ViewHolder(@NonNull ItemPostHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Post post) {
            binding.txtTitle.setText(post.getTitle());
            // Set other data to binding views
        }
    }
}
