package com.swing.soulscape.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.RemoteInput
import timber.log.Timber

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, intent: Intent?) {
       val bundle = RemoteInput.getDataResultsFromIntent(intent, "4520")

        if(bundle != null) {
            Timber.d("HEY I AM HERE>>>>")
        }
    }
}
