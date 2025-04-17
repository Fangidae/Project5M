package com.example.juanfangidae

import android.os.Parcel
import android.os.Parcelable

data class  ItemData1(val gambar : Int, val judul : String, val penerbit : String, val deskripsi : String)
    : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!
        ){

        }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gambar)
        parcel.writeString(judul)
        parcel.writeString(penerbit)
        parcel.writeString(deskripsi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemData1> {
        override fun createFromParcel(parcel: Parcel): ItemData1 {
            return ItemData1(parcel)
        }

        override fun newArray(size: Int): Array<ItemData1?> {
            return arrayOfNulls(size)
        }
    }
}