package com.uca.laboratorio5.ui

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uca.laboratorio5.MovieReviewerApplication
import com.uca.laboratorio5.R
import com.uca.laboratorio5.data.model.MovieModel
import com.uca.laboratorio5.data.model.movies
import com.uca.laboratorio5.repositories.MovieRepository

/**
 * A simple [Fragment] subclass.
 * Use the [newMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class newMovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var txtName: EditText
    private lateinit var txtCategory: EditText
    private lateinit var txtDescription: EditText
    private lateinit var txtCalification: EditText
    private lateinit var actionBtn: Button

    private val viewModel: MovieViewModel by viewModels{MovieViewModelFactory(MovieRepository(movies))}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.txtName);
        txtCategory = view.findViewById(R.id.txtCategory);
        txtDescription = view.findViewById(R.id.txtDescription);
        txtCalification = view.findViewById(R.id.txtCalification);
        actionBtn = view.findViewById(R.id.btnSubmit)

        actionBtn.setOnClickListener {
            try {
                if(txtName.text.toString().isNullOrBlank() ||
                    txtCategory.text.toString().isNullOrBlank() ||
                    txtDescription.text.toString().isNullOrBlank() ||
                    txtCalification.text.toString().isNullOrBlank()){
                    Toast.makeText(context,"Llene todos los campos!",Toast.LENGTH_SHORT).show()
                }
                viewModel.addMovies(
                    MovieModel(
                        txtName.text.toString(),
                        txtCategory.text.toString(),
                        txtDescription.toString(),
                        txtCalification.toString()
                    )
                )
                it.findNavController().navigate(R.id.action_newFragment_to_firtFargment)

            }catch (error:Exception){
                Log.println(Log.ERROR,"Errpr",error.toString())
                Toast.makeText(context,error.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment newMovieFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            newMovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}