package com.firstapp.bulsustudente_handbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private final List<String> titles;
    private final Context context;

    public SectionAdapter(Context context, List<String> titles) {
        this.context = context;
        this.titles = titles;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.section_card_item, parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder holder, int position) {
        String title = titles.get(position);
        holder.title.setText(title);

        // Handle click to open corresponding Activity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = null;

            switch (title) {
                case "INSTITUTIONAL PHILOSOPHY":
                    intent = new Intent(context, InstitutionalPhilosophyActivity.class);
                    break;

                case "POLICY STATEMENTS":
                    intent = new Intent(context, PolicyStatementsActivity.class);
                    break;
//
                case "CLASSIFICATION OF STUDENTS":
                    intent = new Intent(context, ClassificationOfStudentsActivity.class);
                    break;
//
                case "STUDENT'S RIGHTS, OBLIGATIONS, AND RESPONSIBILITIES":
                    intent = new Intent(context, StudentRightsObligationsActivity.class);
                    break;

//
                case "OBEDIENCE TO THE LAWS OF THE LAND":
                    intent = new Intent(context, ObedienceToLawsActivity.class);
                    break;

                case "STUDENTS' ORIENTATION":
                    intent = new Intent(context, StudentsOrientationActivity.class);
                    break;
            }

            if (intent != null) {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles != null ? titles.size() : 0;
    }

    static class SectionViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon, arrow;

        SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}
