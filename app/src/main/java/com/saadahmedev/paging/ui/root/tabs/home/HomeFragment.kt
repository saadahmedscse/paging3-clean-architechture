package com.saadahmedev.paging.ui.root.tabs.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.saadahmedev.paging.base.BaseFragment
import com.saadahmedev.paging.databinding.FragmentHomeBinding
import com.saadahmedev.paging.ui.root.tabs.home.viewmodel.HomeFragmentViewModel
import com.saadahmedev.paging.util.AppConstants.AppInfo.APP_NAME
import com.saadahmedev.paging.util.ProgressDialog

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val title: String
        get() = APP_NAME
    override val isBackButtonVisible: Boolean
        get() = false

    private val viewModel by viewModels<HomeFragmentViewModel>()
    private lateinit var progressDialog: ProgressDialog

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {
        //
    }
}