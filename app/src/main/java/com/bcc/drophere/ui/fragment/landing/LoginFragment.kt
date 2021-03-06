package com.bcc.drophere.ui.fragment.landing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bcc.drophere.R
import com.bcc.drophere.databinding.FragmentLoginBinding
import com.bcc.drophere.ui.activity.MainActivity

class LoginFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        //TODO: add logic if backend ready
        binding.btnLogin.setOnClickListener(this)
        binding.btnRegisterDirection.setOnClickListener(this)
        binding.btnForgotPass.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            }
            R.id.btn_register_direction ->
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            R.id.btn_forgot_pass ->
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToForgotPassFragment())
        }
    }
}