package cn.itsite.cashier.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itsite.abase.log.ALog;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.abase.utils.ToastUtils;
import cn.itsite.cashier.App;
import cn.itsite.cashier.R;

/**
 * Author：leguang on 2017/9/2 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class MainFragment extends BaseFragment {
    public static final String TAG = MainFragment.class.getSimpleName();
    private static final long WAIT_TIME = 2000L;// 再点一次退出程序时间设置
    public static final String PRESS_AGAIN = "再按一次退出";

    @BindView(R.id.topbar_main_frament)
    TextView topbar;
    @BindView(R.id.fl_goods_list_main_frament)
    FrameLayout flGoodsList;
    @BindView(R.id.fl_barcode_list_main_frament)
    FrameLayout flBarcodeList;

    Unbinder unbinder;

    private long TOUCH_TIME = 0;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ALog.e("too" + view.findViewById(R.id.topbar_main_frament));
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_goods_list_main_frament, GoodsListFragment.newInstance());
            loadRootFragment(R.id.fl_barcode_list_main_frament, BarcodeListFragment.newInstance());
        }
        initData();
    }

    private void initData() {
        ALog.e("topbar-->" + topbar);
        ALog.e("topbar-->" + flGoodsList);
        ALog.e("topbar-->" + flBarcodeList);
//        initStateBar(topbar);
    }

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            //退到桌面，而不是退出应用，让用户以为退出应用，尽量保活。
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtils.showToast(App.mContext, PRESS_AGAIN);
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
