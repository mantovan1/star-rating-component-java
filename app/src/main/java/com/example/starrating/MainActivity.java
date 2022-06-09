package com.example.starrating;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    ImageView ib[] = new ImageView[5];

    TextView tvNota;

    int nota = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        ll = (LinearLayout) findViewById(R.id.linearLayout);

        tvNota = (TextView) findViewById(R.id.tvNota);

        for(int i = 0; i < 5; i++) {

            ib[i] = new ImageView(this);
            //ib[i].setId(Integer.parseInt("@+id/ib" + i));
            ib[i].setImageResource(R.drawable.star);

            ib[i].setLayoutParams(new LinearLayout.LayoutParams(120, 120));

            ib[i].setPadding(5, 5, 0, 0);

            int finalI = i+1;

            ib[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nota = finalI;

                    tvNota.setText("nota: " + nota);

                    renderStars();

                }
            });

            ll.addView(ib[i]);

        }

    }

    public void renderStars() {

        for(int i = 0; i < 5; i++) {

            if (nota < i+1) {
                ib[i].setImageResource(R.drawable.star);
            } else {
                ib[i].setImageResource(R.drawable.full_star);
            }

        }
    }
}