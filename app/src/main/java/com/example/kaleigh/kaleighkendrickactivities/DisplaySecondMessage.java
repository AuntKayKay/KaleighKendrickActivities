package com.example.kaleigh.kaleighkendrickactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplaySecondMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_second_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //Gets the intent from the DisplayMessageActivity class.
        Intent intent = getIntent();
        //Gets message from the DisplayMessageActivity class.
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        //Gets message2 from the DisplayMessageActivity class.
        String message2 = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE2);
        TextView textView2 = new TextView(this);
        textView2.setTextSize(40);
        textView2.setText(message2);
        //Assigns the messages to the layout.
        LinearLayout layout = (LinearLayout) findViewById(R.id.content);
        layout.addView(textView);
        layout.addView(textView2);
    }

}
