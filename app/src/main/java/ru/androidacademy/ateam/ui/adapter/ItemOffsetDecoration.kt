package ru.androidacademy.ateam.ui.adapter

import android.content.Context
import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.RecyclerView
import android.view.View


class ItemOffsetDecoration(context: Context, @DimenRes itemOffsetId: Int) : RecyclerView.ItemDecoration() {
    private var mItemOffset: Int = context.resources.getDimensionPixelSize(itemOffsetId)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset)
    }

}