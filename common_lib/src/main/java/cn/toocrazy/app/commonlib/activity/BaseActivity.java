package cn.toocrazy.app.commonlib.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;

import cn.toocrazy.app.commonlib.R;
import cn.toocrazy.app.commonlib.ui.TitleBar;
import cn.toocrazy.app.commonlib.utils.AppManager;

/**
 * Created by jwu on 2016/9/28.
 */

public abstract class BaseActivity extends Activity {

    protected TitleBar titleBar;
    protected RelativeLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.getAppManager().addActivity(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.base_activity);

        titleBar = (TitleBar) findViewById(R.id.title_bar);
        content = (RelativeLayout) findViewById(R.id.content);

        initVariables();

        initViews(savedInstanceState);

        loadData();
    }

    /**
     * 初始化参数
     */
    protected abstract void initVariables();

    /**
     * 初始化View
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 加载数据
     */
    protected abstract void loadData();
}
