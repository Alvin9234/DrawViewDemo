package com.alvin.DrawViewDemo;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.alvin.DrawViewDemo.draw.*;

/**
 * Created by Alvin on 2015/5/14.
 */
public class MySurfaceView extends SurfaceView implements Callback{
    private GraphicBase graphicBase;
    private boolean isReady=false;
    public boolean IsDirty=true;
    private float x,y;//用来存点击时的坐标
    private float lastX,lastY;//上一次点的坐标

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.getHolder().addCallback(this);
    }
    public void DrawSurface(){
        if (!this.isReady ||!this.IsDirty) return;
        Canvas canvas=this.getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        this.DrawData(canvas);
        this.getHolder().unlockCanvasAndPost(canvas);
    }

    public void DrawData(Canvas canvas){
        // 长方形
        RectF rectF = new RectF(10,30,100,140);
        RectF rectF1 = new RectF(10,20,110,160);
        graphicBase = new BaseRectangle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 圆
        rectF = new RectF(120,30,240,180);
        rectF1 = new RectF(120,20,260,200);
        graphicBase = new BaseCircle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 三角形
        rectF = new RectF(10,130,130,240);
        rectF1 = new RectF(10,120,140,260);
        graphicBase = new BaseTriangle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 正方形
        rectF = new RectF(10,250,140,380);
        rectF1 = new RectF(10,260,150,400);
        graphicBase = new BaseRectangle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 圆角矩形
        rectF = new RectF(150,250,240,400);
        rectF1 = new RectF(150,260,240,420);
        graphicBase = new BaseRoundRect(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                if (lastX == x && lastY==y){
                    break;
                }
                break;
            case MotionEvent.ACTION_UP:
                x=-1;
                y=-1;
                break;
        }
        lastX = x;// 记录坐标
        lastY = y;
        DrawSurface();
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.isReady=true;
        this.IsDirty=true;
        this.DrawSurface();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.IsDirty=true;
        this.DrawSurface();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.isReady=false;
    }
}
