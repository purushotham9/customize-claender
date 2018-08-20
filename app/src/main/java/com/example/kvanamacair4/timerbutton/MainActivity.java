package com.example.kvanamacair4.timerbutton;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dhruv.timerbutton.TimerButton;

import java.time.LocalDate;
import java.util.ArrayList;

import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthChangeListener;
import sun.bob.mcalendarview.vo.DateData;

public class MainActivity extends AppCompatActivity {
    private TimerButton mtimerButton;
    private Button mbtn;
    private MCalendarView mcalendarView;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcalendarView = findViewById(R.id.calendar);
        mtimerButton = findViewById(R.id.timer_button);
        mtimerButton.setDuration(6000L);
        ArrayList<DateData> dates = new ArrayList<>();
        dates.add(new DateData(2018, 8, 26));
        dates.add(new DateData(2018, 9, 21));
        dates.add(new DateData(2018, 9, 22));
        dates.add(new DateData(2018, 9, 23));
        dates.add(new DateData(2018, 9, 24));
        dates.add(new DateData(2018, 9, 25));
        dates.add(new DateData(2018, 9, 26));
        dates.add(new DateData(2018, 9, 27));
        dates.add(new DateData(2018, 9, 28));
        dates.add(new DateData(2018, 10, 1));
        dates.add(new DateData(2018, 8, 22));
        dates.add(new DateData(2018, 8, 26));
        dates.add(new DateData(2018, 10, 29));
        dates.add(new DateData(2018, 8, 4));
        dates.add(new DateData(2018, 9, 9));
        dates.add(new DateData(2018, 9, 5));
        dates.add(new DateData(2018, 8, 15));
        dates.add(new DateData(2018, 9, 13));

        for (i = 0; i < dates.size(); i++) {
            mcalendarView.markDate(dates.get(i).getYear(), dates.get(i).getMonth(), dates.get(i).getDay());//mark multiple dates with this code.
        }
        Log.d("marked dates:-", "" + mcalendarView.getMarkedDates());
        mcalendarView.markDate(
                new DateData(2018, 8, 24).setMarkStyle(new MarkStyle(MarkStyle.DOT, Color.GREEN)
                ));
        mcalendarView.setOnMonthChangeListener(new OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                Toast.makeText(MainActivity.this, String.format("%d-%d", year, month), Toast.LENGTH_SHORT).show();
            }
        });
        mcalendarView.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(View view, DateData date) {
                Toast.makeText(MainActivity.this, String.format("%d-%d-%d", date.getYear(), date.getMonth(), date.getDay()), Toast.LENGTH_SHORT).show();
            }
        });
//        int days = Days.daysBetween(2, endDate).getDays();
//        List<LocalDate> dates = new ArrayList<LocalDate>(days);  // Set initial capacity to `days`.
//        for (int i=0; i < days; i++) {
//            LocalDate d = startDate.withFieldAdded(DurationFieldType.days(), i);
//            dates.add(d);
//        }
    }

}


//  Start the animation
//        timerButton.start();
//
//  Stop the animation
//        timerButton.stop();
//
//  Reset the animation
//        timerButton.reset();


