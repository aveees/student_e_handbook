package com.firstapp.bulsustudente_handbook;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class RulesOfProcedureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_of_procedure);

        // Setup the standard header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            headerTitle.setText("Rules of Procedure");
        }
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // --- Style list items to make "Section X" bold ---
        // Rule 1
        styleListItem(R.id.rop_rule1_sec1, "Section 1.");
        styleListItem(R.id.rop_rule1_sec2, "Section 2.");
        styleListItem(R.id.rop_rule1_sec3, "Section 3.");
        styleListItem(R.id.rop_rule1_sec4, "Section 4.");

        // Rule 2
        styleListItem(R.id.rop_rule2_sec1, "Section 1.");
        styleListItem(R.id.rop_rule2_sec2, "Section 2.");
        styleListItem(R.id.rop_rule2_sec3, "Section 3.");
        styleListItem(R.id.rop_rule2_sec4, "Section 4.");
        styleListItem(R.id.rop_rule2_sec5, "Section 5.");

        // Rule 3
        styleListItem(R.id.rop_rule3_sec1, "Section 1.");
        styleListItem(R.id.rop_rule3_sec2, "Section 2.");
        styleListItem(R.id.rop_rule3_sec3, "Section 3.");
        styleListItem(R.id.rop_rule3_sec4, "Section 4.");
        styleListItem(R.id.rop_rule3_sec5, "Section 5.");
        styleListItem(R.id.rop_rule3_sec6, "Section 6.");
        styleListItem(R.id.rop_rule3_sec7, "Section 7.");

        // Rule 4
        styleListItem(R.id.rop_rule4_sec1, "Section 1.");
        styleListItem(R.id.rop_rule4_sec2, "Section 2.");
        styleListItem(R.id.rop_rule4_sec3, "Section 3.");
        styleListItem(R.id.rop_rule4_sec4, "Section 4.");
        styleListItem(R.id.rop_rule4_sec5, "Section 5.");
        styleListItem(R.id.rop_rule4_sec6, "Section 6.");

        // Rule 5
        styleListItem(R.id.rop_rule5_sec1, "Section 1.");
        styleListItem(R.id.rop_rule5_sec2, "Section 2.");
        styleListItem(R.id.rop_rule5_sec3, "Section 3.");
        styleListItem(R.id.rop_rule5_sec4, "Section 4.");
        styleListItem(R.id.rop_rule5_sec5, "Section 5.");
        styleListItem(R.id.rop_rule5_sec6, "Section 6.");

        // Rule 6
        styleListItem(R.id.rop_rule6_sec1, "Section 1.");
        styleListItem(R.id.rop_rule6_sec1_a, "a.");
        styleListItem(R.id.rop_rule6_sec1_b, "b.");
        styleListItem(R.id.rop_rule6_sec1_c, "c.");
        styleListItem(R.id.rop_rule6_sec1_d, "d.");
        styleListItem(R.id.rop_rule6_sec2, "Section 2.");
        styleListItem(R.id.rop_rule6_sec3, "Section 3.");
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
