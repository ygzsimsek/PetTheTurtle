package com.fortinbras.iloveturtles;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

Button btn_osl, btn_tnx, btn_clog, btn_reddit, btn_ig, btn_telegram, btn_github, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(R.string.app_name);
        //btn
        btn = (Button)findViewById(R.id.button);
        btn_reddit = (Button) findViewById(R.id.btn_reddit);
        btn_ig = (Button) findViewById(R.id.btn_instagram);
        btn_telegram = (Button) findViewById(R.id.btn_telegram);
        btn_github = (Button) findViewById(R.id.btn_github);
        //onclicklistener
        btn.setOnClickListener(this);
        btn_reddit.setOnClickListener(this);
        btn_ig.setOnClickListener(this);
        btn_telegram.setOnClickListener(this);
        btn_github.setOnClickListener(this);

    }


        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            if (item.getItemId() == android.R.id.home) {
                finish();
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.btn_instagram:
                    String ig = "https://www.instagram.com/fortinbrasgood/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(ig));
                    startActivity(i);
                    break;
                case R.id.button:
                String sc = "https://github.com/ygzsimsek/PetTheTurtle";
                Intent c = new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse(sc));
                startActivity(c);
                break;
                case R.id.btn_reddit:
                    String rd = "https://www.reddit.com/user/fortinbrasgod/";
                    Intent r = new Intent(Intent.ACTION_VIEW);
                    r.setData(Uri.parse(rd));
                    startActivity(r);
                    break;
                case R.id.btn_telegram:
                    String tg = "https://t.me/fortinbrasgod/";
                    Intent t = new Intent(Intent.ACTION_VIEW);
                    t.setData(Uri.parse(tg));
                    startActivity(t);
                    break;
                case R.id.btn_github:
                    String gt = "https://github.com/ygzsimsek/";
                    Intent g = new Intent(Intent.ACTION_VIEW);
                    g.setData(Uri.parse(gt));
                    startActivity(g);
                    break;
            }
        }
    }
