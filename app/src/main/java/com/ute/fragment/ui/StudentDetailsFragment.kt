package com.ute.fragment.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ute.fragment.R
import com.ute.fragment.databinding.FragmentStudentDetailBinding
import com.ute.fragment.model.Student

class StudentDetailsFragment : Fragment() {

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            student = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(ARG_STUDENT, Student::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.getSerializable(ARG_STUDENT) as? Student
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarDetail.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        student?.let { s ->
            binding.tvDetailName.text = s.name
            binding.tvDetailStudentId.text = getString(R.string.student_id_prefix, s.studentId)
            binding.tvDetailMajor.text = s.major
            binding.tvDetailClass.text = s.className
            binding.tvDetailGender.text = s.gender
            binding.tvDetailGpa.text = getString(R.string.gpa_format, s.gpa)
            binding.tvDetailEmail.text = s.email
            binding.tvDetailPhone.text = s.phone
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_STUDENT = "arg_student"

        fun newInstance(student: Student): StudentDetailsFragment {
            val fragment = StudentDetailsFragment()
            val args = Bundle().apply {
                putSerializable(ARG_STUDENT, student)
            }
            fragment.arguments = args
            return fragment
        }
    }
}