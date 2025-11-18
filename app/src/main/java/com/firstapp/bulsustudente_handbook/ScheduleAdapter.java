package com.firstapp.bulsustudente_handbook;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private Context mContext;
    private Cursor mCursor;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(long id);
        void onItemLongClick(long id, String subject);
        void onDeleteClick(long id, String subject);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ScheduleAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectText, dayText, timeText, roomText, professorText;
        public ImageView deleteButton; // The new delete button

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectText = itemView.findViewById(R.id.tv_subject);
            dayText = itemView.findViewById(R.id.tv_day);
            timeText = itemView.findViewById(R.id.tv_time);
            roomText = itemView.findViewById(R.id.tv_room);
            professorText = itemView.findViewById(R.id.tv_professor);
            deleteButton = itemView.findViewById(R.id.iv_delete_schedule);

            itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mCursor.moveToPosition(position);
                        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry._ID));
                        mListener.onItemClick(id);
                    }
                }
            });

            // --- Click listener for the delete button ---
            deleteButton.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mCursor.moveToPosition(position);
                        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry._ID));
                        String subject = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_SUBJECT));
                        mListener.onDeleteClick(id, subject);
                    }
                }
            });

            itemView.setOnLongClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mCursor.moveToPosition(position);
                        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry._ID));
                        String subject = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_SUBJECT));
                        mListener.onItemLongClick(id, subject);
                        return true; // Consume the long click
                    }
                }
                return false;
            });
        }
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.schedule_item, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String subject = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_SUBJECT));
        String day = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_DAY));
        String startTime = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_TIME));
        String endTime = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_TIME));
        String room = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_ROOM));
        String professor = mCursor.getString(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_PROFESSOR));
        long id = mCursor.getLong(mCursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry._ID));

        holder.itemView.setTag(id);
        holder.subjectText.setText(subject);
        holder.dayText.setText(day);
        holder.timeText.setText(startTime + " - " + endTime);
        holder.roomText.setText("Room: " + room);
        holder.professorText.setText(professor);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}
