package com.example.bookfinder

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookfinder.databinding.FragmentSearchBinding
import com.example.bookfinder.model.BookViewModel


/**
 * Fragment where the book title is entered.
 */

class SearchFragment : Fragment() {

    // Initializes the view model and remembers device stat through config changes
    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: BookViewModel by activityViewModels()

    // Binding object instance corresponding to the fragment_search.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val TAG = "BookLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        Log.d(TAG, "onCreate: SearchFragment")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d(TAG, "onCreateView: SearchFragment")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.searchFragment = this
        Log.d(TAG, "onViewCreated: SearchFragment")
       // Log.d(TAG, "onViewCreated - Search fragment title: ${getTitle()}")
        binding.submitButton.setOnClickListener {
            onSubmitBook() }

    }

    private fun onSubmitBook() {
        val userBook = binding.bookInputEditText.text.toString()
        sharedViewModel.setBook(userBook)
        Log.d(TAG, "Submit Button has saved book title: ${sharedViewModel.book} ")
        // Create an action once the button is clicked
        val action = SearchFragmentDirections.actionSearchFragmentToResultsFragment(book = sharedViewModel.book)
        findNavController().navigate(action)
    }

    /**
     * Navigate to the next screen to see the search results
     */
    //fun goToNextScreen(val next: navDirect ) {
      //  findNavController().navigate(navDirection)
        //findNavController().navigate(R.id.action_searchFragment_to_resultsFragment)
    //}



    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

*/

}
