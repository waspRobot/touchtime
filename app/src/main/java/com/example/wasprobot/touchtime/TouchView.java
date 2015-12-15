package com.example.wasprobot.touchtime;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TouchView extends View {

    private Paint paint = new Paint();
    List<Path> paths = new ArrayList<>();
    private Path path = new Path();

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(5f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        for (Path p: paths) {
        canvas.drawPath(path, paint);
//        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                path.addCircle(eventX, eventY, event.getPressure() * 100, Path.Direction.CW);
                break;
        }

        invalidate();
        return true;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (paths.isEmpty()) {
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                paths.add(new Path());
//            }
//        } else {
//            for (int i = 0; i < event.getPointerCount(); i++) {
//
//                float eventX = event.getX();
//                float eventY = event.getY();
//
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        // Set a new starting point
//                        paths.get(i).moveTo(eventX, eventY);
//                        return true;
//                    case MotionEvent.ACTION_MOVE:
//                        // Connect the points
//                        paths.get(i).lineTo(eventX, eventY);
//                        break;
//                    default:
//                        return false;
//                }
//            }
//        }
//
//        invalidate();
//        return true;
//    }
}
