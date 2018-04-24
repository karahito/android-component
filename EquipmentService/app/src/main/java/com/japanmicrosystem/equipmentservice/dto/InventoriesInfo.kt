package com.japanmicrosystem.equipmentservice.dto

import android.os.Parcel
import android.os.Parcelable

/**
 * inventories Class
 *
 * @author D.Noguchi
 * @since 2018/04/18
 */
class InventoriesInfo{
    data class Inventories(var inventories:List<EquipmentInfo>) : Parcelable {
        constructor(parcel: Parcel) : this(
                inventories = parcel.createTypedArrayList(EquipmentInfo.CREATOR)
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeList(inventories)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Inventories> {
            override fun createFromParcel(parcel: Parcel): Inventories {
                return Inventories(parcel)
            }

            override fun newArray(size: Int): Array<Inventories?> {
                return arrayOfNulls(size)
            }
        }
    }

    data class EquipmentInfo(val code:String,val admin:String,val category:String,var updater:String,var date:String) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString())

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(code)
            parcel.writeString(admin)
            parcel.writeString(category)
            parcel.writeString(updater)
            parcel.writeString(date)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<EquipmentInfo> {
            override fun createFromParcel(parcel: Parcel): EquipmentInfo {
                return EquipmentInfo(parcel)
            }

            override fun newArray(size: Int): Array<EquipmentInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}