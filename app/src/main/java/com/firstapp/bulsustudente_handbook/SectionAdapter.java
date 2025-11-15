package com.firstapp.bulsustudente_handbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private final List<String> titles;
    private final Context context;

    public SectionAdapter(Context context, List<String> titles) {
        this.context = context;
        this.titles = titles;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.section_card_item, parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder holder, int position) {
        String title = titles.get(position);
        holder.title.setText(title);

        // Handle click to open corresponding Activity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = null;

            switch (title) {

                // General Provisions
                case "INSTITUTIONAL PHILOSOPHY":
                    intent = new Intent(context, InstitutionalPhilosophyActivity.class);
                    break;

                case "POLICY STATEMENTS":
                    intent = new Intent(context, PolicyStatementsActivity.class);
                    break;

                case "CLASSIFICATION OF STUDENTS":
                    intent = new Intent(context, ClassificationOfStudentsActivity.class);
                    break;

                case "STUDENT'S RIGHTS, OBLIGATIONS, AND RESPONSIBILITIES":
                    intent = new Intent(context, StudentRightsObligationsActivity.class);
                    break;

                case "OBEDIENCE TO THE LAWS OF THE LAND":
                    intent = new Intent(context, ObedienceToLawsActivity.class);
                    break;

                case "STUDENTS' ORIENTATION":
                    intent = new Intent(context, StudentsOrientationActivity.class);
                    break;


                // 🔥 Student Affairs and Services
                case "THE OFFICE OF THE DEAN\nFOR STUDENT AFFAIRS AND SERVICES":
                    intent = new Intent(context, OfficeOfTheDeanSAS.class);
                    break;

               case "STUDENT SERVICES":
                    intent = new Intent(context, StudentServicesActivity.class);
                  break;
                case "A. ADMISSIONS AND ORIENTATION":
                    // TODO: Create activity
                    intent = new Intent(context, AdmissionsOrientationActivity.class);
                    break;

                case "B. SCHOLARSHIPS AND FINANCIAL ASSISTANCE":
                    // TODO: Create activity
                    intent = new Intent(context, ScholarshipsFinancialAidActivity.class);
                    break;
//
                case "C. STUDENT SOCIO-ECONOMIC INVOLVEMENT":
                    // TODO: Create activity
                    intent = new Intent(context, StudentSocioEconomicActivity.class);
                    break;

                case "D. STUDENTS WITH SPECIAL NEEDS AND PERSONS WITH DISABILITIES":
//                    // TODO: Create activity
                    intent = new Intent(context, StudentsWithSpecialNeedsActivity.class);
                    break;

                case "STUDENT WELFARE":
                   intent = new Intent(context, StudentWelfareActivity.class);
                    break;

                // =============================================
                // 🟨 STUDENT WELFARE SUBSECTIONS
                // =============================================
                case "A. GUIDANCE AND COUNSELLING SERVICES":
                    intent = new Intent(context, GuidanceCounsellingActivity.class);
                    break;

                case "B. CAREER DEVELOPMENT AND STUDENT INTERNSHIP SERVICES":
                    intent = new Intent(context, CareerDevelopmentInternshipActivity.class);
                    break;

                case "C. PLACEMENT AND PUBLIC EMPLOYMENT SERVICES":
                    intent = new Intent(context, PlacementEmploymentActivity.class);
                    break;

                case "D. THE COMMISSION ON STUDENT ELECTIONS":
                    intent = new Intent(context, StudentElectionsActivity.class);
                    break;

                case "E. STUDENT GRIEVANCE":
                    intent = new Intent(context, StudentGrievanceActivity.class);
                    break;

                case "F. STUDENT INSURANCE CLAIM":
                    intent = new Intent(context, StudentInsuranceClaimActivity.class);
                    break;


                case "STUDENT DEVELOPMENT":
                   intent = new Intent(context, StudentDevelopmentActivity.class);
                   break;

                // STUDENT DEVELOPMENT SECTIONS
                case "A. STUDENT ORGANIZATIONS AND ACTIVITIES":
                    intent = new Intent(context, StudentOrganizationsActivity.class);
                    break;

                case "B. STUDENT PUBLICATIONS AND INFORMATION":
                    intent = new Intent(context, StudentPublicationsActivity.class);
                    break;

                case "C. CULTURAL AND ARTS AFFAIRS":
                    intent = new Intent(context, CulturalArtsAffairsActivity.class);
                    break;

                case "D. STUDENT HANDBOOK DEVELOPMENT":
                    intent = new Intent(context, StudentHandbookDevelopmentActivity.class);
                    break;

               case "STUDENT GOVERNMENT":
                   intent = new Intent(context, StudentGovernmentActivity.class);
                   break;

               case "STUDENT REWARDS AND INCENTIVES":
                    intent = new Intent(context, StudentRewardIncentivesActivity.class);
                    break;
           }


            if (intent != null) {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles != null ? titles.size() : 0;
    }

    static class SectionViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon, arrow;

        SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}
