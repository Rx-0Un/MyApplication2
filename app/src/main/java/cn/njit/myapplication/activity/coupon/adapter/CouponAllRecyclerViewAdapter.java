package cn.njit.myapplication.activity.coupon.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.njit.myapplication.Bean.CouponResult;
import cn.njit.myapplication.R;
import cn.njit.myapplication.tool.DateUtil;

public class CouponAllRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<CouponResult.TbCouponListBean> list;
    private Context mContext;

    public CouponAllRecyclerViewAdapter(List<CouponResult.TbCouponListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("aaa", "onCreateViewHolder————" + viewType);
        View item = LayoutInflater.from(mContext).inflate(R.layout.item_coupon_all, parent, false);
        RecyclerView.ViewHolder holder = new CouponAllViewHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CouponAllViewHolder couponAllViewHolder = (CouponAllViewHolder) holder;
        CouponResult.TbCouponListBean tbCouponListBean = list.get(position);
        couponAllViewHolder.tvUseTime.setText(
                DateUtil.process(tbCouponListBean.getCouponStartTime())
                        + "到" + DateUtil.process(tbCouponListBean.getCouponEndTime()));
        couponAllViewHolder.tvCouponAmount.setText(String.valueOf(tbCouponListBean.getCouponAmount()));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class CouponAllViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAdd;
        private TextView tvRule;
        private TextView tvUseTime;
        private TextView tvCouponAmount;


        public CouponAllViewHolder(View itemView) {
            super(itemView);
            tvAdd = itemView.findViewById(R.id.tv_add);
            tvRule = itemView.findViewById(R.id.tv_rule);
            tvUseTime = itemView.findViewById(R.id.tv_use_time);
            tvCouponAmount = itemView.findViewById(R.id.tv_coupon_amount);
        }
    }


}
