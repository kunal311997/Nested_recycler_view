package com.example.nested_recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainArrayList = ArrayList<MainHeadingData>()

    val adapter by lazy {
        MainAdapter(mainArrayList, View.OnClickListener {
            val pos = it?.tag as Int
            val data = mainArrayList[pos]
            Log.e("Clicked !!", data.mainHeading)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addmainData()
        rvMainList.layoutManager = LinearLayoutManager(this)
        rvMainList.adapter = adapter

    }

    fun addmainData() {
        val subArrayList1 = ArrayList<SubHeadingData>()
        val sub1 = SubHeadingData("Sub Heading 1")
        val sub2 = SubHeadingData("Sub Heading 2")
        subArrayList1.add(sub1)
        subArrayList1.add(sub2)
        val main1 = MainHeadingData("Main Heading 1", subArrayList1)
        mainArrayList.add(main1)

        val subArrayList2 = ArrayList<SubHeadingData>()
        val sub3 = SubHeadingData("Sub Heading 3")
        subArrayList2.add(sub3)
        val main2 = MainHeadingData("Main Heading 2", subArrayList2)
        mainArrayList.add(main2)

        val subArrayList3 = ArrayList<SubHeadingData>()
        val sub4 = SubHeadingData("Sub Heading 4")
        val sub5 = SubHeadingData("Sub Heading 5")
        val sub6 = SubHeadingData("Sub Heading 6")
        subArrayList3.add(sub4)
        subArrayList3.add(sub5)
        subArrayList3.add(sub6)
        val main3 = MainHeadingData("Main Heading 3", subArrayList3)
        mainArrayList.add(main3)

        val subArrayList4 = ArrayList<SubHeadingData>()
        val sub7 = SubHeadingData("Sub Heading 7")
        val sub8 = SubHeadingData("Sub Heading 8")
        subArrayList4.add(sub7)
        subArrayList4.add(sub8)
        val main4 = MainHeadingData("Main Heading 4", subArrayList4)
        mainArrayList.add(main4)

    }
}