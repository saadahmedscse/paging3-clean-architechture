package com.saadahmedev.paging.ui.root.tabs.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.saadahmedev.paging.base.BaseFragment
import com.saadahmedev.paging.databinding.FragmentHomeBinding
import com.saadahmedev.paging.helper.observe
import com.saadahmedev.paging.ui.root.tabs.home.viewmodel.HomeFragmentViewModel
import com.saadahmedev.paging.util.AppConstants.AppInfo.APP_NAME
import com.saadahmedev.paging.util.ProgressDialog
import com.saadahmedev.paging.util.ResponseState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val title: String
        get() = APP_NAME
    override val isBackButtonVisible: Boolean
        get() = false

    private val viewModel by viewModels<HomeFragmentViewModel>()
    private lateinit var progressDialog: ProgressDialog

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        viewModel.getUnions(1, 10)
    }

    override fun observeData() {
        observe(viewModel.unionList) {
            when (it) {
                is ResponseState.Loading -> {
                    Log.d("union_response_debug", "observeData: Loading")
                }

                is ResponseState.Success -> {
                    Log.d("union_response_debug", "observeData: Success Size ${it.data?.size}")
                }

                is ResponseState.Error -> {
                    Log.d("union_response_debug", "observeData: Failed ${it.message}")
                }
            }
        }
    }
}