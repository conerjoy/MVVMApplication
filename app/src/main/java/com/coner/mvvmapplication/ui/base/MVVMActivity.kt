package com.coner.mvvmapplication.ui.base

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author coner
 * MVVM模式的activity基类
 */
abstract class MVVMActivity<VDB : ViewDataBinding, VM> : AppCompatActivity() {
    var bind: VDB? = null
    var mViewModel: VM? = null
    private var mDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(
            this,
            setLayoutRes()
        )
        mViewModel = setViewModel()
        init()
    }

    fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun dialog(message: String) {
        mDialog = AlertDialog.Builder(this).setTitle("提示").setMessage(message).setNegativeButton("取消") { dialog, which ->
            mDialog?.dismiss()
            toast("点击了取消")
        }.setPositiveButton("确定") { dialog, which ->
            mDialog?.dismiss()
            toast("点击了确定")
        }.create()
        mDialog?.show()
    }

    /**
     * 子类需要使用的方法
     * ------------------------------------------------------
     */
    open fun init() {}
    abstract fun setLayoutRes(): Int
    abstract fun setViewModel(): VM
}