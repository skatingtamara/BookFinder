package com.example.bookfinder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.bookfinder.databinding.FragmentResultsBinding
import com.example.bookfinder.model.BookViewModel


/**
 * Fragment where the book search results are displayed.
 * The user can navigate to the source to take action or learn more.
 */

class ResultsFragment : Fragment() {

    // Initializes the view model and remembers device stat through config changes
    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: BookViewModel by activityViewModels()

    // Binding object instance corresponding to the fragment_results.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var _binding: FragmentResultsBinding? = null

    private val binding get() = _binding!!

    private val TAG = "BookLog"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d(TAG, "onCreateView: ResultsFragment")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // Assign the view model to a property in the binding class
            viewModel = sharedViewModel

            // Assign the fragment
            resultsFragment = this@ResultsFragment

        }
        Log.d(TAG, "onViewCreated: ResultsFragment")

    }



}
