package com.firstapp.bulsustudente_handbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private final List<CardItem> cardList;

    public CardAdapter(List<CardItem> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_item, parent, false); // your card layout
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = cardList.get(position);
        holder.icon.setImageResource(item.getIconResId());
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        holder.readMore.setText("Read More →");

        // --- Handle click events ---
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            switch (item.getTitle()) {
                case "History of BulSU":
                    context.startActivity(new Intent(context, HistoryActivity.class));
                    break;
                case "BulSU Hymn and March":
                    context.startActivity(new Intent(context, HymnActivity.class));
                    break;
                case "Academic Regulations":
                    context.startActivity(new Intent(context, AcademicRegulationsActivity.class));
                    break;
                case "General Provisions":
                    context.startActivity(new Intent(context, GeneralProvisionsActivity.class));
                    break;
                case "Student Conduct and Discipline":
                    context.startActivity(new Intent(context, StudentConductActivity.class));
                    break;
//                case "Student Affairs and Services":
//                    context.startActivity(new Intent(context, StudentAffairsActivity.class));
//                    break;
//                case "Program, Faculty, and Curriculum":
//                    context.startActivity(new Intent(context, ProgramFacultyActivity.class));
//                    break;
//                case "Administrative Council and Non-Teaching Staff":
//                    context.startActivity(new Intent(context, AdminCouncilActivity.class));
//                    break;
                case "Student Organizations":
                    context.startActivity(new Intent(context, StudentOrganizationsActivity.class));
                    break;
                    /*
                case "Local Student Council":
                    context.startActivity(new Intent(context, LocalStudentCouncilActivity.class));
                    break;
                case "Directory & Institutional Services of BulSU-BC":
                    context.startActivity(new Intent(context, DirectoryActivity.class));
                    break;

                     */
                default:
                    Toast.makeText(context, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title, desc, readMore;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.card_icon);
            title = itemView.findViewById(R.id.card_title);
            desc = itemView.findViewById(R.id.card_desc);
            readMore = itemView.findViewById(R.id.read_more);
        }
    }
}
