package com.appislami.Tasbeh


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.appislami.R


class TasbehFragment : Fragment() {
    lateinit var numbercounter: TextView
    lateinit var azkar: TextView
    lateinit var bodyOfSebha: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tasbeh, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()


        var counter = 1
        var number = 0
        azkar.text = "سبحان الله"
        azkar.setOnClickListener {
            if (counter <= 32) {
                counter++

                number += 1
                numbercounter.text = number.toString()

            } else if (counter in 33..65) {


                counter += 1



                azkar.text = "الحمد لله"
                number = 0
                number += 1
                numbercounter.text = counter.toString()


            } else if (counter >= 64 && counter <= 98) {

                number = 0


                counter++

                number += 1
                numbercounter.text = counter.toString()
                azkar.text = "الله اكبر"


            } else {
                numbercounter.text = "100"
                azkar.text = "لا اله الا الله"
            }


        }
    }


    fun initViews() {
        bodyOfSebha = requireView().findViewById(R.id.bodyofsebha)
        numbercounter = requireView().findViewById(R.id.counter)

        azkar = requireView().findViewById(R.id.azkar)

    }

}


