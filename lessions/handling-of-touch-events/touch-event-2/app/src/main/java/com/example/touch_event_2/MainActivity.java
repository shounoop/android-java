package com.example.touch_event_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12;
    private ImageView imageView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initView();
        this.initValue();
        this.catchEvents();
    }

    private void initValue() {
        this.gestureDetector = new GestureDetector(this, this);
    }

    private void catchEvents() {
        this.imageView.setOnTouchListener(this);
        this.gestureDetector.setOnDoubleTapListener(this);
    }

    private void initView() {
        this.textView1 = findViewById(R.id.txt1);
        this.textView2 = findViewById(R.id.txt2);
        this.textView3 = findViewById(R.id.txt3);
        this.textView4 = findViewById(R.id.txt4);
        this.textView5 = findViewById(R.id.txt5);
        this.textView6 = findViewById(R.id.txt6);
        this.textView7 = findViewById(R.id.txt7);
        this.textView8 = findViewById(R.id.txt8);
        this.textView9 = findViewById(R.id.txt9);
        this.textView10 = findViewById(R.id.txt10);
        this.textView11 = findViewById(R.id.txt11);
        this.textView12 = findViewById(R.id.txt12);
        this.imageView = findViewById(R.id.image);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        this.textView1.setText("Down touch");
        this.textView2.setText("X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {
        this.textView3.setText("Show press");
        this.textView4.setText("X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        this.textView5.setText("Single Tap Up");
        this.textView6.setText("X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
        return true;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        this.textView7.setText("Scroll");
        this.textView8.setText("X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        this.textView9.setText("Fling");
        this.textView10.setText("X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        this.textView11.setText("Double Tap");
        this.textView12.setText("X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }
}