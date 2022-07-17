package com.appislami.Tasbeh

import android.R.attr.*
import android.graphics.Matrix
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.appislami.R
import kotlin.Int as Int1


class TasbehFragment : Fragment() {
    lateinit var numbercounter: TextView
    lateinit var     azkar: TextView
    lateinit var bodyOfSebha:ImageView

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


        var counter = 0
        var number = 0
        azkar.text = "سبحان الله"
        azkar.setOnClickListener {



                azkar.text="سبحان الله"
                number += 1

                numbercounter.text = number.toString()
                azkar.text = "سبحان الله"


            if (counter == 33) {
                number = 1


                numbercounter.text = number.toString()
                azkar.text = "الحمد لله"
            }
            azkar.setOnClickListener {
                number += 1
                counter++
                numbercounter.text = number.toString()
                azkar.text = "الحمد لله"
            }


            if (counter.equals(66)) {
                number = 1
                counter++
                numbercounter.text = number.toString()
                azkar.setOnClickListener {
                    number += 1
                    numbercounter.text = number.toString()
                    azkar.text = "الله اكبر"

                }
            }


        }
    }







     //   ClickOnAzkar()


       /* numbercounter.setOnClickListener(View.OnClickListener {
            number=number+1
            numbercounter.setText(number.toString())
            print(numbercounter)

        })*/
       fun initViews(){
          bodyOfSebha=requireView().findViewById(R.id.bodyofsebha)
           numbercounter=requireView().findViewById(R.id.counter)

           azkar=requireView().findViewById(R.id.azkar)

       }
}
  /*  fun ClickOnAzkar(){
        azkar.setOnClickListener {
            if (number.equals(0)){
                val name :String="سبحان الله"
                azkar.setText(""+name)
                for(i:Int in 1..33){
                    numbercounter.setText(i).toString()
                }
                number=0
            }

        }
    }*/




