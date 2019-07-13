package com.cykidz.truyendulieuquafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_result.*


class Result : Fragment() {
    var chuoi: String? = null
    var mang: ArrayList<Int>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chuoi = it.getString("KEY.chuoiso")
            mang = it.getIntegerArrayList("KEY.mang")
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
        var length = chuoi!!.length
        var max: Int = chuoi?.substring(0, 1)!!.toInt()
        var min: Int = chuoi?.substring(0, 1)!!.toInt()
        var tonga = " "
        var mangmaxsize = mang!!.size
        var chuoimax = mang!![0]
        var chuoimin = mang!![0]
        txts.text = chuoi
        ///////////////////////

        for (i in 1 until length + 1) {
            for (j in i - 1 until i) {
                //Log.d("III", i.toString() + " " + j.toString())
                if (max < chuoi.toString().substring(j, i).toInt()) {
                    max = chuoi.toString().substring(j, i).toInt()
                }
                if (min > chuoi.toString().substring(j, i).toInt()) {
                    min = chuoi.toString().substring(j, i).toInt()
                }
                txtrsmin.text = "So nho nhat la $min"
                txtrsmax.text = "So lon nhat la $max"
            }
        }

        for (i in 0 until mangmaxsize) {
            if (chuoimax < mang!![i]) {
                chuoimax = mang!![i]
            }
            if (chuoimin > mang!![i]) {
                chuoimin = mang!![i]
            }
            txtamax.text = "Phan tu lon nhat la $chuoimax"
            txtamin.text = "Phan tu nho nhat la $chuoimin"
            tonga += mang!![i].toString() + " "
            //Log.d("tonga", tonga)
            txta.text = tonga
        }
    }
}