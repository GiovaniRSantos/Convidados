package com.example.convidados.service.repository

import android.content.Context
import com.example.convidados.service.model.GuestModel

class GuestRepository (context: Context) {

    private val mDataBase = GuestDataBase.getDataBase(context).guestDAO()

    fun get(id: Int): GuestModel {
        return mDataBase.get(id)
    }

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel) {
        return mDataBase.delete(guest)
    }

}