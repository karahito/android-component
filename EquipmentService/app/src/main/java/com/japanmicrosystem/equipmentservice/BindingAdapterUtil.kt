package com.japanmicrosystem.equipmentservice

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.widget.ListView

@BindingAdapter("equipment_list")
fun ListView.setAdapter(equipmentList: ObservableArrayList<Equipment>){
    val adapter = EquipmentListAdapter(this.context,equipmentList)
    this.adapter = adapter
    adapter.notifyDataSetChanged()
}