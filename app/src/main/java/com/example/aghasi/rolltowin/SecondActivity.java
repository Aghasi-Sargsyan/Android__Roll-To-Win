package com.example.aghasi.rolltowin;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static com.example.aghasi.rolltowin.R.*;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    Button button;
    TextView scoreTxtView;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(layout.activity_second);

        imageView = findViewById(id.imageView);
        button = findViewById(id.roll);
        imageView2 = findViewById(id.imageView2);
        scoreTxtView = findViewById(id.score);


        final MediaPlayer rollSound = MediaPlayer.create(this, raw.diceroll);
        final MediaPlayer applauseSound = MediaPlayer.create(this, raw.applause);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollSound.seekTo(0);
                rollSound.start();

                int random = random();
                switchMenu(imageView, random);

                int random2 = random();
                switchMenu(imageView2, random2);

                scoreTxtView.setTextColor(getResources().getColor(color.gray));

                if (random == random2) {
                    applauseSound.seekTo(0);
                    applauseSound.start();
                    scoreTxtView.setTextColor(getResources().getColor(color.green));
                    score++;
                    scoreTxtView.setText("SCORE:    " + score);
                }
            }
        };

        button.setOnClickListener(onClickListener);

    }

    public void switchMenu(ImageView view, int random) {
        switch (random) {
            case 1:
                view.setImageResource(drawable.one);
                break;
            case 2:
                view.setImageResource(drawable.two);
                break;
            case 3:
                view.setImageResource(drawable.three);
                break;
            case 4:
                view.setImageResource(drawable.four);
                break;
            case 5:
                view.setImageResource(drawable.five);
                break;
            case 6:
                view.setImageResource(drawable.six);
                break;
        }
    }


    public int random() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
