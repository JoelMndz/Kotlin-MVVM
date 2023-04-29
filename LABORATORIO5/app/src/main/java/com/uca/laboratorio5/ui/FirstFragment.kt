package com.uca.laboratorio5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uca.laboratorio5.R;

// TODO: Rename parameter arguments, choose names that match

lateinit var actionBtn: FloatingActionButton
class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionBtn = view.findViewById(R.id.actionButton)

        actionBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_newFragment)
        }
    }
}