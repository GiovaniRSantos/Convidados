package com.example.convidados.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.databinding.FragmentAbsentsBinding
import com.example.convidados.view.adapter.GuestAdapter
import com.example.convidados.viewmodel.AllGuestsViewModel


class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private var _binding: FragmentAbsentsBinding? = null


    private val binding get() = _binding!!

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        allGuestsViewModel =
            ViewModelProvider(this)[AllGuestsViewModel::class.java]

        _binding = FragmentAbsentsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        LayoutInflater.from(context).inflate(R.layout.fragment_all, null)

        val recycler = view?.findViewById<RecyclerView>(R.id.recycler_all_guests)

        recycler?.adapter = mAdapter

        observer()
        allGuestsViewModel.load()
        return root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observer() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner) {
            mAdapter.updateGuests(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}