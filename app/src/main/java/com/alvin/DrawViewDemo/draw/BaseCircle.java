package com.alvin.DrawViewDemo.draw;

import android.graphics.*;

/**
 * Created by Alvin on 2015/5/14.
 */
public class BaseCircle extends GraphicBase{
    // 圆心
    private PointF pointF = new PointF();
    // 半径
    private float radius = 0;

    public BaseCircle(RectF r1, RectF r2) {
        super(r1, r2);
        // 确定圆的圆心，半径
        initCircleData();
    }

    private void initCircleData() {
        float width = HotRect.width();
        float height = HotRect.height();
        float temp = width < height ? width : height;
        float left = HotRect.left;
        float top = HotRect.top;
        pointF.set(left+width/2,top+height/2);
        radius = temp / 2;
    }


    //绘制选中状态
    @Override
    public void DrawSelected(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(pointF.x,pointF.y,radius,paint);
    }

    //绘制普通状态
    @Override
    public void DrawNormal(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        canvas.drawCircle(pointF.x, pointF.y, radius, paint);
    }

    /**
     *  绘制显示区
     * @param canvas
     */
    @Override
    public void DrawDisplay(Canvas canvas) {
        canvas.drawCircle(pointF.x,pointF.y,radius,paint);
    }
    /**
     * 判断点击的坐标是否在图形内
     */
    @Override
    public boolean isContains(float x, float y) {
        return HotRect.contains(x,y);
    }
}
