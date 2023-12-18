package com.example.healthcare2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healthcare2.R;
import com.example.healthcare2.data.model.Medicine;
import com.example.healthcare2.databinding.ItemMedicinesBinding;

import java.util.List;

public class MedicinesAdapter extends RecyclerView.Adapter<MedicinesAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Medicine> list;
    private int layout;

    public MedicinesAdapter(Context context, List<Medicine> list, int layout) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMedicinesBinding binding = ItemMedicinesBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicine medicine = list.get(position);
        holder.bind(medicine);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemMedicinesBinding binding;

        public ViewHolder(@NonNull ItemMedicinesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Medicine medicine) {
            Glide.with(context)
                    .load(medicine.getImg())
                    .into(binding.imageMedicines);
            binding.txtName.setText(medicine.getNameMedicine());
            binding.txtPrice.setText(String.valueOf(medicine.getPrice()));
        }
        public void setStar(Medicine medicine, float rating) {
            if (rating > 0 && rating <= 0.5) {
                setNumberStar(0.5f);
            } else if (rating > 0.5 && rating <= 1) {
                setNumberStar(1f);
            } else if (rating > 1 && rating <= 1.5) {
                setNumberStar(1.5f);
            } else if (rating > 1.5 && rating <= 2) {
                setNumberStar(2f);
            } else if (rating > 2 && rating <= 2.5) {
                setNumberStar(2.5f);
            } else if (rating > 2.5 && rating <= 3) {
                setNumberStar(3f);
            } else if (rating > 3 && rating <= 3.5) {
                setNumberStar(3.5f);
            } else if (rating > 3.5 && rating <= 4) {
                setNumberStar(4f);
            } else if (rating > 4 && rating <= 4.5) {
                setNumberStar(4.5f);
            } else {
                setNumberStar(5f);
            }
        }

        public void setNumberStar(float star) {
            if (star == 0){
                binding.icSao1.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao2.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao3.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 0.5) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_nuasao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao3.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 1) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao3.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 1.5) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_nuasao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 2) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 2.5) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_nuasao);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 3) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao4.setImageResource(R.drawable.ic_vector_saorong);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 3.5) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao4.setImageResource(R.drawable.ic_vector_nuasao);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 4) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao4.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao5.setImageResource(R.drawable.ic_vector_saorong);
            } else if(star == 4.5) {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao4.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao5.setImageResource(R.drawable.ic_vector_nuasao);
            } else {
                binding.icSao1.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao2.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao3.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao4.setImageResource(R.drawable.ic_vector_sao);
                binding.icSao5.setImageResource(R.drawable.ic_vector_sao);
            }
        }
    }
}
