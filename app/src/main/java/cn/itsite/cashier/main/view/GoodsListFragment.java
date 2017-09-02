package cn.itsite.cashier.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;
import cn.itsite.abase.mvp.view.base.Decoration;
import cn.itsite.abase.utils.ToastUtils;
import cn.itsite.cashier.App;
import cn.itsite.cashier.R;
import cn.itsite.cashier.entity.GoodsBean;
import cn.itsite.statemanager.StateLayout;

/**
 * Author：leguang on 2017/9/2 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class GoodsListFragment extends BaseFragment {
    public static final String TAG = GoodsListFragment.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.stateLayout)
    StateLayout stateLayout;
    @BindView(R.id.tv_amount_goods_list_fragment)
    TextView tvAmount;
    @BindView(R.id.tv_sum_goods_list_fragment)
    TextView tvSum;
    @BindView(R.id.tv_pay_goods_list_fragment)
    TextView tvPay;
    Unbinder unbinder;
    private ArrayList<GoodsBean> listGoods;
    private BaseRecyclerViewAdapter<GoodsBean, BaseViewHolder> adapter;

    public static GoodsListFragment newInstance() {
        return new GoodsListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        listGoods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listGoods.add(new GoodsBean("", "第" + i + "商品", i, i, i));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        recyclerView.addItemDecoration(new Decoration(_mActivity, Decoration.VERTICAL_LIST));
        recyclerView.setAdapter(adapter = new BaseRecyclerViewAdapter<GoodsBean, BaseViewHolder>
                (R.layout.item_rv_goods_list, listGoods) {
            @Override
            protected void convert(BaseViewHolder helper, GoodsBean item) {
                helper.setText(R.id.tv_name_item_rv_goods_list, item.name)
                        .setText(R.id.tv_amount_item_rv_goods_list, item.amount + "")
                        .setText(R.id.tv_price_item_rv_goods_list, item.price + "")
                        .setText(R.id.tv_sum_item_rv_goods_list, item.sum + "")
                        .setOnClickListener(R.id.iv_delete_item_rv_goods_list, v ->
                                new AlertDialog.Builder(_mActivity)
                                        .setTitle("提示")
                                        .setMessage("确定要删除吗？")
                                        .setNegativeButton("取消", null)
                                        .setPositiveButton("删除", (dialogInterface, i) ->
                                                adapter.remove(helper.getLayoutPosition()))
                                        .show());
            }
        });

        stateLayout.setEmptyOnClickListener(view -> stateLayout.showContent());

        stateLayout.showEmpty();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_pay_goods_list_fragment)
    public void onViewClicked() {
        ToastUtils.showToast(App.mContext, "结账");
    }
}
