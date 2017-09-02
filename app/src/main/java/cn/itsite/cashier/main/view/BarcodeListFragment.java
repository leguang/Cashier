package cn.itsite.cashier.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.cashier.R;

/**
 * Author：leguang on 2017/9/2 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class BarcodeListFragment extends BaseFragment {
    public static final String TAG = BarcodeListFragment.class.getSimpleName();

    public static BarcodeListFragment newInstance() {
        return new BarcodeListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }


    private void initData() {
    }
}
