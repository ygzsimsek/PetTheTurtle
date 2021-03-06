package com.fortinbras.iloveturtles;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Animation blink,bounce,fadein,fadeout,flip,move,rotate,seq,sdown,sup,together,zoomin,zoomout;
    TextView txtHead, txtScore, txtPet;
    ImageButton btnTurtle;
    MediaPlayer mp1,mp2,mp3,mp4,mp5;
    Button btnAbout;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHead = (TextView)findViewById(R.id.txt_head);
        txtScore = (TextView)findViewById(R.id.txt_score);
        txtPet = (TextView)findViewById(R.id.txtpet);
        blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        bounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        flip = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.flip);
        move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        seq = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequential);
        sdown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        sup = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        together = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);
        zoomin = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        zoomout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        btnTurtle = (ImageButton)findViewById(R.id.btn_turtle);
        btnAbout = (Button)findViewById(R.id.btnAbout);
        mp1 = MediaPlayer.create(this, R.raw.turtle1);
        mp2 = MediaPlayer.create(this, R.raw.turtle2);
        mp3 = MediaPlayer.create(this, R.raw.turtle3);
        mp4 = MediaPlayer.create(this, R.raw.turtle4);
        mp5 = MediaPlayer.create(this, R.raw.turtle5);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about);
            }
        });
        btnTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score ++;
                txtScore.setText(String.valueOf(score));
                playRandomAnimation();
                playRandomSound();
            }
        });

        txtPet.startAnimation(blink);
    }

    private void playRandomSound() {
        Random randomSnd = new Random();
        int snd = randomSnd.nextInt(5);
        switch (snd){
            case 1:
                mp1.start();
                 break;
            case 2:
                mp2.start();
                break;
            case 3:
                mp3.start();
                break;
            case 4:
                mp4.start();
                break;
            case 5:
                mp5.start();
                break;
        };
    }

    private void playRandomAnimation() {
        Random randomAnim = new Random();
        int anim = randomAnim.nextInt(5);
        switch (anim){
            case 1:
            btnTurtle.startAnimation(blink);
                break;
            case 2:
            btnTurtle.startAnimation(seq);
                break;
            case 3:
            btnTurtle.startAnimation(bounce);
                break;
            case 4:
            btnTurtle.startAnimation(together);
                break;
            case 5:
            btnTurtle.startAnimation(rotate);
                break;
        }

    }


}