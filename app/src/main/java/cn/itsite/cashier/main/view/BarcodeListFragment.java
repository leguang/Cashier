package cn.itsite.cashier.main.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itsite.abase.log.ALog;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.abase.mvp.view.base.BaseRecyclerViewAdapter;
import cn.itsite.abase.mvp.view.base.Decoration;
import cn.itsite.abase.utils.ToastUtils;
import cn.itsite.cashier.App;
import cn.itsite.cashier.R;
import cn.itsite.cashier.common.AudioPlayer;
import cn.itsite.cashier.entity.GoodsBarcodeBean;

/**
 * Author：leguang on 2017/9/2 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class BarcodeListFragment extends BaseFragment {
    public static final String TAG = BarcodeListFragment.class.getSimpleName();
    @BindView(R.id.rv_result_barcode_list_fragment)
    RecyclerView rvResult;
    @BindView(R.id.tv_barcode_barcode_list_fragment)
    TextView tvBarcode;
    @BindView(R.id.rv_keyboard_barcode_list_fragment)
    RecyclerView rvKeyboard;
    Unbinder unbinder;
    private ArrayList<GoodsBarcodeBean> results;
    private List<String> keys;
    private BaseRecyclerViewAdapter<GoodsBarcodeBean, BaseViewHolder> resultAdapter;
    private BaseRecyclerViewAdapter<String, BaseViewHolder> keyBoardAdapter;

    public static BarcodeListFragment newInstance() {
        return new BarcodeListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_barcode_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
    }

    private void initData() {
        results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            results.add(new GoodsBarcodeBean("", "第" + i + "商品", i, i, i));
        }
        keys = Arrays.asList(getResources().getStringArray(R.array.key));

        rvResult.setLayoutManager(new LinearLayoutManager(_mActivity));
        rvResult.addItemDecoration(new Decoration(_mActivity, Decoration.VERTICAL_LIST));
        rvResult.setAdapter(resultAdapter = new BaseRecyclerViewAdapter<GoodsBarcodeBean, BaseViewHolder>
                (R.layout.item_rv_barcode_list, results) {
            @Override
            protected void convert(BaseViewHolder helper, GoodsBarcodeBean item) {
                helper.setText(R.id.tv_name_item_rv_barcode_list, item.name)
                        .setText(R.id.tv_des_item_rv_barcode_list, item.amount + "")
                        .setText(R.id.tv_barcode_item_rv_barcode_list, item.price + "");
            }
        });

        rvKeyboard.setLayoutManager(new GridLayoutManager(_mActivity, 3));
        rvKeyboard.setAdapter(keyBoardAdapter = new BaseRecyclerViewAdapter<String, BaseViewHolder>
                (R.layout.item_rv_keyboard, keys) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.tv_key, item);
                if (helper.getLayoutPosition() == 14) {
                    helper.setBackgroundRes(R.id.tv_key, R.drawable.shape_solid_bg_keyboard)
                            .setTextColor(R.id.tv_key, Color.WHITE);
                }
            }
        });
    }

    private void initListener() {
        tvBarcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                ALog.e(charSequence);
                ALog.e(start);
                ALog.e(before);
                ALog.e(count);

                List<GoodsBarcodeBean> goods = DataSupport.where("amount = ?", charSequence.toString()).find(GoodsBarcodeBean.class);
                resultAdapter.setNewData(goods);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        keyBoardAdapter.setOnItemClickListener((adapter, view, position) -> {
            AudioPlayer.getInstance(_mActivity).play(AudioPlayer.CLICK);

            switch (position) {
                case 12:
                    if (tvBarcode.getText().toString().isEmpty()) {
                        tvBarcode.setText("");
                    } else {
                        tvBarcode.setText(tvBarcode.getText().toString()
                                .substring(0, tvBarcode.getText().toString().length() - 1));
                    }
                    break;
                case 13:
                    tvBarcode.setText("");
                    break;
                case 14:
                    ToastUtils.showToast(App.mContext, "确定");
                    break;
                default:
                    tvBarcode.setText(tvBarcode.getText().toString() + keys.get(position));
                    break;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
