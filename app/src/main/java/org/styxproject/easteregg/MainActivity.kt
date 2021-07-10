package org.styxproject.easteregg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import org.styxproject.easteregg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val datalist = ArrayList<Model>()
        datalist.add(Model(Build.MODEL + " (" + Build.DEVICE + ")"))
        datalist.add(Model("Android " + Build.VERSION.RELEASE))
        datalist.add(Model(Build.FINGERPRINT))
        datalist.add(Model("CPU: " + Build.HARDWARE))
        datalist.add(Model(Build.PRODUCT + "/" + Build.ID + "/" + Build.TAGS))
        datalist.add(Model(Build.HOST))
        val rvAdapter = RvAdapter(datalist)
        binding.recyclerView.adapter = rvAdapter
    }
}




