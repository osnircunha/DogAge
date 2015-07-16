package com.wipro.bootcamp.dogage;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ((TextView)findViewById(R.id.textView)).setText(String.format("Human age is %.1f", getIntent().getDoubleExtra("result", 0)));

        switch (getIntent().getIntExtra("index", -1)){
            case 0:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.puppy);
                break;
            case 1:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.xsmall);
                break;
            case 2:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.small);
                break;
            case 3:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.medium);
                break;
            case 4:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.large);
                break;
            case 5:
                ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.xlarge);
                break;
        }
    }
}
