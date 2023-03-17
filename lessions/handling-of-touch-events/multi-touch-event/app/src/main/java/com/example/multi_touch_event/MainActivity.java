package com.example.multi_touch_event;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initView();
        this.initValue();
    }

    private void initValue() {
        if (this.scaleGestureDetector == null) {
            this.scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener(this.scale, this.matrix, this.imageView));
        }
    }

    private void initView() {
        this.imageView = findViewById(R.id.image);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.scaleGestureDetector.onTouchEvent(event);
    }
}