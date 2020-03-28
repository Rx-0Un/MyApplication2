package cn.njit.kuangjia.fragment;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import cn.njit.kuangjia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends BaseFragment {

    private TextView textView;
    public OtherFragment() {
        // Required empty public constructor
    }

    @Override
    protected View initView() {
        Log.v("View","第四个页面加载");
        textView = new TextView(getActivity());
        textView.setText(R.string.si_blank_fragment);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.v("View","数据加载成功...");
    }
}
