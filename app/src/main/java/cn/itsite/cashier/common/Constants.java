package cn.itsite.cashier.common;


import cn.itsite.abase.common.BaseConstants;
import cn.itsite.cashier.BuildConfig;

/**
 * Created by leguang on 2017/5/6 0006.
 * Email：langmanleguang@qq.com
 */
public class Constants extends BaseConstants {
    public static final String TAG = Constants.class.getSimpleName();

    //不允许new
    private Constants() {
        super();
        throw new Error("Do not need instantiate!");
    }

    //--------------------以下是区分debug版和非debug版的baseurl-----------

    public static String BASE_USER = "";

    static {
        if (BuildConfig.DEBUG) {
            //调试可以改这里的地址。
            BASE_USER = "http://www.aglhz.com:8076/memberSYS-m";           //用户
        } else {
            //这里的是正式版的基础地址，永远不要动。
            BASE_USER = "http://www.aglhz.com:8076/memberSYS-m";           //用户
        }
    }
    //-------------------以上是区分debug版和非debug版的baseurl-----------------
}
