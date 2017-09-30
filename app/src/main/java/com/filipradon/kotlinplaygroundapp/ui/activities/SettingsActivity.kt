package com.filipradon.kotlinplaygroundapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.filipradon.kotlinplaygroundapp.R
import com.filipradon.kotlinplaygroundapp.ui.utils.DelegatesExtensions
import kotlinx.android.synthetic.main.activity_settings.cityCode
import kotlinx.android.synthetic.main.toolbar.toolbar

/**
 * Created by filipradon on 30/09/17.
 */
class SettingsActivity : AppCompatActivity() {

    companion object {
        val ZIP_CODE = "zipCode"
        val DEFAULT_ZIP = 94043L
    }

    private var zipCode: Long by DelegatesExtensions.preference(this, ZIP_CODE, DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        cityCode.setText(zipCode.toString())

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) { android.R.id.home -> {
        onBackPressed()
        true
    }
        else -> false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        zipCode = cityCode.text.toString().toLong()
    }

}