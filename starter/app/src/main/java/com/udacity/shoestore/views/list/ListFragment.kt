package com.udacity.shoestore.views.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListFragmentBinding
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding

class ListFragment : Fragment() {

    private val listViewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: ListFragmentBinding = DataBindingUtil
            .inflate(
                inflater, R.layout.list_fragment, container, false
            )

        binding
            .btAdd
            .setOnClickListener {
                findNavController()
                    .navigate(ListFragmentDirections.actionsListToDetail())
            }

        createObservers(binding)
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun createObservers(binding: ListFragmentBinding) {
        listViewModel
            .shoesList
            .observe(viewLifecycleOwner, Observer { list ->
                binding.listShoes.removeAllViews()

                list.forEach { shoe ->
                    val inflater = LayoutInflater.from(binding.listShoes.context)
                    val shoeBinding: ShoeDetailFragmentBinding =
                        ShoeDetailFragmentBinding
                            .inflate(inflater, binding.listShoes, true)

                    shoeBinding.shoe = shoe
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController()
                    .navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}