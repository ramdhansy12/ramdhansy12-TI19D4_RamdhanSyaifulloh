package com.ramdhansyaifulloh.myapplication

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.ramdhansyaifulloh.myapplication.adapter.AdapterTokoh
import com.ramdhansyaifulloh.myapplication.databinding.ActivityMainBinding
import com.ramdhansyaifulloh.myapplication.model.Tokoh

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listTokoh = ArrayList<Tokoh>()
        listTokoh.add(Tokoh("Sri Mulyani Indrawati",R.drawable.sri, "Bandar Lampung", "26 Agustus 1962", "Belajar dari kegagalan adalah hal yang bijak"))
        listTokoh.add(Tokoh("Ario Anindito",R.drawable.ario, "Bandung", "26 september 1997", "Diamku lebih berarti daripada kata-kata yang tak bermakna"))
        listTokoh.add(Tokoh("Susi Pudjiastuti",R.drawable.susi, "Kecamatan Pangandaran", "15 Januari 1965", "Disiplin diri adalah sebenar-benarnya wujud kebebasan yang hakiki."))
        listTokoh.add(Tokoh("Angkie Yudistia",R.drawable.angke, "Medan", "5 Juni 1987", "Hidup adalah pelajaran tentang kerendahan hati"))
        listTokoh.add(Tokoh(" Colonel (Harland) Sanders",R.drawable.colonel, "Amerika", "9 September 1890", "Genggam lah dunia sebelum dunia menggenggammu"))
        listTokoh.add(Tokoh("Adele Laurie Blue Adkins",R.drawable.adele, "London", "5 Mei 1988 ", "Hidup kita mulai berakhir saat kita berdiam diri tentang apapun masalah yang ada di sekitar"))
        listTokoh.add(Tokoh("Stephen Hawking",R.drawable.stephenhawking, "Cambridge", "8 Januari 1942", "Karyamu akan menempati bagian tersendiri dalam hidupmu"))
        listTokoh.add(Tokoh("Oprah Winfrey",R.drawable.oprah, "Amerika", "29 Januari 1954", "Setiap kesulitan selalu ada kemudahan. Setiap masalah pasti ada solusi."))
        listTokoh.add(Tokoh("Zig Ziglar",R.drawable.zigziglar, "Texas", " 6 November 1926,", "Jika Anda takut gagal, Anda tidak pantas untuk sukses"))
        listTokoh.add(Tokoh("J.K Rowling",R.drawable.jkrowling, "Britina Raya", "31 Juli 1965", "Keyakinan diri dan kerja keras akan selalu membuat Anda sukses"))

        binding.list.adapter = AdapterTokoh (this, listTokoh,object : AdapterTokoh.OnClikListener{
            override fun detailData(item: Tokoh?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_tokoh)

                    val image = this.findViewById<ImageView>(R.id.image_tokoh)
                    val nama = this.findViewById<TextView>(R.id.txtnama)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttmptlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttgllahir)
                    val motto = this.findViewById<TextView>(R.id.txtmotto)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"
                    motto.text = "${item?.motto}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode (selectedMode : Int){
        when (selectedMode){
            R.id.myprofile -> {
                val  intent = Intent ( this,profile::class.java)
                startActivity(intent)
            }
        }
    }
}