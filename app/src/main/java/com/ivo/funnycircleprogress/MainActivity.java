package com.ivo.funnycircleprogress;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        final FunnyCircleProgress funny1 = (FunnyCircleProgress) findViewById(R.id.funny1);
        funny1.setArcAngle(180);
        funny1.setDuration(3000);

        final FunnyCircleProgress funny2 = (FunnyCircleProgress) findViewById(R.id.funny2);
        funny2.setStartAngleIncrement(3);
        funny2.setProgressColor(ContextCompat.getColor(this, R.color.md_light_blue_300));

        funny1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funny1.show();
                funny2.show();
            }
        });

        funny2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funny2.hide();
            }
        });
    }
}
