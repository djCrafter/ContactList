package com.example.contactlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_parts.layoutManager = LinearLayoutManager(this)

        rv_parts.hasFixedSize()

        var testData = createTestData()
        rv_parts.adapter = PartAdapter(testData, {partItem : PartData -> partItemClicked(partItem)})
    }


    private fun partItemClicked(partItem : PartData) {
        Toast.makeText(this, "Clicked: ${partItem.name}", Toast.LENGTH_LONG).show()

        val intent = Intent(this, PartsDetailActivity::class.java)
        intent.putExtra("imgId", partItem.pict)
        intent.putExtra("person_name", partItem.name)
        intent.putExtra("person_phone", partItem.phone)
        intent.putExtra("person_company", partItem.company)
        intent.putExtra("person_characteristic", partItem.characteristic)

        startActivity(intent)
    }

    private fun createTestData() : List<PartData> {

        var c_test_content = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, " +
                "totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae " +
                "vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, " +
                "sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. " +
                "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non" +
                " numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat " +
                "voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nis" +
                "i ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui i" +
                "n ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla" +
                " pariatur?"

        var partList = ArrayList<PartData>()
        partList.add(PartData("Андрей Иванов", "+380687327445", "MetInvest", c_test_content, R.drawable.person1))
        partList.add(PartData("Елена Петрова", "+380631036545", "ISD", c_test_content, R.drawable.person2))
        partList.add(PartData("Дональд", "+380976421212", "USA", c_test_content, R.drawable.person3))
        partList.add(PartData("Ирина Васечкина", "+380671321232", "Paribas Group", c_test_content, R.drawable.person4))
        partList.add(PartData("Дмитрий Тахновский", "+380672135421", "Region LTD", c_test_content, R.drawable.person5))
        partList.add(PartData("Николай Павлов", "+380632481212", "DDAP-RAX", c_test_content, R.drawable.person6))

        return partList
    }

}
