package com.bcc.drophere.ui.fragment.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.bcc.drophere.R
import com.bcc.drophere.databinding.FragmentCarouselContentBinding

class CarouselContentFragment : Fragment() {

    private var _binding: FragmentCarouselContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCarouselContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey("PASS_DATA") }?.apply {
            getImage(getStringArray("PASS_DATA")!![0])
            binding.tvTitle.text = getStringArray("PASS_DATA")!![1]
            binding.tvInfo.text = getStringArray("PASS_DATA")!![2]
        }
    }

    private fun getImage(image: String) {
        when (image) {
            "Page 1" ->
                binding.imgCarousel.load(R.drawable.ic_submit_illustration)
            "Page 2" ->
                binding.imgCarousel.load(R.drawable.ic_walk_illustration)
        }
    }
}