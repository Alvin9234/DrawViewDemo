package com.alvin.DrawViewDemo.draw;

import android.graphics.*;

/**
 * Created by Alvin on 2015/5/14.
 */
public class GraphicBase {

    //是否被选中
    public boolean Selected = false;

    //热区
    public RectF HotRect = null;
    //绘制区域f
    public RectF PaintRect = null;

    public Paint paint;

    public GraphicBase(RectF r1, RectF r2) {
        this.HotRect = r1;
        this.PaintRect = r2;
        // 显示区的边框画笔属性
        this.paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
    }

    //绘制元件函数
    public final void Draw(Canvas canvas,float x,float y) {
        Selected = isContains(x,y);
        if (Selected) this.DrawSelected(canvas);
        else {
            this.DrawNormal(canvas);
        }
        DrawDisplay(canvas);
    }

    /**
     *  绘制显示区
     * @param canvas
     */
    public void DrawDisplay(Canvas canvas){

    }
    //绘制选中状态
    public void DrawSelected(Canvas canvas) {
    }

    //绘制普通状态
    public void DrawNormal(Canvas canvas) {
    }

    public boolean isContains(float x,float y){
        return false;
    }
}
