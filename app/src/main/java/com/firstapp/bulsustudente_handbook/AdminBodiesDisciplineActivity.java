package com.firstapp.bulsustudente_handbook;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class AdminBodiesDisciplineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bodies_discipline);

        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            headerTitle.setText("Administrative Bodies");
        }
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }



        // --- Style list items to make bullets bold ---
        styleListItem(R.id.abd_sdec_comp_1, "•");
        styleListItem(R.id.abd_sdec_comp_2, "-");
        styleListItem(R.id.abd_sdec_comp_3, "-");
        styleListItem(R.id.abd_sdec_comp_4, "-");
        styleListItem(R.id.abd_sdec_comp_5, "-");

        styleListItem(R.id.abd_sdec_func_1, "•");
        styleListItem(R.id.abd_sdec_func_2, "•");
        styleListItem(R.id.abd_sdec_func_3, "•");
        styleListItem(R.id.abd_sdec_func_4, "•");

        styleListItem(R.id.abd_bsd_comp_1, "•");
        styleListItem(R.id.abd_bsd_comp_2, "-");
        styleListItem(R.id.abd_bsd_comp_3, "-");
        styleListItem(R.id.abd_bsd_comp_4, "-");
        styleListItem(R.id.abd_bsd_comp_5, "-");

        styleListItem(R.id.abd_bsd_func_1, "•");
        styleListItem(R.id.abd_bsd_func_2, "•");
        styleListItem(R.id.abd_bsd_func_3, "•");
        styleListItem(R.id.abd_bsd_func_4, "•");
        styleListItem(R.id.abd_bsd_func_5, "•");
        styleListItem(R.id.abd_bsd_func_6, "•");
        styleListItem(R.id.abd_bsd_func_7, "•");

        styleListItem(R.id.abd_proc_1, "•");
        styleListItem(R.id.abd_proc_2, "•");
        styleListItem(R.id.abd_proc_3, "•");
        styleListItem(R.id.abd_proc_4, "•");
        styleListItem(R.id.abd_proc_5, "•");
        styleListItem(R.id.abd_proc_6, "•");
        styleListItem(R.id.abd_proc_7, "•");
        styleListItem(R.id.abd_proc_8, "•");
        styleListItem(R.id.abd_proc_9, "•");
        styleListItem(R.id.abd_proc_10, "•");
        styleListItem(R.id.abd_proc_11, "•");
    }

    private void styleListItem(int textViewId, String boldPart) {
        TextView textView = findViewById(textViewId);
        if (textView == null) return;

        SpannableString spannable = new SpannableString(textView.getText());
        Typeface boldTypeface = ResourcesCompat.getFont(this, R.font.montserrat_bold);

        // This assumes you have the CustomTypefaceSpan class in your project
        spannable.setSpan(new CustomTypefaceSpan(boldTypeface), 0, boldPart.length(), SpannableString.SPAN_INCLUSIVE_INCLUSIVE);
        textView.setText(spannable);
    }
}
