package com.firstapp.bulsustudente_handbook;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class StudentsConductResponsibilitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_conduct_responsibilities);

        // Setup the standard header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            headerTitle.setText("Students' Conduct and Responsibilities");
        }
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // --- CORRECTED: Style the list items with unique IDs ---
        styleListItem(R.id.scr_value_1, "1.");
        styleListItem(R.id.scr_value_2, "2.");
        styleListItem(R.id.scr_value_3, "3.");
        styleListItem(R.id.scr_value_4, "4.");
        styleListItem(R.id.scr_value_5, "5.");
        styleListItem(R.id.scr_value_6, "6.");
        styleListItem(R.id.scr_value_7, "7.");
        styleListItem(R.id.scr_value_8, "8.");
        styleListItem(R.id.scr_value_9, "9.");
        styleListItem(R.id.scr_value_10, "10.");
    }

    /**
     * Finds a TextView and makes the leading number/letter bold using a custom font.
     * @param textViewId The R.id of the TextView to style.
     * @param boldPart The string part to make bold (e.g., "1.", "10.").
     */
    private void styleListItem(int textViewId, String boldPart) {
        TextView textView = findViewById(textViewId);
        if (textView == null) return;

        SpannableString spannable = new SpannableString(textView.getText());
        int length = boldPart.length();

        // Use montserrat_bold for the bold part
        Typeface boldTypeface = ResourcesCompat.getFont(this, R.font.montserrat_bold);
        spannable.setSpan(new CustomTypefaceSpan(boldTypeface), 0, length, SpannableString.SPAN_INCLUSIVE_INCLUSIVE);

        textView.setText(spannable);
    }
}
