package cn.itsite.cashier.common;


/**
 * Created by leguang on 2017/5/6 0006.
 * Email：langmanleguang@qq.com
 */

public class Params {
    private static final String TAG = Params.class.getSimpleName();
    public static String token;//测试用

    public static Params getInstance() {
        Params params = new Params();
//        params.token = UserHelper.token;
        return params;
    }

}