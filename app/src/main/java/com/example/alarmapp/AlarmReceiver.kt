package com.example.alarmapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver(){

    override fun onReceive(context: Context, intent: Intent) {
    val challengeIntent = Intent(context, MathChallengeActivity::class.java)
    challengeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(challengeIntent)

    }
}
