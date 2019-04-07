package com.example.contactlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_portrait.*

class PortraitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portrait)

        var intentThatStartedThisActivity = getIntent()
        var imgId = intentThatStartedThisActivity.getIntExtra("imgId", 0)
        imageView.setImageResource(imgId)
    }
}
