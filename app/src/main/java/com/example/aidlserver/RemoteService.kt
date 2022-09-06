package com.example.aidlserver

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import com.example.aidlserver.IMyAidlInterface
import kotlin.Throws

/**
 * @Author : zhaojianwei02
 * @Date : 2022/8/29 10:51 上午
 * @Description :
 */
class RemoteService : Service() {

    private var binder = MyAidlInterfaceImpl()

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }

    inner class MyAidlInterfaceImpl : IMyAidlInterface.Stub() {
        @Throws(RemoteException::class)
        override fun getValue(v: Int): Int {
            Log.d("RemoteService", "getValue = $v")
            return v
        }
    }
}