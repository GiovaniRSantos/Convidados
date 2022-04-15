package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.databinding.FragmentAbsentsBinding
import com.example.convidados.viewmodel.AbsentViewModel

class AbsentFragment : Fragment() {

private var _binding: FragmentAbsentsBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val slideshowViewModel =
        ViewModelProvider(this)[AbsentViewModel::class.java]

    _binding = FragmentAbsentsBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textAbsents
    slideshowViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}