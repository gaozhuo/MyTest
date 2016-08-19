package com.example.stackviewstudy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.StackView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StackView stackView = (StackView) findViewById(R.id.mStackView);

        ColorAdapter colorAdapter = new ColorAdapter(this, mColors);
        stackView.setAdapter(colorAdapter);

        final Button previousButon = (Button) findViewById(R.id.previousButton);
        previousButon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stackView.showPrevious();
            }
        });

        final Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stackView.showNext();
            }
        });
    }

    private int[] mColors = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.RED};

}
