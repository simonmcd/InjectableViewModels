package com.simonmcd.injectableviewmodelssample

import androidx.lifecycle.ViewModel
import javax.inject.Inject


class SampleViewModel @Inject constructor() : ViewModel() {

    val heading = "Heading"
    val body = "Body text"
}