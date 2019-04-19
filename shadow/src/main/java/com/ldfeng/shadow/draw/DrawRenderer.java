package com.ldfeng.shadow.draw;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.ldfeng.shadow.componet.IShadowRenderer;
import com.ldfeng.shadow.componet.ShadowAttr;

/**
 * Created by ldf on 17/6/6.
 * email : 2286767746@qq.com
 * https://github.com/MagicMashRoom
 */

public class DrawRenderer implements IShadowRenderer{

    private ShadowAttr attr;

    private View view;

    private Drawable orignalDrawable, shadowDrawable;

    public DrawRenderer(ShadowAttr attr) {
        this.attr = attr;
    }

    @Override
    public void makeShadow(View view) {
        this.view = view;
        //得到初始化的背景图
        orignalDrawable = view.getBackground();
        //创建新的背景图
        shadowDrawable = new RoundShadowDrawable(view, attr.getColors(),
                attr.getCorner(), attr.getShadowSize());
        view.setBackgroundDrawable(shadowDrawable);
    }

    @Override
    public void removeShadow() {
        if (view != null && view.getBackground() instanceof RoundShadowDrawable)
            view.setBackgroundDrawable(orignalDrawable);
    }

    @Override
    public void hideShadow() {
        if (view != null && view.getBackground() instanceof RoundShadowDrawable)
            view.setBackgroundDrawable(orignalDrawable);
    }

    @Override
    public void showShadow() {
        if (view  == null || shadowDrawable == null) return ;
        view.setBackgroundDrawable(shadowDrawable);
    }
}
