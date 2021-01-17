package com.chooloo.www.callmanager.util;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chooloo.www.callmanager.R;

import static android.view.animation.AnimationUtils.loadAnimation;
import static android.view.animation.AnimationUtils.loadLayoutAnimation;

public class AnimationUtils {
    public static final int ANIMATION_DURATION = 500;

    public static void setFadeAnimation(View view) {
        view.startAnimation(loadAnimation(view.getContext(), R.anim.animation_fade_in));
    }

    public static void setFadeUpAnimation(View view) {
        view.startAnimation(loadAnimation(view.getContext(), R.anim.animation_fall_down));
    }

    public static void runLayoutAnimation(final RecyclerView recyclerView) {
        recyclerView.setLayoutAnimation(loadLayoutAnimation(recyclerView.getContext(), R.anim.layout_animation_fall_down));
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}