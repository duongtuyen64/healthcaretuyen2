package com.example.healthcare2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare2.R
import com.example.healthcare2.adapter.CommentAdapter
import com.example.healthcare2.data.model.Comment
import com.example.healthcare2.data.model.Rating
import com.example.healthcare2.databinding.FragmentCommentBinding
import com.example.healthcare2.viewmodel.CommentViewModel
import com.example.healthcare2.viewmodel.MedicineViewModel
import com.example.healthcare2.viewmodel.RatingViewModel

class CommentFragment() : Fragment() {
    private lateinit var binding: FragmentCommentBinding
    private lateinit var medicineViewModel: MedicineViewModel
    private lateinit var commentViewModel: CommentViewModel
    private lateinit var ratingViewModel: RatingViewModel
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var recyclerView: RecyclerView
    private var listComment: List<Comment> = ArrayList<Comment>()
    private var listRating: List<Rating> = ArrayList<Rating>()
    private var idMedicine: Int? = null
    private var idPost: Int? = null

    constructor(idMedicine: Int, idPost: Int?) : this() {
        this.idMedicine = idMedicine
        this.idPost = idPost
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentBinding.inflate(layoutInflater)
        commentViewModel = ViewModelProvider(this).get(CommentViewModel::class.java)
        ratingViewModel = ViewModelProvider(this).get(RatingViewModel::class.java)
        recyclerView = binding.recyclerviewComment
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        if (idMedicine != null){
            getRatingCommentMedicine(idMedicine!!)
        } else if (idPost != null){

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRate()
        addCommentMedicine()
    }
    fun addCommentMedicine(){
        binding.icSendComment.setOnClickListener {
            var ratingComment: Int = 0
            if (binding.checkboxStar5.isChecked) ratingComment = 5
            else if (binding.checkboxStar4.isChecked) ratingComment = 4
            else if (binding.checkboxStar3.isChecked) ratingComment = 3
            else if (binding.checkboxStar2.isChecked) ratingComment = 2
            else if (binding.checkboxStar1.isChecked) ratingComment = 1
            if (ratingComment == 0){
                Log.d("ERROR", "Lỗi: rating hiện tại $ratingComment")
                Toast.makeText(requireContext(), "You must rate!", Toast.LENGTH_SHORT).show()
            } else if (binding.edtComment.text.toString().isNullOrEmpty()){
                Toast.makeText(requireContext(), "You must comment!", Toast.LENGTH_SHORT).show()
            } else{
                var comment: Comment = Comment(1, idMedicine!!, binding.edtComment.text.toString())
                var rating: Rating = Rating(1, idMedicine!!, ratingComment)
                commentViewModel.addCommentMedicine(comment)
                ratingViewModel.addRatingMedicine(rating)
                commentAdapter.notifyDataSetChanged()

            }
        }
    }
    fun setRate(){
        binding.checkboxStar1.setOnClickListener {
            binding.txtQuality.text = "Terrible"
            setStarRatingComment(1)
        }
        binding.checkboxStar2.setOnClickListener {
            binding.txtQuality.text = "Poor"
            setStarRatingComment(2)
        }
        binding.checkboxStar3.setOnClickListener {
            binding.txtQuality.text = "Fair"
            setStarRatingComment(3)
        }
        binding.checkboxStar4.setOnClickListener {
            binding.txtQuality.text = "Good"
            setStarRatingComment(4)
        }
        binding.checkboxStar5.setOnClickListener {
            binding.txtQuality.text = "Amazing"
            setStarRatingComment(5)
        }
    }
    fun setStarRatingComment(star: Int){
        if (star == 1){
            binding.checkboxStar1.isChecked = true
            binding.checkboxStar2.isChecked = false
            binding.checkboxStar3.isChecked = false
            binding.checkboxStar4.isChecked = false
            binding.checkboxStar5.isChecked = false
        } else if (star == 2){
            binding.checkboxStar1.isChecked = true
            binding.checkboxStar2.isChecked = true
            binding.checkboxStar3.isChecked = false
            binding.checkboxStar4.isChecked = false
            binding.checkboxStar5.isChecked = false
        } else if (star == 3){
            binding.checkboxStar1.isChecked = true
            binding.checkboxStar2.isChecked = true
            binding.checkboxStar3.isChecked = true
            binding.checkboxStar4.isChecked = false
            binding.checkboxStar5.isChecked = false
        } else if (star == 4){
            binding.checkboxStar1.isChecked = true
            binding.checkboxStar2.isChecked = true
            binding.checkboxStar3.isChecked = true
            binding.checkboxStar4.isChecked = true
            binding.checkboxStar5.isChecked = false
        } else if (star == 5){
            binding.checkboxStar1.isChecked = true
            binding.checkboxStar2.isChecked = true
            binding.checkboxStar3.isChecked = true
            binding.checkboxStar4.isChecked = true
            binding.checkboxStar5.isChecked = true
        }
    }
    fun setStarRatingTotal(rating: Float){
        if (0 <= rating && rating < 0.5){

        } else if (0.5 <= rating && rating < 1){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_half)
        } else if (1 <= rating && rating < 1.5){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
        } else if (1.5 <= rating && rating < 2){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_half)
        } else if (2 <= rating && rating < 2.5){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
        } else if (2.5 <= rating && rating < 3){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating3.setImageResource(R.drawable.ic_star_half)
        } else if (3 <= rating && rating < 3.5){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating3.setImageResource(R.drawable.ic_star_full)
        } else if (3.5 <= rating && rating < 4){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating3.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating4.setImageResource(R.drawable.ic_star_half)
        } else if (4 <= rating && rating < 4.5){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating3.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating4.setImageResource(R.drawable.ic_star_full)
        } else if (4.5 <= rating && rating < 5){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating3.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating4.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating5.setImageResource(R.drawable.ic_star_half)
        } else if (rating == 5f){
            binding.icStarRating1.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating2.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating3.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating4.setImageResource(R.drawable.ic_star_full)
            binding.icStarRating5.setImageResource(R.drawable.ic_star_full)
        }
    }
    fun getCommentMedicine(idMedicine: Int){
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        medicineViewModel.getMedicine(idMedicine).observe(viewLifecycleOwner){ medicine ->
            binding.txtRating.text = medicine.rating.toString()
            setStarRatingTotal(medicine.rating)
        }
        commentViewModel.getCommentMedicine(idMedicine).observe(viewLifecycleOwner){ comments ->
            listComment = comments
            commentAdapter = CommentAdapter(requireContext(), listComment, listRating, R.layout.item_comment)
            recyclerView.adapter = commentAdapter
            binding.txtNumComment.text = listComment.size.toString()
        }
    }
    fun getRatingCommentMedicine(idMedicine: Int){
        ratingViewModel.getRatingCommentMedicine(idMedicine).observe(viewLifecycleOwner){ ratings ->
            listRating = ratings
            getCommentMedicine(idMedicine)
        }
    }
}