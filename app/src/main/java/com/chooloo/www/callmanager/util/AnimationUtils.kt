package com.chooloo.www.callmanager.util

import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.chooloo.www.callmanager.R

object AnimationUtils {
    const val ANIMATION_DURATION = 500

    @JvmStatic
    fun showView(view: View, isShow: Boolean) {
        view.visibility = if (isShow) View.VISIBLE else View.GONE
        view.startAnimation(AnimationUtils.loadAnimation(view.context, if (isShow) R.anim.animation_fall_down_show else R.anim.animation_fall_down_hide))
    }

    fun setFadeAnimation(view: View) {
        view.startAnimation(AnimationUtils.loadAnimation(view.context, R.anim.animation_fade_in))
    }

    @JvmStatic
    fun setFadeUpAnimation(view: View) {
        view.startAnimation(AnimationUtils.loadAnimation(view.context, R.anim.animation_fall_down_show))
    }

    @JvmStatic
    fun runLayoutAnimation(recyclerView: RecyclerView) {
        recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(recyclerView.context, R.anim.layout_animation_fall_down)
        recyclerView.adapter!!.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

    @JvmStatic
    fun animateViews(views: Array<View>, delay: Int, isShow: Boolean) {
        for (view in views) {
            view.visibility = View.INVISIBLE
        }
        views.indices.forEach { i ->
            val view = views[i]
            view.postDelayed({
                view.visibility = View.VISIBLE
                showView(view, isShow)
            }, i * delay.toLong())
        }
    }
}