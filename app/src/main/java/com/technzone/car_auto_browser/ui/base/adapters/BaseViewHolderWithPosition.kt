package com.technzone.car_auto_browser.ui.base.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolderWithPosition<MODEL>(itemView: View?) :
    RecyclerView.ViewHolder(itemView!!) {
    abstract fun bind(item: MODEL,position:Int)
}