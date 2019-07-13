package com.cykidz.truyendulieuquafragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_result.*


class Result : Fragment() {
    var text: String? = null
    var chuoiso: ArrayList<Int>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString("KEY.edt")
            chuoiso = it.getIntegerArrayList("KEY.chuoiso")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var length = text!!.length
        var max: Int = text?.substring(0, 1)!!.toInt()
        var min: Int = text?.substring(0, 1)!!.toInt()
        var tonga = " "
        var chuoimaxsize = chuoiso!!.size
        var chuoimax = chuoiso!![0]
        var chuoimin = chuoiso!![0]
        txts.text = text
        ///////////////////////

        for (i in 1 until length + 1) {
            for (j in i - 1 until i) {
                //Log.d("III", i.toString() + " " + j.toString())
                if (max < text.toString().substring(j, i).toInt()) {
                    max = text.toString().substring(j, i).toInt()
                }
                if (min > text.toString().substring(j, i).toInt()) {
                    min = text.toString().substring(j, i).toInt()
                }
                txtrsmin.text = "So nho nhat la $min"
                txtrsmax.text = "So lon nhat la $max"
            }
        }

        for (i in 0 until chuoimaxsize) {
            if (chuoimax < chuoiso!![i]) {
                chuoimax = chuoiso!![i]
            }
            if (chuoimin > chuoiso!![i]) {
                chuoimin = chuoiso!![i]
            }
            txtamax.text = "Phan tu lon nhat la $chuoimax"
            txtamin.text = "Phan tu nho nhat la $chuoimin"
            tonga += chuoiso!![i].toString() + " "
            //Log.d("tonga", tonga)
            txta.text = tonga
        }
    }
}