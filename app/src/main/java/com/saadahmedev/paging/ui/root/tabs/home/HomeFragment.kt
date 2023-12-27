package com.saadahmedev.paging.ui.root.tabs.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.saadahmedev.paging.base.BaseFragment
import com.saadahmedev.paging.databinding.FragmentHomeBinding
import com.saadahmedev.paging.helper.observe
import com.saadahmedev.paging.helper.setLinearLayoutManager
import com.saadahmedev.paging.ui.root.tabs.home.adapter.UnionAdapter
import com.saadahmedev.paging.ui.root.tabs.home.viewmodel.HomeFragmentViewModel
import com.saadahmedev.paging.util.AppConstants.AppInfo.APP_NAME
import com.saadahmedev.paging.util.ProgressDialog
import com.saadahmedev.paging.util.ResponseState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val title: String
        get() = APP_NAME
    override val isBackButtonVisible: Boolean
        get() = false

    private val viewModel by viewModels<HomeFragmentViewModel>()
    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: UnionAdapter

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        progressDialog = ProgressDialog.getInstance(requireContext())
        binding.recyclerView.setLinearLayoutManager(requireContext())
        adapter = UnionAdapter()
        binding.recyclerView.adapter = adapter

        getData()
    }

    override fun observeData() {
        observe(viewModel.loadingState) {
            if (it) progressDialog.show("Union data is fetching...")
            else progressDialog.dismiss()
        }
    }

    private fun getData() {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.getUnions().collectLatest {
                adapter.submitData(lifecycle, it)
            }
        }
    }
}