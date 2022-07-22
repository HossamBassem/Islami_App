package com.appislami.Radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.appislami.Network.ApiManager
import com.appislami.Network.RadioResponse
import com.appislami.Network.RadiosItem
import com.appislami.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {
lateinit var mediaBack:ImageView
    lateinit var mediaStart:ImageView
    lateinit var mediaForward:ImageView
    lateinit var channelName:TextView
    lateinit var itemsList:ArrayList<RadiosItem>
    var pos=0
    var isPlaying:Boolean=false
lateinit var progressBar:ProgressBar
    var mediaPlayer =MediaPlayer()
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio, container, false);
        initViews()
            getDataFromApi()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getDataFromApi()
    }

    private fun getDataFromApi() {
        ApiManager.getApi().getRadoiDataFromApi().enqueue(object :Callback<RadioResponse>{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                Log.e("done",response.body().toString())
                itemsList= response.body()?.radios as ArrayList<RadiosItem>
                channelName.text = itemsList.get(pos).name

            }

            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                Log.e("not",t.message.toString())
            }

        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun playSound(i:Int) {
        val url = itemsList.get(i).uRL// your URL here
      mediaPlayer=  MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync() // might take long! (for buffering, etc)

        }
        mediaPlayer.setOnPreparedListener {
            mediaPlayer.start()
            progressBar.isVisible=false
            //mediaPlayer.start()
            mediaStart.setImageResource(R.drawable.stop_icon)

        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initViews(){
    mediaBack=requireView().findViewById(R.id.backbtn)
    mediaStart=requireView().findViewById(R.id.startbtn)
    mediaForward=requireView().findViewById(R.id.forwardbtn)
    channelName=requireView().findViewById(R.id.chanel_name)
        progressBar=requireView().findViewById(R.id.progressbar)
        mediaStart.setOnClickListener {

            if (!isPlaying){
                isPlaying=true
                progressBar.isVisible=false
                mediaStart.setImageResource(R.drawable.stop_icon)
                channelName.text = itemsList[pos].name
                playSound(pos)


            }
           else if (isPlaying){
                mediaPlayer.stop()
                isPlaying=false
                mediaStart.setImageResource(R.drawable.play_icon)
                channelName.text= itemsList[pos].name


            }else{
                mediaPlayer.stop()
                mediaStart.setImageResource(R.drawable.play_icon)
            }

        }
        mediaForward.setOnClickListener {
            pos++
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
            channelName.text = itemsList.get(pos).name
            playSound(pos)
        }
        mediaBack.setOnClickListener {
            pos=pos-1
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
            channelName.text = itemsList.get(pos).name
            playSound(pos)
        }
}
}