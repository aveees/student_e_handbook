package com.firstapp.bulsustudente_handbook;
import com.bumptech.glide.Glide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentOrgAdapter extends RecyclerView.Adapter<StudentOrgAdapter.ViewHolder> {

    private List<StudentOrg> orgList;

    // Add a listener interface
    public interface OnItemClickListener {
        void onItemClick(StudentOrg org);
    }

    private OnItemClickListener listener;

    public StudentOrgAdapter(List<StudentOrg> orgList, OnItemClickListener listener) {
        this.orgList = orgList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student_org, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentOrg org = orgList.get(position);
        holder.orgTitle.setText(org.title);
        holder.orgDescription.setText(org.description);

        // Load circular image using Glide (prevents memory issues)
        Glide.with(holder.orgImage.getContext())
                .load(org.image)
                .circleCrop()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(holder.orgImage);

        // Set click listener for the item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(org);
        });
    }

    @Override
    public int getItemCount() {
        return orgList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView orgImage;
        TextView orgTitle, orgDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orgImage = itemView.findViewById(R.id.orgImage);
            orgTitle = itemView.findViewById(R.id.orgTitle);
            orgDescription = itemView.findViewById(R.id.orgDescription);
        }
    }
}

