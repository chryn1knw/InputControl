package tugaspm.inputcontrol


import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_main)

        val calendar: Calendar = Calendar.getInstance()
        var year: Int = calendar.get(Calendar.YEAR)
        var month: Int = calendar.get(Calendar.MONTH)
        var day: Int = calendar.get(Calendar.DAY_OF_MONTH)

        val buttonDatePicker = findViewById<Button>(R.id.buttonDatePicker)
        val editTextDate = findViewById<EditText>(R.id.editTextDate)
        findViewById<Button>(R.id.buttonShowAlert).setOnClickListener {
            showInputAlert()
            buttonDatePicker.setOnClickListener { v: View? ->
                val datePickerDialog = DatePickerDialog(
                    this,
                    { view: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                        year = selectedYear
                        month = selectedMonth
                        day = selectedDay
                        val selectedDate = day.toString() + "-" + (month + 1) + "-" + year
                        editTextDate.setText(selectedDate)
                    }, year, month, day
                )
                datePickerDialog.show()
            }

        }
    }

    private fun showInputAlert() {
        val editText = EditText(this)
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Alert!")
            .setView(editText)
            .setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                val inputText = editText.text.toString()
                Log.d("Input Alert", "Teks yang dimasukkan: $inputText")
            }
            .setNegativeButton("Batal", null)
            .create()

        alertDialog.show()
    }
}

