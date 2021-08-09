package org.geekforgeeks.setmaxdate

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get instance of calendar
        // mCalendar will be set to current/today's date
        val mCalendar = Calendar.getInstance()

        // Creating a simple calendar dialog. It was 9 Aug 2021 when this program was developed.
        val mDialog = DatePickerDialog(this, { _, mYear, mMonth, mDay ->
            mCalendar[Calendar.YEAR] = mYear
            mCalendar[Calendar.MONTH] = mMonth
            mCalendar[Calendar.DAY_OF_MONTH] = mDay
        }, mCalendar[Calendar.YEAR], mCalendar[Calendar.MONTH], mCalendar[Calendar.DAY_OF_MONTH])

        // Changing mCalendar date from current to some random MIN day 15/08/2021 15 Aug 2021
        // If we want the same current day to be the MIN day, then mCalendar is already set to today and the below code will be unnecessary
        val minDay = 15
        val minMonth = 8
        val minYear = 2021
        mCalendar.set(minYear, minMonth-1, minDay)
        mDialog.datePicker.minDate = mCalendar.timeInMillis

        // Changing mCalendar date from current to some random MAX day 20/08/2021 20 Aug 2021
        val maxDay = 20
        val maxMonth = 8
        val maxYear = 2021
        mCalendar.set(maxYear, maxMonth-1, maxDay)
        mDialog.datePicker.maxDate = mCalendar.timeInMillis

        // Display the calendar dialog
        mDialog.show()

    }
}