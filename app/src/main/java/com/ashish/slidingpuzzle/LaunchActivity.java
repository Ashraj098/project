package com.ashish.slidingpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {

    private Button Play;
    private Button Exit;
    private TextView Score;
    private TextView Main_Score;
    private Button Score_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_page);
        final String Myintent=getIntent().getStringExtra("Score");
        Score_Button=findViewById(R.id.Show_Score);
        Play=findViewById(R.id.PlayBtn);
        Score=findViewById(R.id.Score);
        Main_Score=findViewById(R.id.Main_Score);
        Score.setVisibility(View.INVISIBLE);
        Main_Score.setVisibility(View.INVISIBLE);
        Exit=findViewById(R.id.ExitGame);
        ButtonPress();
        new CountDownTimer(1000, 1000) {
            public void onFinish() {
                // When timer is finished
                // Execute your code here
                if(getIntent().getBooleanExtra("show_button", false))
                {
                    Score_Button.setVisibility(View.VISIBLE);
                    Main_Score.setText(Myintent);
                }

            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();

    }

    private void ButtonPress() {
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
                finishAndRemoveTask();
            }
        });
        Score_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score_Button.setVisibility(View.INVISIBLE);
                Score.setVisibility(View.VISIBLE);
                Main_Score.setVisibility(View.VISIBLE);
            }
        });
    }
}
