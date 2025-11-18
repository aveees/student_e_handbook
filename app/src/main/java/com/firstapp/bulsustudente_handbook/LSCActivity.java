// LSCActivity.java
package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LSCActivity extends AppCompatActivity {

    private RecyclerView officersRecyclerView;
    private LSCAdapter adapter;
    private ArrayList<LSCOfficer> officers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsc);

        // --- HEADER SETUP ---
        ImageView backArrow = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        TextView headerLine1 = findViewById(R.id.header_line1);
        TextView headerSubtitle = findViewById(R.id.header_subtitle);


        // Set header text

        headerTitle.setText("LOCAL STUDENT COUNCIL");



        // Back arrow closes the current activity
        backArrow.setOnClickListener(v -> finish());

        officersRecyclerView = findViewById(R.id.officersRecyclerView);
        officersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        officers = new ArrayList<>();
        officers.add(new LSCOfficer("DR. GLADILYN GARCIA-DULAY", "LSC Adviser", R.drawable.lsc_adv, "AFFILIATIONS: \nAdviser, BulSU Bustos Local Student Council ", "DEPARTMENT: Department of Education"));
        officers.add(new LSCOfficer("MERL ANJHELO DIMLA", "LSC Governor", R.drawable.lsc_gov, "AFFILIATIONS:\nGovernor, Bustos LSC" +
                "\nHead, Local Executive Branch\nAssociate, Sports and Athletic Development Committee", "COURSE: "));
        officers.add(new LSCOfficer("KAITH RAZEL PAYUMO", "LSC Vice Governor", R.drawable.lsc_vg, "AFFILIATIONS:\nVice Governor, Bustos LSC" +
                "\nHead, Local Legislative Body\nChairperson, Local Secretariat Committee\nChairperson, Local Sports and Athletics Committee\nAssociate, Mental Health Coalition\nAssociate, Bayanihan Tayo Committee", "COURSE: "));
        officers.add(new LSCOfficer("DANREY JEY MENDOZA", "BIT Board Member", R.drawable.lsc_bit, "AFFILIATIONS:\nChairperson, Local Public Relations and Societal Affairs" +
                "\nAssociate, Committee on Student Groups\nAssociate, Local Public Relations and Societal Affairs", "COURSE: Bachelor of Science in Industrial Technology"));
        officers.add(new LSCOfficer("DAN ANGELO GARCIA", "BIT Board Member", R.drawable.lsc_bit2, "AFFILIATIONS:\nChairperson, Local Mental Health Coalition" +
                "\nChairperson, Committee on Student Groups", "COURSE: Bachelor of Science in Industrial Technology"));
          officers.add(new LSCOfficer("JENOY MARIO SILVIO", "BSBA Board Member", R.drawable.lsc_bsba, "AFFILIATIONS:\nAssociate, Environmental Committee" +
                "\nChairperson,  Local Environmental Committee\nChairperson,  Local Student Health Affairs Committee", "COURSE: Bachelor of Science in Business Administration"));
        officers.add(new LSCOfficer("JAMIE LEE PALIGUTAN", "BSE Board Member", R.drawable.lsc_bse, "AFFILIATIONS:\nChairperson, Local Socio-Cultural Affairs Committe" +
                "\nSecretary,  Socio-Cultural Affairs Committee", "COURSE: Bachelor of Science in Entrepreneurship"));
        officers.add(new LSCOfficer("JHAMAICA PAGADUAN", "BEED Board Member", R.drawable.lse_beed, "AFFILIATIONS:\nChairperson, Local Students Rights and Welfare" +
                "\nChairperson,  Local Committee on Rules and Procedures\nChairperson, Local Graduation Committee\nAssociate, Bayanihan Tayo Committee\nAssociate, Bustos Sports and Development Committee", "COURSE: Bachelor of Science in Elementary Education"));
            officers.add(new LSCOfficer("YRRAH JADE TECSON", "BSED Board Member", R.drawable.lsc_bsed, "AFFILIATIONS:\nChairperson, Local Research and Development Committe"
               , "COURSE: Bachelor of Science in Entrepreneurship"));
        officers.add(new LSCOfficer("CHRISTIAN LHEAN PALADIN", "BPED/BTLED Board Member", R.drawable.lsc_bse, "AFFILIATIONS:\nChairperson, Local Bayanihan Tayo"
              , "COURSE: BPED/BTLED"));
        officers.add(new LSCOfficer("GODWINJOHN SAGALA", "Engineering Board Member", R.drawable.lsc_eng, "AFFILIATIONS:\nChairperson, Local Finance Committee\nChairperson, Local Gender Equality, Diversity, and Inclusion Committee\nAssociate, Environmental Committee"
                , "COURSE: Bachelor of science in Engineering"));
        officers.add(new LSCOfficer("REY MIGUEL QUEROL", "BSIT Board Member", R.drawable.lsc_bsit, "AFFILIATIONS:\nChairperson, Local Academic Affairs Committee\nChairperson, Local Ethics and Discipline Committee\nChairperson, Local Freshie Union" +
                "\nChairperson, Local Admission and Enrollment Committee\nAssociate, Ethics and Discipline Committee"
                , "COURSE: Bachelor of Science in Information Technology"));


        // Add more officers

        adapter = new LSCAdapter(officers);
        officersRecyclerView.setAdapter(adapter);

    }
}
