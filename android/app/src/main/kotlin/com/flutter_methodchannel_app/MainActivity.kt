package com.flutter_methodchannel_app

import android.content.Intent
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

//
//private var pendingIntent: PendingIntent? = null
//private var alarmManager: AlarmManager? = null
//private var flutterView: FlutterView? = null
//private const val CHANNEL = "com.tarazgroup"

class MainActivity: FlutterActivity() {

    private val CHANNEL = "com.retroportalstudio.messages"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if(call.method=="startService"){
                startlocationservice()
            }
        }
    }

    private fun startlocationservice() {
        var intent= Intent(this@MainActivity, MyService::class.java)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            startForegroundService(intent)
        }else{
            startService(intent)
        }
    }


}
