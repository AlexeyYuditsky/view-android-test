package com.alexeyyuditsky.test.screen.recycler.animator

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.alexeyyuditsky.test.R

class CustomAnimator : DefaultItemAnimator() {

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        holder.itemView.animation = AnimationUtils.loadAnimation(
            holder.itemView.context,
            R.anim.view_holder_car_remove
        )
        return super.animateRemove(holder)
    }

    override fun getRemoveDuration(): Long = 500
}