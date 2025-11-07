package com.firstapp.bulsustudente_handbook;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo3d, logoFlat;
    private TextView title, subtitle;
    private Button getStarted;
    private FrameLayout bg;
    private final Handler handler = new Handler();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo3d = findViewById(R.id.logo_eagle_3d);
        logoFlat = findViewById(R.id.logo_eagle_flat);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);
        getStarted = findViewById(R.id.get_started);
        bg = findViewById(R.id.splashed_bg);

        // Hide everything initially
        logo3d.setVisibility(View.GONE);
        logoFlat.setVisibility(View.INVISIBLE);
        title.setVisibility(View.INVISIBLE);
        subtitle.setVisibility(View.INVISIBLE);
        getStarted.setVisibility(View.INVISIBLE);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // 1️⃣ Bring logoFlat from below to center
        handler.postDelayed(() -> {
            logoFlat.setVisibility(View.VISIBLE);
            logoFlat.setAlpha(0f);
            logoFlat.setTranslationY(200f); // start below its final position

            logoFlat.animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setDuration(1000)
                    .setInterpolator(new android.view.animation.DecelerateInterpolator())
                    .start();
        }, 1000);

        // 2️⃣ Fade in background transitions
        handler.postDelayed(() -> {
            bg.setBackgroundResource(R.drawable.transition_stage1_to_2);
            TransitionDrawable transition1 = (TransitionDrawable) bg.getBackground();
            transition1.startTransition(1000);
        }, 1800);

        handler.postDelayed(() -> {
            bg.setBackgroundResource(R.drawable.transition_stage2_to_3);
            TransitionDrawable transition2 = (TransitionDrawable) bg.getBackground();
            transition2.startTransition(1000);
        }, 3200);

        // 3️⃣ Show text "BulSU Bustos Campus" and button
        handler.postDelayed(() -> title.startAnimation(fadeIn), 3500);
        // Fade in title, subtitle, and button
        handler.postDelayed(() -> {
            title.setVisibility(View.VISIBLE);
            title.setAlpha(0f);
            title.animate().alpha(1f).setDuration(800).start();
        }, 3500);

        handler.postDelayed(() -> {
            subtitle.setVisibility(View.VISIBLE);
            subtitle.setAlpha(0f);
            subtitle.animate().alpha(1f).setDuration(800).start();
        }, 3900);


        // 4️⃣ After a total of ~6 seconds → go to GetStartedActivity
        handler.postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, GetStartedActivity.class));
          finish();
        }, 6000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
