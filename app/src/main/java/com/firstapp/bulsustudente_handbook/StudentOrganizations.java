package com.firstapp.bulsustudente_handbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentOrganizations extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentOrgAdapter adapter;
    List<StudentOrg> orgList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_org);

        // Get header views
        ImageView menuIcon = findViewById(R.id.menu_icon);

        TextView title = findViewById(R.id.header_title);

        recyclerView = findViewById(R.id.recyclerOrganizations);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);


        orgList = new ArrayList<>();
        orgList.add(new StudentOrg(
                "ASICS",
                "Alliance of Students in Information and Computing Sciences",
                R.drawable.asics_final,

                "ENGR. ROBIN ARNOLD DC. ESTEBAN",
                "ASICS Adviser",
                R.drawable.ic_placeholder,

                "LANCE AMIEL SAMANIEGO",
                "ASICS President",
                R.drawable.ic_placeholder,

                "https://www.facebook.com/bulsu.asics",
                "bulsu.asics@gmail.com"
        ));

        orgList.add(new StudentOrg(
        "AIES",
        "Association of Industrial Engineering Students ",
        R.drawable.aies_logo,

         "ENGR. ALTICH B. PAGATPAT",
        "AIES Adviser",
                R.drawable.ic_placeholder,

                "JAMYL MARK DP. INDON",
                "AIES President",
                R.drawable.ic_placeholder,
"https://www.facebook.com/aiesbustos", "aiesbulsubustos@gmail.com"

       ));


        orgList.add(new StudentOrg("ASSET",
                "Association of Skilled Students for Excellence in Technology",
                R.drawable.asset_logo,
                "DR. ALBERT C. SANTOS",
                "ASSET Adviser",
                R.drawable.ic_placeholder,

                "NINA RYZEL CAOILI",
                "ASSET President",
                R.drawable.ic_placeholder,

                "https://www.facebook.com/ASSETBSUBustos",
                "assetbsubustos@gmail.com"
                ));


        orgList.add(new StudentOrg("BBT-BC", "BulSU-Bound Tails Bustos Campus", R.drawable.bbt_logo,
        "MR. FERNANDO F. TADEO IV", "BBT Adviser", R.drawable.ic_placeholder,
                "LIBERTY ELAINE ALFONSO", "BBT President", R.drawable.aies_logo,
                "https://www.facebook.com/BBTBustos", "bulsuboundtailsbustoscampus@gmail.com"));


        orgList.add(new StudentOrg("FMSO", "Financial Management Student Organization", R.drawable.fmso_logo,
                "MR. JOHN CLIFFORD LANDAGORA", "FMSO Adviser", R.drawable.ic_placeholder,
                "RONNELA JANE LIBUNA", "FMSO President", R.drawable.ic_placeholder,
                "https://www.facebook.com/FMSOBulSUBustos", "https://www.facebook.com/FMSOBulSUBustos"));

        orgList.add(new StudentOrg("GLEE", "Guild of Leading Elementary Educators", R.drawable.glee_logo,
                "DR. JOSEPH BARTOLOME", "Glee Adviser", R.drawable.ic_placeholder,
                "SHAZNAE CAO", "Glee President", R.drawable.ic_placeholder,
                "https://www.facebook.com/GLEE2019", "Guildofleadingelementaryeducat@gmail.com"));

        orgList.add(new StudentOrg("GREATS", "Guilds of Resourceful Environmental Artistic and Talented Students", R.drawable.greats_logo,
                "MRS. REA DELA CRUZ", "GREATS Adviser", R.drawable.ic_placeholder,
                "SARAH SANCHEZ", "GREATS President", R.drawable.ic_placeholder,
                "https://www.facebook.com/bulsuOSOgreats", "greatsorg@gmail.com"));


//        orgList.add(new StudentOrg("INSIGHT", "Innovative Network of Students in Information & Global Analytics for Holistic Transformation", R.drawable.insight_logo));
//        orgList.add(new StudentOrg("ICPEP.SE BC", "Institute of Computer Engineers of the Philippines Student Edition - BulSU Bustos Chapter", R.drawable.icpep_logo));
//        orgList.add(new StudentOrg("JOBS", "Junior Organization of Business StudentsJunior Organization of Business Students", R.drawable.jobs_logo));
//        orgList.add(new StudentOrg("LIFE", "League of Impeccable Future Entrepreneurs", R.drawable.life_logo));
//        orgList.add(new StudentOrg("LFC", "Lingua Franca Club", R.drawable.lfc_logo));
//        orgList.add(new StudentOrg("MMSO", "Marketing Management Student Organization", R.drawable.mmso_logo));
//        orgList.add(new StudentOrg("OMG", "Organization of Math Geniuses", R.drawable.omg_logo));
//        orgList.add(new StudentOrg("PLUMAP", "Progresibong Lupon ng mga Mag-Aaral sa Araling Panlipunan", R.drawable.plumap_logo));
//        orgList.add(new StudentOrg("Samo't Sari", "Samo't Sari", R.drawable.samotsari_logo));
//        orgList.add(new StudentOrg("SCIRE", "Science Club in Real Essence", R.drawable.scire_logo));
//        orgList.add(new StudentOrg("SFED", "Society of Future Educators", R.drawable.sfed_logo));
//        orgList.add(new StudentOrg("SOMAPHED", "Society of Modified and Artistic Physical Educators", R.drawable.somaphed_logo));
//        orgList.add(new StudentOrg("YTR", "Youth on the Rock", R.drawable.ytr_logo));



        adapter = new StudentOrgAdapter(orgList, new StudentOrgAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(StudentOrg org) {
                // Open the detail activity when an item is clicked
                Intent intent = new Intent(StudentOrganizations.this, StudentOrgDetailActivity.class);
                intent.putExtra("orgTitle", org.title);
                intent.putExtra("orgDescription", org.description);
                intent.putExtra("orgImage", org.image);

                intent.putExtra("adviserName", org.adviserName);
                intent.putExtra("adviserRole", org.adviserPosition);
                intent.putExtra("adviserImage", org.adviserProfile);

                intent.putExtra("presName", org.presidentName);
                intent.putExtra("presRole", org.presidentCourse);
                intent.putExtra("presImage", org.presidentProfile);

                intent.putExtra("facebook", org.fbLink);
                intent.putExtra("email", org.email);

                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
        // Set header values dynamically

        title.setText("STUDENT ORGANIZATIONS");


        // Optional: handle back arrow click
        menuIcon.setOnClickListener(v -> finish());
    }
}
