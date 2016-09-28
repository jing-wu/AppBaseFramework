package cn.toocrazy.app.commonlib.utils;

import android.app.Activity;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * activity堆栈式管理
 */
public class AppManager {

    private static final Stack<Activity> activityStack = new Stack<>();
    private static volatile AppManager instance;

    private AppManager() {
    }

    /**
     * 单一实例，double check
     */
    public static AppManager getAppManager() {
        if (null == instance) {
            synchronized (AppManager.class) {
                if (null == instance) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /**
     * 获取指定的Activity
     */
    public static Activity getActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                return activity;
            }
        }
        return null;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        try {
            return activityStack.lastElement();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        finishActivity(currentActivity());
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = activityStack.size() - 1; i >= 0; i--) {
            if (null != activityStack.get(i)) {
                finishActivity(activityStack.get(i));
            }
        }
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            System.gc();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断栈内是否存在某个activity
     *
     * @param className activity的className
     * @return 存在与否
     */
    public boolean checkActivityIsInStack(String className) {
        for (Activity activity : activityStack) {
            if (activity.getClass().getName().equals(className)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前栈内是否只存在一个元素
     *
     * @return 结果
     */
    public boolean checkStackIsOnlyOneElement() {
        return activityStack.size() == 1;
    }

    /**
     * 判断是否需要启动主页
     *
     * @return 结果
     */
    public boolean needStartMainActivity(String className) {
        //当前不是MainActivity，MainActivity不在栈中，当前栈只有一个元素
        return null == currentActivity() || !currentActivity().getClass().getName().equals(className) && !checkActivityIsInStack(className) && checkStackIsOnlyOneElement();
    }

    /**
     * 获取当前栈内页面数量
     *
     * @return 数量
     */
    public int getActivitySize() {
        return activityStack.size();
    }
}