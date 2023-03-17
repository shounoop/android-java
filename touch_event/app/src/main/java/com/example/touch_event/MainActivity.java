package com.example.touch_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText txt1, txt2, txt3, txt4;
    private ImageView imageView;
    private float xDown = 0, yDown = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initView();
        this.catchEvents();
    }

    private void catchEvents() {
        this.imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        xDown = motionEvent.getX();
                        yDown = motionEvent.getY();
                        txt1.setText("" + xDown);
                        txt2.setText("" + yDown);
                        System.out.println(23);
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        float xMove = motionEvent.getX();
                        float yMove = motionEvent.getY();

                        System.out.println(123);

                        txt3.setText("" + xMove);
                        txt4.setText("" + yMove);

                        float deltaX = xMove - xDown;
                        float deltaY = yMove - yDown;

                        imageView.setX(imageView.getX() + deltaX);
                        imageView.setY(imageView.getY() + deltaY);
                        return true;
                }
                return false;
            }
        });
    }

    private void initView() {
        this.txt1 = findViewById(R.id.txt1);
        this.txt2 = findViewById(R.id.txt2);
        this.txt3 = findViewById(R.id.txt3);
        this.txt4 = findViewById(R.id.txt4);
        this.imageView = findViewById(R.id.img);
    }
}