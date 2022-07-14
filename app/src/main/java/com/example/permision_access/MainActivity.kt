package com.example.permision_access

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {


    val arraypr = arrayOf(Manifest.permission.CALL_PHONE,Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var permision=findViewById<Button>(R.id.permision)
        permision.setOnClickListener {

            checkpermision()

        }
    }

    fun checkpermision() {
        var pr = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        var pr1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (pr != PackageManager.PERMISSION_GRANTED&&pr1 != PackageManager.PERMISSION_GRANTED) {
            requsetPermission()
        } else {
            Toast.makeText(this, "Alredy Allow", Toast.LENGTH_SHORT).show()
        }

    }

    fun requsetPermission() {


        ActivityCompat.requestPermissions(this, arraypr, 1)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults != null && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this,
                    "Permission Alowes", Toast.LENGTH_SHORT
                ).show()


            }
            else
            {
                Toast.makeText(this, "DENY", Toast.LENGTH_SHORT).show()
            }
        } else {

        }

    }
}