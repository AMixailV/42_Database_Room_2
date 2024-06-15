package ru.mixail_akulov.a42_database_room_2.screens.main.tabs.admin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mixail_akulov.a42_database_room_2.R
import ru.mixail_akulov.a42_database_room_2.Repositories
import ru.mixail_akulov.a42_database_room_2.databinding.FragmentAdminTreeBinding
import ru.mixail_akulov.a42_database_room_2.utils.resources.ContextResources
import ru.mixail_akulov.a42_database_room_2.utils.viewModelCreator

/**
 * Contains only RecyclerView which displays the whole tree of data from the database
 * starting from accounts and ending with box settings.
 */
class AdminFragment : Fragment(R.layout.fragment_admin_tree) {

    private lateinit var binding: FragmentAdminTreeBinding

    private val viewModel by viewModelCreator {
        AdminViewModel(Repositories.accountsRepository, ContextResources(requireContext()))
    }

    private lateinit var adapter: AdminItemsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdminTreeBinding.bind(view)

        val layoutManager = LinearLayoutManager(requireContext())
        adapter = AdminItemsAdapter(viewModel)

        binding.adminTreeRecyclerView.layoutManager = layoutManager
        binding.adminTreeRecyclerView.adapter = adapter

        observeTreeItems()
    }

    private fun observeTreeItems() {
        viewModel.items.observe(viewLifecycleOwner) { treeItems ->
            adapter.renderItems(treeItems)
        }
    }

}