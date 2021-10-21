package com.example.alertdialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var showButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showButton = findViewById(R.id.showBtn)
        showButton.setOnClickListener {
            alert()
        }
    }

    fun alert() {
        var at= AlertDialog.Builder(this)
        at.setTitle("Hello")
        val input = EditText(this)

        input.setHint("Enter your name")
        input.inputType = InputType.TYPE_CLASS_TEXT

        at.setView(input)
        at.setPositiveButton("Go", DialogInterface.OnClickListener { dialogInterface, i ->

            var intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("Text",input.text.toString())
            startActivity(intent)

        })
        at.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        at.show()
    }
}