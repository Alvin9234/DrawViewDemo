package com.alvin.DrawViewDemo.draw;

import android.graphics.*;

/**
 * Created by Alvin on 2015/5/14.
 */
public class BaseTriangle extends GraphicBase{
    private Path path;
    private PointF pointF1;
    private PointF pointF2;
    private PointF pointF3;
    public BaseTriangle(RectF r1, RectF r2) {
        super(r1, r2);
        path = new Path();
        pointF1 = new PointF();
        pointF2 = new PointF();
        pointF3 = new PointF();
        initPath();
    }

    private void initPath() {
        float top = HotRect.top;
        float left = HotRect.left;
        float width = HotRect.width();
        float height = HotRect.height();
        pointF1.set(left,top+height);
        pointF2.set(left+width/2,top);
        pointF3.set(left+width,top+height);
        path.moveTo(pointF1.x, pointF1.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.lineTo(pointF3.x, pointF3.y);
        path.lineTo(pointF1.x,pointF1.y);
        path.close();
    }

    //绘制选中状态
    @Override
    public void DrawSelected(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path,paint);
    }

    //绘制普通状态
    @Override
    public void DrawNormal(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
    }

    /**
     *  绘制显示区
     * @param canvas
     */
    @Override
    public void DrawDisplay(Canvas canvas) {
        canvas.drawPath(path,paint);
    }
    /**
     * 判断点击的坐标是否在图形内
     */
    @Override
    public boolean isContains(float x, float y) {
        return HotRect.contains(x,y);
    }
}
