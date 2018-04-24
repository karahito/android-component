package com.japanmicrosystem.equipmentservice

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.japanmicrosystem.equipmentservice.databinding.RowListEquipmentBinding

/**
 * EquipmentListAdapter Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
class EquipmentListAdapter(context: Context,equipmentList:ObservableArrayList<Equipment>):ArrayAdapter<Equipment>(context,0,equipmentList) {
    @Suppress("NAME_SHADOWING")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        lateinit var binding:RowListEquipmentBinding

        convertView?.apply {
            binding = convertView?.tag as RowListEquipmentBinding
        }?:let {
            val inflater = LayoutInflater.from(context)
            binding = DataBindingUtil.inflate(inflater,R.layout.row_list_equipment,parent,false)
            convertView = binding.root
            convertView?.tag = binding
        }
       binding.equipment = getItem(position)
        return binding.root
    }
}