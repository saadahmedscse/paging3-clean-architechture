package com.saadahmedev.paging.ui.root

import android.os.Bundle
import com.saadahmedev.paging.base.BaseActivity
import com.saadahmedev.paging.databinding.ActivityRootBinding
import com.saadahmedev.paging.databinding.AppToolbarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : BaseActivity<ActivityRootBinding>(ActivityRootBinding::inflate) {

    override val toolbarBinding: AppToolbarBinding
        get() = binding.appToolbar

    override fun onActivityCreate(savedInstanceState: Bundle?) {
        binding.viewmodel = rootViewModel
    }

    override fun observeData() {}
}