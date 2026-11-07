package com.ute.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ute.fragment.R
import com.ute.fragment.adapter.StudentAdapter
import com.ute.fragment.databinding.FragmentStudentListBinding
import com.ute.fragment.model.Student

class StudentListFragment : Fragment() {

    private var _binding: FragmentStudentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var studentAdapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val students = getSampleStudents()

        studentAdapter = StudentAdapter(students) { student ->
            openStudentDetail(student)
        }

        binding.recyclerViewStudents.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = studentAdapter
        }
    }

    private fun openStudentDetail(student: Student) {
        val detailFragment = StudentDetailsFragment.newInstance(student)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getSampleStudents(): List<Student> {
        return listOf(
            Student(
                id = "1",
                studentId = "21110001",
                name = "Nguyễn Văn An",
                email = "21110001@student.hcmute.edu.vn",
                phone = "0901234567",
                major = "Công nghệ thông tin",
                className = "211101",
                gpa = 3.65,
                gender = "Nam"
            ),
            Student(
                id = "2",
                studentId = "21110002",
                name = "Trần Thị Bình",
                email = "21110002@student.hcmute.edu.vn",
                phone = "0912345678",
                major = "Kỹ thuật phần mềm",
                className = "211102",
                gpa = 3.80,
                gender = "Nữ"
            ),
            Student(
                id = "3",
                studentId = "21110003",
                name = "Lê Hoàng Cường",
                email = "21110003@student.hcmute.edu.vn",
                phone = "0923456789",
                major = "Hệ thống thông tin",
                className = "211101",
                gpa = 3.42,
                gender = "Nam"
            ),
            Student(
                id = "4",
                studentId = "21110004",
                name = "Phạm Minh Dung",
                email = "21110004@student.hcmute.edu.vn",
                phone = "0934567890",
                major = "Khoa học dữ liệu",
                className = "211103",
                gpa = 3.91,
                gender = "Nữ"
            ),
            Student(
                id = "5",
                studentId = "21110005",
                name = "Vũ Đức Em",
                email = "21110005@student.hcmute.edu.vn",
                phone = "0945678901",
                major = "An toàn thông tin",
                className = "211102",
                gpa = 3.25,
                gender = "Nam"
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}