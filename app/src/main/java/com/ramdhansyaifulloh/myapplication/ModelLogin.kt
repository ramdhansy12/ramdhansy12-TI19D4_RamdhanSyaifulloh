package com.ramdhansyaifulloh.myapplication

import android.os.Parcel
import android.os.Parcelable


@Parcelize
data class ModelLogin(
    var username: String?,
    var password: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelLogin> {
        override fun createFromParcel(parcel: Parcel): ModelLogin {
            return ModelLogin(parcel)
        }

        override fun newArray(size: Int): Array<ModelLogin?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize
