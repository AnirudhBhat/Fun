package com.abhat.`fun`

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        good.setOnCheckedChangeListener(this)
        cheap.setOnCheckedChangeListener(this)
        fast.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(compoundButton: CompoundButton, checked: Boolean) {
        when (compoundButton.id) {
            R.id.good -> if (cheap.isChecked && fast.isChecked) {
                fast.setOnCheckedChangeListener(null)
                fast.isChecked = false
                fast.setOnCheckedChangeListener(this)
            }
            R.id.cheap -> if (good.isChecked && fast.isChecked) {
                good.setOnCheckedChangeListener(null)
                good.isChecked = false
                good.setOnCheckedChangeListener(this)
            }
            R.id.fast -> if (good.isChecked && cheap.isChecked) {
                cheap.setOnCheckedChangeListener(null)
                cheap.isChecked = false
                cheap.setOnCheckedChangeListener(this)
            }
        }
    }
}
