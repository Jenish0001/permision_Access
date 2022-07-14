package com.example.permision_access

import android.content.DialogInterface
import android.location.LocationManager
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var btn1: Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intiblinding()

        btn.setOnClickListener {
//            var check = checkInternet()
//            showdialog(check)

            gpscheck()
        }

        btn1.setOnClickListener {
            var check = checkInternet()
            showdialog(check)

//            gpscheck()
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun checkInternet(): Boolean {

        var connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager.activeNetwork != null && connectivityManager.activeNetworkInfo!!.isConnected) {
            Log.e("TAG", "checkInternet: true")
            return true
        } else {
            Log.e("TAG", "checkInternet: false")
            return false
        }
    }

    fun showdialog(check: Boolean) {

        var alertDialog: AlertDialog = internetDialog()

        if (check == false) {
            alertDialog.show()
        } else {
            alertDialog.dismiss()

        }

    }

    fun internetDialog(): AlertDialog {

        var alertDialog = AlertDialog.Builder(this).setCancelable(false).setTitle("INTERNET Off")
            .setMessage("Please Internet On ")
            .setPositiveButton("Retry", object : DialogInterface.OnClickListener {
                @RequiresApi(Build.VERSION_CODES.M)
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    var check = checkInternet()
                    showdialog(check)

                }
            }).create()
        return alertDialog

    }


    fun gpscheck() {

        var locationManager=getSystemService(LOCATION_SERVICE) as LocationManager
        var gps=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        Log.e("TAG", "gpscheck: $gps")
    }

    fun intiblinding() {

        btn = findViewById<Button>(R.id.btn)
        btn1 = findViewById<Button>(R.id.btn1)

    }

}