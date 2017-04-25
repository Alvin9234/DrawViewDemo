package com.alvin.DrawViewDemo.draw;

import android.graphics.*;
import android.graphics.Paint.Style;
import android.util.Log;

/**
 * Created by Alvin on 2015/5/14.
 */
public class BaseRectangle extends GraphicBase {

    public BaseRectangle(RectF r1, RectF r2) {
        super(r1, r2);
    }

    //绘制选中状态
    @Override
    public void DrawSelected(Canvas canvas) {
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawRect(HotRect,paint);
    }

    //绘制普通状态
    @Override
    public void DrawNormal(Canvas canvas) {
        paint.setStyle(Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        canvas.drawRect(HotRect, paint);
    }

    /**
     *  绘制显示区
     * @param canvas
     */
    @Override
    public void DrawDisplay(Canvas canvas) {
        canvas.drawRect(HotRect,paint);
    }
    /**
     * 判断点击的坐标是否在图形内
     */
    @Override
    public boolean isContains(float x, float y) {
        return HotRect.contains(x,y);
    }
}
