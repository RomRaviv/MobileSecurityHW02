package com.example.mobilesecurityhw02;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class Activity_Game extends AppCompatActivity {
    public static final String EXTRA_ID = "EXTRA_ID";
    public static final String EXTRA_STATE = "EXTRA_STATE";
    private ImageButton[] arrows;
    int currentLevel = 0;
    private boolean ok = true;
    int[] steps = {1, 1, 1, 2, 2, 2, 3, 3, 3};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_game);
        String id = getIntent().getStringExtra(EXTRA_ID);
        if (id.length() == this.steps.length) {
            int i = 0;
            while (true) {
                int[] iArr = this.steps;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = Integer.valueOf(String.valueOf(id.charAt(i))).intValue() % 4;
                Log.d("pttt", Arrays.toString(iArr));
                i++;
            }
        }

        findViews();
        initViews();
    }

    public void arrowClicked(int direction) {
        if (this.ok && direction != this.steps[this.currentLevel]) {
            this.ok = false;
        }
        int i = this.currentLevel + 1;
        this.currentLevel = i;
        if (i >= this.steps.length) {
            finishGame();
        }
    }

    private void finishGame() {
        String state = getIntent().getStringExtra(EXTRA_STATE);
        if (this.ok) {
            Toast.makeText(this, "Survived in " + state, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You Failed ", Toast.LENGTH_LONG).show();
        }
        finish();
    }

    private void initViews() {
        int i = 0;
        while (true) {
            ImageButton[] imageButtonArr = this.arrows;
            if (i < imageButtonArr.length) {
                final int finalI = i;
                imageButtonArr[i].setOnClickListener(v -> Activity_Game.this.arrowClicked(finalI));
                i++;
            } else {
                return;
            }
        }
    }

    private void findViews() {
        //Left - 0 || Right - 1 || Up - 2 || Down - 3
        this.arrows = new ImageButton[]{(ImageButton) findViewById(R.id.btn_arrow_left), (ImageButton) findViewById(R.id.btn_arrow_right), (ImageButton) findViewById(R.id.btn_arrow_up), (ImageButton) findViewById(R.id.btn_arrow_down)};
    }
}
