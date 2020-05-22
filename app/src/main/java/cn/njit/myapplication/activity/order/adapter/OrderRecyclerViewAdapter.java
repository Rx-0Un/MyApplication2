package cn.njit.myapplication.activity.order.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.njit.myapplication.Bean.OrderResult;
import cn.njit.myapplication.R;

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<OrderResult.ListBean> list;
    private Context mContext;

    public OrderRecyclerViewAdapter(List<OrderResult.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("aaa", "onCreateViewHolder————" + viewType);
        View item = LayoutInflater.from(mContext).inflate(R.layout.item_order_all, parent, false);
        RecyclerView.ViewHolder holder = new OrderViewHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OrderViewHolder orderViewHolder = (OrderViewHolder) holder;
        OrderResult.ListBean listBean = list.get(position);
        orderViewHolder.tvType.setText(String.valueOf(listBean.getOrderPurchaseType()));
        orderViewHolder.tvTime.setText(String.valueOf(listBean.getOrderPayType()));
        orderViewHolder.tvAdd.setText(String.valueOf(listBean.getOrderAmount()));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAdd;
        private TextView tvType;
        private TextView tvTime;

        public OrderViewHolder(View itemView) {
            super(itemView);
            tvAdd = itemView.findViewById(R.id.tv_add);
            tvType = itemView.findViewById(R.id.tv_type);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }
}
