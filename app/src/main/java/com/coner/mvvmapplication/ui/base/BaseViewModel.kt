package com.coner.mvvmapplication.ui.base

import androidx.lifecycle.ViewModel

/**
 * @author coner
 * ViewModel的基类
 */
open abstract class BaseViewModel<V: MVVMActivity<*, *>, M> : ViewModel {
    var mView: V?
    var mModel: M

    constructor(view: V) {
        mView = view
        mModel = setModel()
        init()
    }

    /**
     * 将持有activity对象的引用清空，防止内存泄漏
     */
    override fun onCleared() {
        super.onCleared()
        mView = null
    }

    abstract fun setModel(): M
    abstract fun init()
}