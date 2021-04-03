package com.bcc.drophere.ui.fragment.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bcc.drophere.adapter.MainPageAdapter
import com.bcc.drophere.databinding.DialogInsertCodeBinding
import com.bcc.drophere.databinding.FragmentMainBinding
import com.bcc.drophere.model.TaskList
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnSubmitFile.setOnClickListener {
            raiseSubmitDialog()
        }
        return binding.root
    }

    private fun raiseSubmitDialog() {
        val binding = DialogInsertCodeBinding.inflate(LayoutInflater.from(requireContext()))
        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setView(binding.root)

        binding.etUniqueCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.btnEnter.isEnabled = s.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        //Todo: Need to change this if backend ready
        binding.btnEnter.setOnClickListener {
            Toast.makeText(context, binding.etUniqueCode.text, Toast.LENGTH_SHORT).show()
            findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToUploadFragment())
            builder.create().dismiss()
        }
        builder.create().show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    //TODO: need to change dummy data if backend ready
    private fun initRecycler() {
        val list = listOf(
            TaskList("31 MAR 2021 11.59", "Pengumpulan Laporan A", "k76tsy7"),
            TaskList("10 APR 2021 21.59", "Pengumpulan Laporan B", "82ihc4"),
            TaskList("20 APR 2021 21.59", "Pengumpulan Laporan C", "hy6712")
        )
        val adapter = MainPageAdapter(list)

        if (adapter.itemCount == 0) {
            binding.tvMainInformation.visibility = View.GONE
            binding.tvMainInformationEmpty.visibility = View.VISIBLE
        } else {
            binding.tvMainInformation.visibility = View.VISIBLE
            binding.tvMainInformationEmpty.visibility = View.GONE
        }

        binding.rvTaskList.adapter = MainPageAdapter(list)
    }
}