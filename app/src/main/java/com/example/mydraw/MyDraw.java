package com.example.mydraw;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MyDraw extends View {
    boolean gameField[][];//массив с состоянием "лампочек"
    int r = 80;
    int ro = 50;
    Paint paint;
    boolean isGenerate = false;
    public MyDraw(Context context) {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = canvas.getWidth();
        int h = canvas.getHeight();
        if (!isGenerate){
            //генерация массива состояний "лампочек"
            int n = h / (2 * r + ro); //количество строк
            int m = w / (2 * r + ro); //количество столбцов
            gameField = new boolean[n][m];
            Random random = new Random();
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField[i].length; j++) {
                    gameField[i][j] = random.nextBoolean();
                }
            }
            isGenerate = !isGenerate;
        }
        //рисование игрового поля
        paint.setColor(Color.rgb(128, 128, 0));
        int cx = r + ro; //координаты центра окружностей-лампочек
        int cy = r + ro;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if(gameField[i][j]){
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }else {
                    paint.setStyle(Paint.Style.STROKE);
                }
                canvas.drawCircle(cx, cy, r, paint);
                cx += 2 * r + ro;
            }
            cy += 2 * r + ro;
            cx = r + ro;
        }
    }
}
