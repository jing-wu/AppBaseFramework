package cn.toocrazy.app.commonlib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import cn.toocrazy.app.commonlib.R;

/**
 * Created by jwu on 2016/9/28.
 */

public class TitleBar extends FrameLayout {

    private LinearLayout ll_title_bar_root;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.title_bar, null);
        ll_title_bar_root = (LinearLayout) view.findViewById(R.id.ll_title_bar_root);

        addView(view);
    }

    public void setBgColor(int color) {
        ll_title_bar_root.setBackgroundColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = getChildAt(0);//只有一个子view
        //确保titleBar的高度跟随内容变化，忽略在xml中设置的值(layout_height),300表示最大高度，一般达不到，目的为了设置上限
        measureChild(child, widthMeasureSpec, MeasureSpec.makeMeasureSpec(300, MeasureSpec.AT_MOST));

        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), child.getMeasuredHeight());
    }
}
