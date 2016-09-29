package cn.toocrazy.app.commonlib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.toocrazy.app.commonlib.R;

/**
 * Created by jwu on 2016/9/28.
 */

public class TitleBar extends FrameLayout {

    private RelativeLayout rl_title_bar_root;
    private ImageButton ibtn_left;
    private ImageButton ibtn_right;
    private TextView tv_title;

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
        View view = View.inflate(context, R.layout._title_bar, new FrameLayout(context));
        rl_title_bar_root = (RelativeLayout) view.findViewById(R.id.rl_title_bar_root);
        ibtn_left = (ImageButton) view.findViewById(R.id.ibtn_left);
        ibtn_right = (ImageButton) view.findViewById(R.id.ibtn_right);
        tv_title = (TextView) view.findViewById(R.id.tv_title);

        addView(view);
    }

    public void setBgColor(int color) {
        rl_title_bar_root.setBackgroundColor(color);
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public void setTitle(int resId) {
        tv_title.setText(resId);
    }

    public ImageButton getLeftImageButton() {
        return ibtn_left;
    }

    public ImageButton getRightImageButton() {
        return ibtn_right;
    }

    public TextView getTitieTextView() {
        return tv_title;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = getChildAt(0);//只有一个子view
        //确保titleBar的高度跟随内容变化，忽略在xml中设置的值(layout_height),300表示最大高度，一般达不到，目的为了设置上限
        measureChild(child, widthMeasureSpec, MeasureSpec.makeMeasureSpec(300, MeasureSpec.AT_MOST));

        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), child.getMeasuredHeight());
    }
}
