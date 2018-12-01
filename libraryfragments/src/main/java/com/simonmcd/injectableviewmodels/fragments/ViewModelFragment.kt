package com.simonmcd.injectableviewmodels.fragments

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject


abstract class ViewModelFragment<VIEW_BINDING : ViewDataBinding, VM : ViewModel> : Fragment() {

    lateinit var binding: VIEW_BINDING

    abstract val layoutResourceID: Int

    private inline fun <reified VM> viewModelClass() = VM::class.java

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceID, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)
        return binding.root
    }
}