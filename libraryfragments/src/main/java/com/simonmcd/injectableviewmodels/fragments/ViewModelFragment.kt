package com.simonmcd.injectableviewmodels.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject


abstract class ViewModelFragment<VIEW_BINDING : ViewDataBinding, VM : ViewModel> : Fragment() {

    lateinit var binding: VIEW_BINDING

    abstract val layoutResourceID: Int

    abstract val viewModelClass: Class<VM>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceID, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)
        return binding.root
    }
}