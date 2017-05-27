package com.abhat.`fun`

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SwitchCompat
import android.widget.CompoundButton

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var mGood: SwitchCompat? = null
    private var mCheap: SwitchCompat? = null
    private var mFast: SwitchCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mGood = findViewById(R.id.good) as SwitchCompat
        mCheap = findViewById(R.id.cheap) as SwitchCompat
        mFast = findViewById(R.id.fast) as SwitchCompat

        mGood!!.setOnCheckedChangeListener(this)
        mCheap!!.setOnCheckedChangeListener(this)
        mFast!!.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(compoundButton: CompoundButton, checked: Boolean) {
        when (compoundButton.id) {
            R.id.good -> if (mCheap!!.isChecked && mFast!!.isChecked) {
                mFast!!.setOnCheckedChangeListener(null)
                mFast!!.isChecked = false
                mFast!!.setOnCheckedChangeListener(this)
            }
            R.id.cheap -> if (mGood!!.isChecked && mFast!!.isChecked) {
                mGood!!.setOnCheckedChangeListener(null)
                mGood!!.isChecked = false
                mGood!!.setOnCheckedChangeListener(this)
            }
            R.id.fast -> if (mGood!!.isChecked && mCheap!!.isChecked) {
                mCheap!!.setOnCheckedChangeListener(null)
                mCheap!!.isChecked = false
                mCheap!!.setOnCheckedChangeListener(this)
            }
        }
    }
}
