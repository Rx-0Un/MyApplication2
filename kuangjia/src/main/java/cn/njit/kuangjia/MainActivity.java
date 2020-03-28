package cn.njit.kuangjia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.njit.kuangjia.fragment.BaseFragment;
import cn.njit.kuangjia.fragment.CommonFrameFragment;
import cn.njit.kuangjia.fragment.CustomFragment;
import cn.njit.kuangjia.fragment.OtherFragment;
import cn.njit.kuangjia.fragment.ThirdPartyFragment;

public class MainActivity extends FragmentActivity {
    RadioGroup rg_bottom_tag;
    private List<BaseFragment>  mBaseFragments;
    public Fragment mContent;
    public int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Activity","主页面被创建...");
        initView();
        initFragment();
        setListener();
//        switchFragment();
    }
    /**
     * 初始化视图页面
     */
    private void initView(){
        setContentView(R.layout.activity_main);
        rg_bottom_tag   = (RadioGroup)findViewById(R.id.rg_bottom_tag);
    }
    /**
     * 初始化Fragment
     */
    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mBaseFragments = new ArrayList<BaseFragment>();
        mBaseFragments.add(new CommonFrameFragment());//常用框架
        mBaseFragments.add(new ThirdPartyFragment());//第三方
        mBaseFragments.add(new CustomFragment());//自定义
        mBaseFragments.add(new OtherFragment());//其他

    }
    /**
     * 初始化RadioGroup监听
     */
    private void setListener() {
        rg_bottom_tag.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认主页面
        rg_bottom_tag.check(R.id.rb_common_frame);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_thirdparty:
                    position = 1;
                    break;
                case R.id.rb_custom:
                    position = 2;
                    break;
                case R.id.rb_other:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            Fragment fragment = getFragment();
            switchFragment(mContent, fragment);

        }
    }
    /**
     * 得到Fragment
     * @return
     */
    private BaseFragment getFragment() {
        if(mBaseFragments != null){
            BaseFragment baseFragment = (BaseFragment) mBaseFragments.get(position);
            return baseFragment;
        }
        return null;
    }
    /**
     * 切换Fragment
     */
    /**
     * 切换不同的Fragment
     * @param from
     * @param to
     */
    public void switchFragment(Fragment from, Fragment to) {

        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                // 先判断是否被add过
                if(from != null){
                    transaction.hide(from);
                }
                if(to != null){
                    transaction.add(R.id.fl_content, to).commit();
                }

            } else {
                if(from != null){
                    transaction.hide(from);
                }
                if(to != null){
                    transaction.show(to).commit();
                }
            }
        }
    }
}
