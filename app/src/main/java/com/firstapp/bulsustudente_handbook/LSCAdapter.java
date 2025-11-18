// LSCAdapter.java
package com.firstapp.bulsustudente_handbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LSCAdapter extends RecyclerView.Adapter<LSCAdapter.ViewHolder> {

    private final List<LSCOfficer> officers;

    public LSCAdapter(List<LSCOfficer> officers) {
        this.officers = officers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leader_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LSCOfficer officer = officers.get(position);

        // Set main info
        holder.name.setText(officer.getName());
        holder.position.setText(officer.getPosition());
        holder.image.setImageResource(officer.getImageResId());

        // Set dropdown info
        holder.action1.setText(officer.getCredential());
        holder.action2.setText(officer.getCourse());

        // Initially hide dropdown
        holder.dropdownContent.setVisibility(View.GONE);

        // Toggle dropdown visibility
        holder.dropdownButton.setOnClickListener(v -> {
            if (holder.dropdownContent.getVisibility() == View.VISIBLE) {
                holder.dropdownContent.setVisibility(View.GONE);
                holder.dropdownButton.setRotation(0); // optional: rotate arrow back
            } else {
                holder.dropdownContent.setVisibility(View.VISIBLE);
                holder.dropdownButton.setRotation(180); // optional: rotate arrow down
            }
        });

        // Optional: collapse dropdown when clicking outside (requires parent container setup)
    }

    @Override
    public int getItemCount() {
        return officers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView name, position, action1, action2;
        final ImageButton dropdownButton;
        final LinearLayout dropdownContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.leader_image);
            name = itemView.findViewById(R.id.leader_name);
            position = itemView.findViewById(R.id.leader_position);
            action1 = itemView.findViewById(R.id.action1);
            action2 = itemView.findViewById(R.id.action2);
            dropdownButton = itemView.findViewById(R.id.leader_dropdown);
            dropdownContent = itemView.findViewById(R.id.dropdown_content);
        }
    }
}
