package cn.toocrazy.appbaseframework;

import android.os.Bundle;
import android.view.View;

import cn.toocrazy.app.commonlib.activity.BaseActivity;
import cn.toocrazy.app.commonlib.utils.AppManager;
import cn.toocrazy.app.commonlib.utils.TranslucentBarUtil;

/**
 * Created by jwu on 2016/9/28.
 */

public abstract class AppBaseActivity extends BaseActivity {

    private int THEME_COLOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        THEME_COLOR = getResources().getColor(R.color.colorPrimary);

        setTranslucentBar(THEME_COLOR);
        setTitleBarColor(THEME_COLOR);

        titleBar.getLeftImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().finishActivity();
            }
        });
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
