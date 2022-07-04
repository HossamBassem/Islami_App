package com.appislami.Hadeth

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import com.appislami.Adpter.Constant
import com.appislami.R
import com.appislami.mainActivity.PDFAdapter
import com.github.barteksc.pdfviewer.PDFView
import java.io.File
import java.io.InputStream
import java.time.Clock.offset
import java.time.temporal.TemporalQueries.offset

class HadethDetails:AppCompatActivity() {
//lateinit var PDFView: PDFView
  /*  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hadeth_details)
      //  PDFView= findViewById(R.id.pdfView)
    //    PDFView.fromAsset("book1.pdf").load()
    }*/
    lateinit var pageViewPager: ViewPager2
    var parcelFileDescriptor: ParcelFileDescriptor? = null
    var pdfAdapter: PDFAdapter? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hadeth_details)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        pageViewPager = findViewById(R.id.pageViewPager)

        with(pageViewPager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }


        val pageMarginPx = 40
        val offsetPx = 70

        pageViewPager.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }

        initPdfViewer(getFile())

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initPdfViewer(pdfFile : File){
        try {
            pageViewPager.visibility = View.VISIBLE
            //baseProgressBar.visibility = View.GONE

            parcelFileDescriptor = ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY)
            pdfAdapter = PDFAdapter(parcelFileDescriptor!!, this)
            pageViewPager.adapter = pdfAdapter

        }catch (e: Exception){
            pdfFile.delete()
        }
    }

    fun getFile() : File{
        val inputStream = assets.open("book 1.pdf")
        return File(filesDir.absolutePath + "book 1.pdf").apply {
            copyInputStreamToFile(inputStream)
        }
    }

    fun File.copyInputStreamToFile(inputStream: InputStream) {
        this.outputStream().use { fileOut ->
            inputStream.copyTo(fileOut)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDestroy() {
        super.onDestroy()
        parcelFileDescriptor?.close()
        pdfAdapter?.clear()

    }

}