package com.coner.mvvmapplication.ui.mainactivity

import com.coner.mvvmapplication.entity.Person
import com.coner.mvvmapplication.ui.base.BaseViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author coner
 */
class MainViewModel(view: MainActivity) : BaseViewModel<MainActivity, MainModel>(view), MainContract.ViewModel {
    override fun init() {
        mView?.let {
            it.bind?.person = Person("coner", 22, "男", "写代码")
            it.firstButton.setOnClickListener {
                getFirstPerson()
            }
            it.secondButton.setOnClickListener {
                getSecondPerson()
            }
        }
    }

    override fun setModel(): MainModel {
        return MainModel()
    }

    override fun getFirstPerson() {
        mView?.let { view ->
            mModel.getFirstPerson {
                view.bind?.person = it
            }
        }
    }

    override fun getSecondPerson() {
        mView?.let { view ->
            mModel.getSecondPerson {
                view.bind?.person = it
            }
        }
    }
}