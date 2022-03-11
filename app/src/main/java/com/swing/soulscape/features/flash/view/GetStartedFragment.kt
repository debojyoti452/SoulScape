package com.swing.soulscape.features.flash.view

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import androidx.fragment.app.viewModels
import com.example.lib.StarWars
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.model.Planet
import com.example.lib.src.utils.Response
import com.swing.soulscape.R
import com.swing.soulscape.base.BaseFragment
import com.swing.soulscape.databinding.FragmentGetStartedBinding
import com.swing.soulscape.features.auth.AuthActivity
import com.swing.soulscape.features.flash.FlashActivity
import com.swing.soulscape.features.flash.viewmodel.GetStartedViewModel
import com.swing.soulscape.utils.Extensions.logoRotate
import com.swing.soulscape.utils.Extensions.ripple


class GetStartedFragment : BaseFragment<FragmentGetStartedBinding>(), View.OnClickListener {
    private val NOTIFICATION_REPLY = "NotificationReply"
    private val getStartedVM: GetStartedViewModel by viewModels()
    private val starWars by lazy {
        StarWars.Builder()
            .setContext(requireContext())
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.innerLogoGetStarted.flashImg.logoRotate()
        binding.startUrJourneyBtn.setOnClickListener(this)
        binding.iAlreadyHaveBtn.setOnClickListener(this)
        binding.startUrJourneyBtn.ripple()
        binding.iAlreadyHaveBtn.ripple()
    }

    private val callback = object : ResponseOnListener<Response<Planet>> {
        override fun onResult(result: Response<Planet>) {
            when (result) {
                is Response.Success -> {
                    result.data.itemCount?.let {
                        requireActivity().runOnUiThread {
                            showLog(it)
                            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
                is Response.Error -> {
                    result.let {
                        requireActivity().runOnUiThread {
                            showLog(it)
                            Toast.makeText(
                                requireContext(),
                                it.exception.toString(),
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    }
                }
                else -> {}
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.startUrJourneyBtn -> {
                requireActivity().startActivity(
                    Intent(
                        requireContext(),
                        AuthActivity::class.java
                    )
                )
            }

            R.id.iAlreadyHaveBtn -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    sendNotification()
                }
            }
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun sendNotification() {
        // Key for the string that's delivered in the action's intent.
        val resultKey = "key_text_reply"
        val replyLabel = "Reply"
        val remoteInput: RemoteInput = RemoteInput.Builder(resultKey).run {
            setLabel(replyLabel)
            build()
        }

        val intent = Intent(requireContext(), FlashActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            requireContext(),
            0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Create the reply action and add the remote input.
        val action: NotificationCompat.Action =
            NotificationCompat.Action.Builder(
                R.drawable.ic_baseline_arrow_back_24,
                getString(R.string.reply),
                pendingIntent
            ).addRemoteInput(remoteInput).build()

        val builder = NotificationCompat.Builder(requireContext(), "CHANNEL_ID")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Test notification")
            .setContentText("Test Notification body")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAllowSystemGeneratedContextualActions(true)
            .addAction(action)

        with(NotificationManagerCompat.from(requireContext())) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }

    override fun vmObserver() {

    }

    override fun onDeviceBack() {
        requireActivity().finish()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGetStartedBinding {
        return FragmentGetStartedBinding.inflate(inflater, container, false)
    }
}
