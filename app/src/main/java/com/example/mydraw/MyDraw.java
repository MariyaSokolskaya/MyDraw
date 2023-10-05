package com.example.mydraw;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyDraw extends View {

    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = canvas.getWidth();
        int h = canvas.getHeight();
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0,0, w, h, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(w/2, h/2, 100, paint);
        canvas.drawText(w + " ", 20,20,paint);
        canvas.drawRect(10, 10, 300, 300, paint);
    }
}
