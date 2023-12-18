package com.example.healthcare2.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare2.R
import com.example.healthcare2.adapter.NotificationAdapter
import com.example.healthcare2.databinding.FragmentNotificationBinding
import com.example.healthcare2.viewmodel.NotificationViewModel

class NotificationFragment : Fragment() {
    private lateinit var binding: FragmentNotificationBinding
    private lateinit var notificationViewModel: NotificationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(layoutInflater)
        notificationViewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        getNotificationList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun getNotificationList() {
        notificationViewModel.allNotification.observe(viewLifecycleOwner) { notificationList ->
            val adapter = NotificationAdapter(requireContext(), notificationList, R.layout.item_notification)
            binding.recycleViewlistNotification.adapter = adapter
        }
    }
}