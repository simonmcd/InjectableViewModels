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

/**
 * A Fragment that will use the [VIEW_BINDING] specified for its UI and will inject the [VM] specified. The [VM] must be
 * provided through the injected [ViewModelProvider.Factory].
 */
abstract class ViewModelFragment<VIEW_BINDING : ViewDataBinding, VM : ViewModel> : Fragment() {

    lateinit var binding: VIEW_BINDING

    /**
     * The resource ID for this Fragment.
     */
    abstract val layoutResourceID: Int

    /**
     * The class of ViewModel to be injected.
     */
    abstract val viewModelClass: Class<VM>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by lazy {
        val viewModelProvider = if (limitViewModelScopeToFragment) {
            ViewModelProviders.of(this, viewModelFactory)
        } else {
            ViewModelProviders.of(requireActivity(), viewModelFactory)
        }
        viewModelProvider.get(viewModelClass)
    }
    /**
     * When true, the ViewModel provided will be tied to the Fragment. Otherwise it will be tied to the parent Activity.
     * By sharing with the parent Activity multiple Fragments may share data using the same ViewModel instance.
     */
    protected open val limitViewModelScopeToFragment = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceID, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)
        return binding.root
    }
}