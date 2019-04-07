package com.example.contactlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_parts_detail.*

class PartsDetailActivity : AppCompatActivity() {

     var imgId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parts_detail)
        getData()

       detail_image.setOnClickListener {
           val intent = Intent(this, PortraitActivity::class.java)
           intent.putExtra("imgId", imgId)
           startActivity(intent)
       }
    }



    fun getData(){
        var intentThatStartedThisActivity = getIntent()

        imgId = intentThatStartedThisActivity.getIntExtra("imgId", 0)
        var name = intentThatStartedThisActivity.getStringExtra("person_name")
        var phone = intentThatStartedThisActivity.getStringExtra("person_phone")
        var company = intentThatStartedThisActivity.getStringExtra("person_company")
        var characteristic = intentThatStartedThisActivity.getStringExtra("person_characteristic")

        detail_image.setImageResource(imgId)
        name_label.text = name
        company_label.text = company
        phone_label.text = phone
        characteristic_label.text = characteristic
    }
}
