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
        "MR. FERNANDO F. TADEO IV", "BBT Adviser",R.drawable.profile_circle_bg,
                "LIBERTY ELAINE ALFONSO", "BBT President", R.drawable.profile_circle_bg,
                "https://www.facebook.com/BBTBustos", "bulsuboundtailsbustoscampus@gmail.com"));


        orgList.add(new StudentOrg("FMSO", "Financial Management Student Organization", R.drawable.fmso_logo,
                "MR. JOHN CLIFFORD LANDAGORA", "FMSO Adviser", R.drawable.profile_circle_bg,
                "RONNELA JANE LIBUNA", "FMSO President", R.drawable.profile_circle_bg,
                "https://www.facebook.com/FMSOBulSUBustos", "https://www.facebook.com/FMSOBulSUBustos"));

        orgList.add(new StudentOrg("GLEE", "Guild of Leading Elementary Educators", R.drawable.glee_logo,
                "DR. JOSEPH BARTOLOME", "Glee Adviser", R.drawable.profile_circle_bg,
                "SHAZNAE CAO", "Glee President", R.drawable.profile_circle_bg,
                "https://www.facebook.com/GLEE2019", "Guildofleadingelementaryeducat@gmail.com"));

        orgList.add(new StudentOrg("GREATS", "Guilds of Resourceful Environmental Artistic and Talented Students", R.drawable.greats_logo,
                "MRS. REA DELA CRUZ", "GREATS Adviser", R.drawable.profile_circle_bg,
                "SARAH SANCHEZ", "GREATS President", R.drawable.profile_circle_bg,
                "https://www.facebook.com/bulsuOSOgreats", "greatsorg@gmail.com"));


        orgList.add(new StudentOrg("INSIGHT", "Innovative Network of Students in Information & Global Analytics for Holistic Transformation", R.drawable.insight_logo,
        "DR. JENNIFER P. SOLIS", "INSIGHT Adviser", R.drawable.ic_placeholder,
        "ELAIZA MAE RODRIGUEZ", "INSIGHT President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/profile.php?id=61580290132042", "Insightbulsubustos@gmail.com"));

        orgList.add(new StudentOrg("ICPEP.SE BC", "Institute of Computer Engineers of the Philippines Student Edition - BulSU Bustos Chapter", R.drawable.icpep_logo,
        "ENGR. RYAN NOLASCO", "ICPEP.SE Adviser", R.drawable.profile_circle_bg,
        "SHAINE RONLAI I. CASTRO", "ICPEP.SE President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/IcpepseBustos", "icpep.sebustos@gmail.com"));


        orgList.add(new StudentOrg("JOBS", "Junior Organization of Business StudentsJunior Organization of Business Students", R.drawable.jobs_logo,
        "MS. MARYGOLD Q. PAULINO, MBA", "JOBS Adviser", R.drawable.profile_circle_bg,
        "KAREN LHELLAINE N. GIRON", "JOBS President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/profile.php?id=61577012910279", "bulsu.bustos.jobs@gmail.com"));

        orgList.add(new StudentOrg("LIFE", "League of Impeccable Future Entrepreneurs", R.drawable.life_logo,
        "MR. ROMNICK S. CRUZ", "LIFE Adviser", R.drawable.profile_circle_bg,
        "ELLIMIE M. LOPEZ", "LIFE Presdient", R.drawable.profile_circle_bg,
        "https://www.facebook.com/bulsubustos.life","life.of.bulsu.bustos@gmail.com"));

        orgList.add(new StudentOrg("LFC", "Lingua Franca Club", R.drawable.lfc_logo,
        "MR. KEN ROBIN D. TORRES", "LFC Adviser", R.drawable.profile_circle_bg,
        "AL FRANCIS B. DE LEON", "LFC President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/LinguaFrancaClubBSUBustos","archiveslfc@gmail.com"));

        orgList.add(new StudentOrg("MMSO", "Marketing Management Student Organization", R.drawable.mmso_logo,
        "MR. GERVIN R. ALFONSO", "MMSO Adviser", R.drawable.profile_circle_bg,
        "LEANNE DENISE I. SANTIAGO", "MMSO President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/BSUMMSO","marketingmngtstudentsorg@gmail.com"));

        orgList.add(new StudentOrg("OMG", "Organization of Math Geniuses", R.drawable.omg_logo,
        "MRS. REXELLA M. UMOQUIT", "OMG Adviser", R.drawable.profile_circle_bg,
        "JANICA GENESIS N. BARCE", "OMG President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/orgofmathgen", "omg.bulsubustos@gmail.com"));


        orgList.add(new StudentOrg("PLUMAP", "Progresibong Lupon ng mga Mag-Aaral sa Araling Panlipunan", R.drawable.plumap_logo,
        "MR. RODEL B. TAYAO", "PLUMAP Adviser", R.drawable.profile_circle_bg,
        "IRVIN C. QUIAMBAO","PLUMAP President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/BulsuPLUMAP","bulsu.plumapofficial@gmail.com"));

        orgList.add(new StudentOrg("Samo't Sari", "Samo't Sari", R.drawable.samotsari_logo,
        "MS. SHAIRA BERNALDEZ", "Samo't Sari Adviser", R.drawable.profile_circle_bg,
        "JOHN ANDREI MORALES", "Samo't Sari President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/SamotSari.BulsuBustos","bulsubustos.samotsari@gmail.com"));

        orgList.add(new StudentOrg("SCIRE", "Science Club in Real Essence", R.drawable.scire_logo,
        "KATRINA ANN B. ESPINOLA", "SCIRE Adviser",R.drawable.profile_circle_bg,
        "JUNALEEN MAE B. BONITO", "SCIRE President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/SCIREBulSUBustos","scirebustoscampus@gmail.com"));

        orgList.add(new StudentOrg("SFED", "Society of Future Educators", R.drawable.sfed_logo,
        "ALLEN S. VALERA, PH.D.", "SFED Adviser", R.drawable.profile_circle_bg,
        "STEPHANIE VENIEZ E. RAMOS ", "SFED President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/BulSUBustosSFEd1920","sfedsocietyoffutureeducators@gmail.com"));

        orgList.add(new StudentOrg("SOMAPHED", "Society of Modified and Artistic Physical Educators", R.drawable.somaphed_logo,
        "MR. JOSEPH BERNARD P. MARCELO", "SOMAPHED Adviser", R.drawable.profile_circle_bg,
        "ANNABEL S. PALOMO", "SOMAPHED President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/profile.php?id=100068328763247", "somaphed.bulsu@gmail.com"));

        orgList.add(new StudentOrg("YTR", "Youth on the Rock", R.drawable.ytr_logo,
        "MR SEVERINO SALVADOR", "YTR Adviser", R.drawable.profile_circle_bg,
        "CHRISTIAN JOHN AMOR", "YTR President", R.drawable.profile_circle_bg,
        "https://www.facebook.com/groups/675182561803498","ytrbulsubustosofficial@gmail.com"));



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
