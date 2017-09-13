package cn.itsite.cashier;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;

import cn.itsite.abase.BaseApplication;
import cn.itsite.abase.log.ALog;
import cn.itsite.cashier.entity.GoodsBean;

/**
 * Author：leguang on 2017/9/2 0009 14:23
 * Email：langmanleguang@qq.com
 */
public class App extends BaseApplication implements Application.ActivityLifecycleCallbacks {
    public static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        initDate();
    }

    private void initDate() {
//        UserHelper.init();

        ArrayList<GoodsBean> listGoods = new ArrayList<>();
        for (int i = 0; i < 70; i++) {

            ALog.e(i);
            new GoodsBean("", "第" + i + "商品", i, i, i).save();
        }

        ALog.e("DataSupport-->" + DataSupport.find(GoodsBean.class, 1));

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        ALog.e("onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        ALog.e("onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        ALog.e("onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ALog.e("onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        ALog.e("onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        ALog.e("onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ALog.e("onActivityDestroyed");
    }

}
