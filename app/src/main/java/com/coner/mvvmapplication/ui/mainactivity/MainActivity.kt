package com.coner.mvvmapplication.ui.mainactivity

import com.coner.mvvmapplication.R
import com.coner.mvvmapplication.databinding.ActivityMainBinding
import com.coner.mvvmapplication.ui.base.MVVMActivity

/**
 * @author coner
 */
class MainActivity : MVVMActivity<ActivityMainBinding, MainViewModel>() {
    override fun setLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun setViewModel(): MainViewModel {
        return MainViewModel(this)
    }
}
