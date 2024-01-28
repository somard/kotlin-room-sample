package edu.keiser.cs.notes.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

internal class RecyclerViewDecorator(private val verticalMargin: Int, private val addHeadMargin : Boolean = true) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        if (position == 0) {
            outRect.set(0, if(addHeadMargin) verticalMargin else 0, 0, verticalMargin)
        } else {
            outRect.set(0, 0, 0, verticalMargin)
        }
    }
}
