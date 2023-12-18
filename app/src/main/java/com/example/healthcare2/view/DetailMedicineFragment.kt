package com.example.healthcare2.view

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.healthcare2.R
import com.example.healthcare2.databinding.FragmentDetailMedicineBinding
import com.example.healthcare2.viewmodel.MedicineViewModel

class DetailMedicineFragment : Fragment() {
    private lateinit var binding : FragmentDetailMedicineBinding
    private lateinit var medicineViewModel: MedicineViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMedicineBinding.inflate(layoutInflater)
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        getMedicine(1)
        getComment()
        return binding.root
    }
    fun getComment(){
        val fragmentManager = childFragmentManager
        val commentFragment = CommentFragment(1, null)
        fragmentManager.beginTransaction().replace(R.id.fragmentComment, commentFragment).commit()
    }
    fun getMedicine(idMedicine : Int){
        medicineViewModel.getMedicine(idMedicine).observe(viewLifecycleOwner) { medicine ->
            Glide.with(requireContext()).load(medicine.img).into(binding.imgMedicine)
            binding.txtNameMedicine.text = medicine.nameMedicine
            binding.txtRatingMedicine.text = medicine.rating.toString()
            setRatingMedicine(medicine.rating)
            binding.txtLike.text = medicine.like.toString()
            binding.txtContentMedicine.text = Html.fromHtml(medicine.content)
            //đặt user
            binding.txtNameUser.text = medicine.doctor.nameUser
            binding.txtRatingDoctor.text = medicine.doctor.ratingDoctor.toString()
            Glide.with(requireContext()).load(medicine.doctor.avatar).into(binding.imgAvatar)
        }
    }
    fun setRatingMedicine(rating: Float){
        if (rating>=0 && rating <=0.5){

        } else if (0.5 < rating && rating < 1){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_half)
        } else if (1 <= rating && rating < 1.5){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
        } else if (1.5<= rating && rating < 2){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_half)
        } else if (2 <= rating && rating < 2.5){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
        } else if (2.5 <= rating && rating < 3){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle3.setImageResource(R.drawable.ic_star_half)
        } else if (3 <= rating && rating < 3.5){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle3.setImageResource(R.drawable.ic_star_full)
        } else if (3.5 <= rating && rating < 4){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle3.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle4.setImageResource(R.drawable.ic_star_half)
        } else if (4 <= rating && rating < 4.5){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle3.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle4.setImageResource(R.drawable.ic_star_full)
        } else if (4.5 <= rating && rating < 5){
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle3.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle4.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle5.setImageResource(R.drawable.ic_star_half)
        } else {
            binding.icStarTitle1.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle2.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle3.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle4.setImageResource(R.drawable.ic_star_full)
            binding.icStarTitle5.setImageResource(R.drawable.ic_star_full)
        }
    }
}