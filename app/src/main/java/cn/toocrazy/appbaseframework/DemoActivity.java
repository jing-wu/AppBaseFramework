package cn.toocrazy.appbaseframework;

import android.os.Bundle;

/**
 * Created by jwu on 2016/9/28.
 */

public class DemoActivity extends AppBaseActivity {

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        titleBar.setTitle("我是标题");
        setContentLayout(R.layout.demo_activity);
    }

    @Override
    protected void loadData() {

    }
}
