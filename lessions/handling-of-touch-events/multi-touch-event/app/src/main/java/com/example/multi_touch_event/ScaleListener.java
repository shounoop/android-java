package com.example.multi_touch_event;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private float scale;
    private Matrix matrix;
    private ImageView imageView;

    public ScaleListener(float scale, Matrix matrix, ImageView imageView) {
        this.scale = scale;
        this.matrix = matrix;
        this.imageView = imageView;
    }

    @Override
    public boolean onScale(@NonNull ScaleGestureDetector detector) {
        this.scale *= detector.getScaleFactor();
        this.scale = Math.max(0.1f, Math.min(this.scale, 10.0f));
        this.matrix.setScale(this.scale, this.scale);
        this.imageView.setImageMatrix(this.matrix);
        return true;
    }
}
