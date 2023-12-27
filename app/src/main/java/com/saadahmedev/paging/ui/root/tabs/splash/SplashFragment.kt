package com.saadahmedev.paging.ui.root.tabs.splash

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.saadahmedev.paging.R
import com.saadahmedev.paging.base.BaseFragment
import com.saadahmedev.paging.databinding.FragmentSplashBinding
import com.saadahmedev.paging.helper.observe
import com.saadahmedev.paging.ui.root.tabs.splash.viewmodel.SplashFragmentViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val title: String
        get() = ""
    override val isBackButtonVisible: Boolean
        get() = false

    private val splashFragmentViewModel by viewModels<SplashFragmentViewModel>()

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        splashFragmentViewModel.start()
        rootViewModel.isSplashActivity.set(true)
    }

    override fun observeData() {
        observe(splashFragmentViewModel.onSplashComplete) {
            navigate(R.id.action_splashFragment_to_homeFragment)
            rootViewModel.isSplashActivity.set(false)
        }
    }
}