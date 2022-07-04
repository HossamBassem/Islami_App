package com.appislami.Hadeth

import android.R.attr.button
import android.R.attr.onClick
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.appislami.Adpter.SuraNameAdpter
import com.appislami.R


class HadethFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false);


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var buttonBokhary: Button = requireView().findViewById(R.id.book1)
        buttonBokhary.setOnClickListener {
            val intent = Intent(requireContext(), HadethDetails::class.java)
            startActivity(intent)
        }


        var buttonMuslem: Button = requireView().findViewById(R.id.book2) as Button

    }

        }


