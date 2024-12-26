package com.example.psalavirtual

import android.os.Parcel
import android.os.Parcelable

data class Aluno(val nome: String, val idade: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeInt(idade)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Aluno> {
        override fun createFromParcel(parcel: Parcel): Aluno {
            return Aluno(parcel)
        }

        override fun newArray(size: Int): Array<Aluno?> {
            return arrayOfNulls(size)
        }
    }

}
