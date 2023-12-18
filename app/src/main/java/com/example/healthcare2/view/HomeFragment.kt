package com.example.healthcare2.view

import com.example.healthcare2.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare2.adapter.PostHomeAdapter
import com.example.healthcare2.data.model.Post
import com.example.healthcare2.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {
    private var binding : FragmentHomeBinding? = null
    private lateinit var recyclerView : RecyclerView
    private lateinit var listPostHome : List<Post>
    private lateinit var postAdapter : PostHomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Khởi tạo RecyclerView và adapter
        recyclerView = binding!!.recyclerviewListposthome
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        listPostHome = ArrayList<Post>()
        postAdapter = PostHomeAdapter(requireContext(), listPostHome, R.layout.item_post_home)

        // Gán adapter cho RecyclerView
        recyclerView.setAdapter(postAdapter)
        binding!!.cardMedicine.setOnClickListener {
            findNavController().navigate(R.id.detailMedicineFragment)
            findNavController().navigate(R.id.medicinesFragment)
        }
    }
}