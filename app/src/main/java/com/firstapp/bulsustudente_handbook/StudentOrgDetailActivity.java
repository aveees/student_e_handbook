package com.firstapp.bulsustudente_handbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentOrgDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_org_detail);

        // HEADER
        ImageView backArrow = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        TextView breadcrumbs = findViewById(R.id.breadcrumbs);

        // MAIN CONTENT VIEWS
        ImageView orgImage = findViewById(R.id.orgImage);
        TextView orgTitle = findViewById(R.id.orgTitle);
        TextView orgDescription = findViewById(R.id.orgDescription);

        ImageView adviserPic = findViewById(R.id.adviserPic);
        TextView adviserName = findViewById(R.id.adviserName);
        TextView adviserPosition = findViewById(R.id.adviserPosition);

        ImageView presidentPic = findViewById(R.id.presidentPic);
        TextView presidentName = findViewById(R.id.presidentName);
        TextView presidentPosition = findViewById(R.id.presidentPosition);

        TextView fbLink = findViewById(R.id.fbLink);
        TextView emailLink = findViewById(R.id.emailLink);

        // GET PASSED DATA
        Intent i = getIntent();

        // ORG BASICS
        String title = i.getStringExtra("orgTitle");
        orgTitle.setText(title);
        headerTitle.setText(title);

        breadcrumbs.setText("Student Organizations");
        orgDescription.setText(i.getStringExtra("orgDescription"));
        orgImage.setImageResource(i.getIntExtra("orgImage", 0));

        // ADVISER
        adviserName.setText(i.getStringExtra("adviserName"));
        adviserPosition.setText(i.getStringExtra("adviserRole"));
        adviserPic.setImageResource(i.getIntExtra("adviserImage", 0));

        // PRESIDENT
        presidentName.setText(i.getStringExtra("presName"));
        presidentPosition.setText(i.getStringExtra("presRole"));
        presidentPic.setImageResource(i.getIntExtra("presImage", 0));

        // SOCIAL LINKS
        fbLink.setText(i.getStringExtra("facebook"));
        emailLink.setText(i.getStringExtra("email"));

        // BACK BUTTON
        backArrow.setOnClickListener(v -> finish());
    }
}
