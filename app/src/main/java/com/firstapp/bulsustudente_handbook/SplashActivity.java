package com.firstapp.bulsustudente_handbook;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logoFlat;
    private TextView title, subtitle;
    private FrameLayout bg;

    // Use Handler with Looper for API 20+
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoFlat = findViewById(R.id.logo_eagle_flat);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);
        bg = findViewById(R.id.splashed_bg);

        // Hide initially
        logoFlat.setVisibility(View.INVISIBLE);
        title.setVisibility(View.INVISIBLE);
        subtitle.setVisibility(View.INVISIBLE);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // 1️⃣ Animate logo
        handler.postDelayed(() -> {
            logoFlat.setVisibility(View.VISIBLE);
            logoFlat.setAlpha(0f);
            logoFlat.setTranslationY(200f);

            logoFlat.animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setDuration(1000)
                    .setInterpolator(new android.view.animation.DecelerateInterpolator())
                    .start();
        }, 1000);

        // 2️⃣ Background transitions
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

        // 3️⃣ Show title and subtitle
        handler.postDelayed(() -> {
            title.setVisibility(View.VISIBLE);
            title.setAlpha(0f);
            title.startAnimation(fadeIn);
            title.animate().alpha(1f).setDuration(800).start();
        }, 3500);

        handler.postDelayed(() -> {
            subtitle.setVisibility(View.VISIBLE);
            subtitle.setAlpha(0f);
            subtitle.animate().alpha(1f).setDuration(800).start();
        }, 3900);

        // 4️⃣ Move to next activity
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
