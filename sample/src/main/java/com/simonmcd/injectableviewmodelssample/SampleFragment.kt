package com.simonmcd.injectableviewmodelssample

import com.simonmcd.injectableviewmodels.fragments.ViewModelFragment
import com.simonmcd.injectableviewmodelssample.databinding.SampleBinding


class SampleFragment : ViewModelFragment<SampleBinding, SampleViewModel>() {

    override val layoutResourceID = R.layout.sample

    init {
        App.graph.inject(this)
    }

}