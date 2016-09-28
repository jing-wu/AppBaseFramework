package cn.toocrazy.appbaseframework;

import android.graphics.Color;
import android.os.Bundle;

import cn.toocrazy.app.commonlib.activity.BaseActivity;
import cn.toocrazy.app.commonlib.utils.TranslucentBarUtil;

/**
 * Created by jwu on 2016/9/28.
 */

public abstract class AppBaseActivity extends BaseActivity {

    private static final int THEME_COLOR = Color.BLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTranslucentBar(THEME_COLOR);
        setTitleBarColor(THEME_COLOR);
    }

    /**
     * 设置沉浸式状态栏
     */
    private void setTranslucentBar(int color) {
        TranslucentBarUtil.setColor(this, color);
    }

    /**
     * 设置titleBar背景色
     */
    private void setTitleBarColor(int color) {
        titleBar.setBgColor(color);
    }
}
