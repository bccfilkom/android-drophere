package com.bcc.drophere.ui.fragment.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bcc.drophere.R
import com.bcc.drophere.adapter.CarouselPagerAdapter
import com.bcc.drophere.databinding.FragmentCarouselBinding
import com.google.android.material.tabs.TabLayoutMediator

class CarouselFragment : Fragment() {

    private var _binding: FragmentCarouselBinding? = null
    private val binding get() = _binding!!
    private val pageNumber = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCarouselBinding.inflate(inflater, container, false)

        binding.btnSkip.setOnClickListener {
            findNavController()
                .navigate(CarouselFragmentDirections.actionCarouselFragmentToRegisterFragment())
        }

        binding.btnContinue.setOnClickListener {
            findNavController()
                .navigate(CarouselFragmentDirections.actionCarouselFragmentToLoginFragment())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CarouselPagerAdapter(this, getContents(), pageNumber)
        binding.mainPage.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.mainPage) { _, _ -> }.attach()
    }

    private fun getContents(): List<Array<String>> {
        val item1 = arrayOf(
            "Page 1",
            getString(R.string.tv_title_page_1),
            getString(R.string.tv_info_page_1)
        )
        val item2 = arrayOf(
            "Page 2",
            getString(R.string.tv_title_page_2),
            getString(R.string.tv_info_page_2)
        )

        return arrayListOf(item1, item2)
    }
}