package com.ldfeng.shadow.componet;

import android.support.v4.graphics.ColorUtils;

/**
 * Created by ldf on 17/6/6.
 * 定义渲染控件的属性
 */

public class ShadowAttr {
    /**
     * 以何种方式添加阴影:<br/>
     * {@link com.ldfeng.shadow.SuperShadow#DRAW} <br/>
     * {@link com.ldfeng.shadow.SuperShadow#WRAP} <br/>
     */
    private String impl;

    /**
     * 阴影的基本颜色，即最深的颜色, {@link #setBaseShadowColor(int)} 方法会自动计算出
     * 绘制阴影时需要的 {@link #colors}
     */
    private int baseShadowColor;

    /**
     * 仅对 {@link com.ldfeng.shadow.SuperShadow#DRAW} 形式的方设置阴影时需要的属性
     */
    private int background;

    /**
     * 绘制阴影时需要的一个颜色由深到浅且长度为3的数组
     */
    private int[] colors;

    private float corner;

    /**
     * 阴影大小
     */
    private float shadowSize;

    /**
     * 设置阴影的方向，具体查看 {@link ShadowAttr}
     */
    private int direction;

    public String getImpl() {
        return impl;
    }

    public void setImpl(String impl) {
        this.impl = impl;
    }

    public void setBaseShadowColor(int baseShadowColor) {
        this.baseShadowColor = baseShadowColor;
        if (colors == null) {
            colors = new int[3];
            colors[0] = ColorUtils.setAlphaComponent(baseShadowColor, 255);
            colors[1] = ColorUtils.setAlphaComponent(baseShadowColor, 191);
            colors[2] = ColorUtils.setAlphaComponent(baseShadowColor, 0);
        }
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        if (colors != null)
            this.colors = colors;
    }

    public float getCorner() {
        return corner;
    }

    public void setCorner(float corner) {
        this.corner = corner;
    }

    public float getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(float shadowSize) {
        this.shadowSize = shadowSize;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(@ShadowDirection int direction) {
        this.direction = direction;
    }

    public boolean containsLeft() {
        return direction == ShadowDirection.ALL ||
                direction == ShadowDirection.LEFT ||
                direction == ShadowDirection.LEFT_TOP ||
                direction == ShadowDirection.BOTTOM_LEFT ||
                direction == ShadowDirection.BOTTOM_LEFT_TOP ||
                direction == ShadowDirection.RIGHT_BOTTOM_LEFT ||
                direction == ShadowDirection.LEFT_TOP_RIGHT;

    }

    public boolean containsTop() {
        return direction == ShadowDirection.ALL ||
                direction == ShadowDirection.TOP ||
                direction == ShadowDirection.LEFT_TOP ||
                direction == ShadowDirection.TOP_RIGHT ||
                direction == ShadowDirection.LEFT_TOP_RIGHT ||
                direction == ShadowDirection.BOTTOM_LEFT_TOP ||
                direction == ShadowDirection.TOP_RIGHT_BOTTOM;
    }

    public boolean containsRight() {
        return direction == ShadowDirection.ALL ||
                direction == ShadowDirection.RIGHT ||
                direction == ShadowDirection.TOP_RIGHT ||
                direction == ShadowDirection.RIGHT_BOTTOM ||
                direction == ShadowDirection.TOP_RIGHT_BOTTOM ||
                direction == ShadowDirection.LEFT_TOP_RIGHT ||
                direction == ShadowDirection.RIGHT_BOTTOM_LEFT;
    }

    public boolean containsBottom() {
        return direction == ShadowDirection.ALL ||
                direction == ShadowDirection.BOTTOM ||
                direction == ShadowDirection.BOTTOM_LEFT ||
                direction == ShadowDirection.RIGHT_BOTTOM ||
                direction == ShadowDirection.RIGHT_BOTTOM_LEFT ||
                direction == ShadowDirection.TOP_RIGHT_BOTTOM ||
                direction == ShadowDirection.BOTTOM_LEFT_TOP;
    }
}
