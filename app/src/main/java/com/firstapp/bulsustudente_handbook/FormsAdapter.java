package com.firstapp.bulsustudente_handbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.FormViewHolder> {

    private final List<FormItem> formsList;
    private final OnDownloadClickListener listener;

    /**
     * Interface for handling click events on the download icon.
     */
    public interface OnDownloadClickListener {
        void onDownloadClick(FormItem item);
    }

    public FormsAdapter(List<FormItem> formsList, OnDownloadClickListener listener) {
        this.formsList = formsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_form_item, parent, false);
        return new FormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
        FormItem currentItem = formsList.get(position);

        // Set the form title
        holder.titleTextView.setText(currentItem.getTitle());

        // Set the click listener for the download icon
        holder.downloadIcon.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDownloadClick(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return formsList.size();
    }

    /**
     * ViewHolder class to hold references to the views in the card layout.
     */
    public static class FormViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView fileIcon;
        ImageView downloadIcon;

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.form_title);
            fileIcon = itemView.findViewById(R.id.form_file_icon);
            downloadIcon = itemView.findViewById(R.id.form_download_icon);
        }
    }
}