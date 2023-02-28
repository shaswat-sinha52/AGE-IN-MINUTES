package com.example.dobcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private var current_date : TextView? =null
    private var current_date_min1 :TextView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 : Button =findViewById(R.id.D)
        current_date =findViewById(R.id.E)
        current_date_min1=findViewById(R.id.G)

        button1.setOnClickListener {
            clicked_button()
        }
    }

    fun clicked_button(){
        val calendar= Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)
        val dpd =DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                _,year,month,day ->Toast.makeText(this,"date dialog box closed",Toast.LENGTH_SHORT)
            .show()
            val selected_date="$day/${month+1}/$year"
            current_date?.text = selected_date

            val sdf =SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val the_date=sdf.parse(selected_date)
            the_date?.let {val sel_date_min=the_date.time / 60000

                val current_date =sdf.parse(sdf.format(System.currentTimeMillis()))
                current_date?.let {  val current_date_min=current_date.time /60000

                    val result=current_date_min - sel_date_min

                    current_date_min1?.text=result.toString()  } }
        }, year,month,day)

        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()



    }
}

