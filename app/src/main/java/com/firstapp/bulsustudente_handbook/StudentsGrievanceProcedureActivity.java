package com.firstapp.bulsustudente_handbook;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class StudentsGrievanceProcedureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_grievance_procedure);

        // Setup the standard header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            headerTitle.setText("Students' Grievance Procedure");
        }
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // --- Style list items to make bullets bold ---
        styleListItem(R.id.sgp_proc_1, "•");
        styleListItem(R.id.sgp_proc_2, "•");
        styleListItem(R.id.sgp_proc_3, "•");
        styleListItem(R.id.sgp_proc_4, "•");
        styleListItem(R.id.sgp_proc_5, "•");
        styleListItem(R.id.sgp_proc_6, "•");
    }

    private void styleListItem(int textViewId, String boldPart) {
        TextView textView = findViewById(textViewId);
        if (textView == null) return;

        SpannableString spannable = new SpannableString(textView.getText());
        int length = boldPart.length();

        Typeface boldTypeface = ResourcesCompat.getFont(this, R.font.montserrat_bold);
        if (boldTypeface != null) {
            // This assumes you have the CustomTypefaceSpan class in your project
            spannable.setSpan(new CustomTypefaceSpan(boldTypeface), 0, length, SpannableString.SPAN_INCLUSIVE_INCLUSIVE);
        }
        textView.setText(spannable);
    }
}
