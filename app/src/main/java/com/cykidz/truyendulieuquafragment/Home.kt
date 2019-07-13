package com.cykidz.truyendulieuquafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var chuoiso : ArrayList<Int> = ArrayList()
        button.setOnClickListener {
            chuoiso.add(edtpt1.text.toString().toInt())

            chuoiso.add(edtpt2.text.toString().toInt())

            chuoiso.add(edtpt3.text.toString().toInt())
            val bundle = Bundle().apply {
                putString("KEY.edt", edtchuoi.text.toString())
                putIntegerArrayList("KEY.chuoiso",chuoiso)
            }
            Navigation.findNavController(it).navigate(R.id.result,bundle)
        }
    }
}