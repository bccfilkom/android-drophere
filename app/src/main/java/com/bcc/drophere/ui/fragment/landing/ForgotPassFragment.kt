package com.bcc.drophere.ui.fragment.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bcc.drophere.databinding.FragmentForgotPassBinding

class ForgotPassFragment : Fragment() {

    private var _binding: FragmentForgotPassBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPassBinding.inflate(inflater, container, false)

        //TODO: change this if backend ready
        binding.btnReset.setOnClickListener {
            Toast.makeText(context, "Please Check Your Email Inbox", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}