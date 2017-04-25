package com.alvin.DrawViewDemo;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.alvin.DrawViewDemo.draw.*;
import com.alvin.DrawViewDemo.util.DensityUtil;

/**
 * Created by Alvin on 2015/5/14.
 */
public class MySurfaceView extends SurfaceView implements Callback{
    private GraphicBase graphicBase;
    private boolean isReady=false;
    public boolean IsDirty=true;
    private float x,y;//用来存点击时的坐标
    private float lastX,lastY;//上一次点的坐标
    private Context context;

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
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
        RectF rectF = new RectF(DensityUtil.dip2px(context,10),DensityUtil.dip2px(context,30),DensityUtil.dip2px(context,100),DensityUtil.dip2px(context,140));
        RectF rectF1 = new RectF(DensityUtil.dip2px(context,10),DensityUtil.dip2px(context,20),DensityUtil.dip2px(context,110),DensityUtil.dip2px(context,160));
        graphicBase = new BaseRectangle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 圆
        rectF = new RectF(DensityUtil.dip2px(context,120),DensityUtil.dip2px(context,30),DensityUtil.dip2px(context,240),DensityUtil.dip2px(context,180));
        rectF1 = new RectF(DensityUtil.dip2px(context,120),DensityUtil.dip2px(context,20),DensityUtil.dip2px(context,260),DensityUtil.dip2px(context,200));
        graphicBase = new BaseCircle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 三角形
        rectF = new RectF(DensityUtil.dip2px(context,10),DensityUtil.dip2px(context,130),DensityUtil.dip2px(context,130),DensityUtil.dip2px(context,240));
        rectF1 = new RectF(DensityUtil.dip2px(context,10),DensityUtil.dip2px(context,120),DensityUtil.dip2px(context,140),DensityUtil.dip2px(context,260));
        graphicBase = new BaseTriangle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 正方形
        rectF = new RectF(DensityUtil.dip2px(context,10),DensityUtil.dip2px(context,250),DensityUtil.dip2px(context,140),DensityUtil.dip2px(context,380));
        rectF1 = new RectF(DensityUtil.dip2px(context,10),DensityUtil.dip2px(context,260),DensityUtil.dip2px(context,150),DensityUtil.dip2px(context,400));
        graphicBase = new BaseRectangle(rectF,rectF1);
        graphicBase.Draw(canvas,x,y);

        // 圆角矩形
        rectF = new RectF(DensityUtil.dip2px(context,150),DensityUtil.dip2px(context,250),DensityUtil.dip2px(context,240),DensityUtil.dip2px(context,400));
        rectF1 = new RectF(DensityUtil.dip2px(context,150),DensityUtil.dip2px(context,260),DensityUtil.dip2px(context,240),DensityUtil.dip2px(context,420));
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
