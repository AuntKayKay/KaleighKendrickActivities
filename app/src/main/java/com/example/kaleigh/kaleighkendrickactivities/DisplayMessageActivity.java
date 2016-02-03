package com.example.kaleigh.kaleighkendrickactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.kaleigh.kaleighkendrickactivities.MESSAGE";
    public final static String EXTRA_MESSAGE2 = "com.example.kaleigh.kaleighkendrickactivities.MESSAGE2";


    /**
     * Called when user clicks the Next Button.
     */
    public void Next(View view) {
        //Captures the intent from the MainActivity class.
        Intent intentOrg = getIntent();
        //Creates new intent for this class (DisplayMessageActivity).
        Intent intent = new Intent(this, DisplaySecondMessage.class);
        EditText editText = (EditText) findViewById(R.id.second_message);
        //Stores the extra_message from the MainActivity.
        String message = intentOrg.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //Stores the content from the editText field.
        String message2 = editText.getText().toString();
        //Stores message and message2.
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        //Sends message and message2 to the next activity (DisplaySecondMessage).
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
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

        //Gets the intent from the MainActivity class.
        Intent intent = getIntent();
        //Gets the extra_message from the MainActivity class and sets it to the view.
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        //Assigns view to the layout.
        LinearLayout layout = (LinearLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

}
