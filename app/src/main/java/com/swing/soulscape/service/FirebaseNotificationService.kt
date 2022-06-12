package com.swing.soulscape.service

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.swing.soulscape.R
import com.swing.soulscape.features.flash.FlashActivity
import timber.log.Timber


class FirebaseNotificationService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Timber.d(p0)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        sendNotification(remoteMessage)
        super.onMessageReceived(remoteMessage)
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun sendNotification(remoteMessage: RemoteMessage) {
        // Key for the string that's delivered in the action's intent.
        val resultKey = "key_text_reply"
        val replyLabel = "Reply"
        val remoteInput: RemoteInput = RemoteInput.Builder(resultKey).run {
            setLabel(replyLabel)
            build()
        }

        val intent = Intent(applicationContext, FlashActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            applicationContext,
            0, intent, PendingIntent.FLAG_ONE_SHOT
        )

        // Create the reply action and add the remote input.
        val action: NotificationCompat.Action =
            NotificationCompat.Action.Builder(
                R.drawable.ic_baseline_arrow_back_24,
                getString(R.string.reply),
                pendingIntent
            ).addRemoteInput(remoteInput).build()

        val builder = NotificationCompat.Builder(applicationContext, "CHANNEL_ID")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Test notification")
            .setContentText("Test Notification body")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAllowSystemGeneratedContextualActions(true)
            .addAction(action)

        with(NotificationManagerCompat.from(applicationContext)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }
}
