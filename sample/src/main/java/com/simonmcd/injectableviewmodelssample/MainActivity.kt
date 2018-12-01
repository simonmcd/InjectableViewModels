package com.simonmcd.injectableviewmodelssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_content, SampleFragment())
            transaction.commit()
        }
    }
}
