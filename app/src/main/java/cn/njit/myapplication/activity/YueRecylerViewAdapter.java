package cn.njit.myapplication.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.njit.myapplication.R;

public class YueRecylerViewAdapter extends RecyclerView.Adapter {
    private final int ITEM_TYPE_ZERO = 0;
    private final int ITEM_TYPE_ONE = 1;
    private final int ITEM_TYPE_TWO = 2;
    private ArrayList<Integer> mData;

    public YueRecylerViewAdapter(ArrayList<Integer> mData) {
        this.mData = mData;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            return;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (ITEM_TYPE_ZERO == viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_yue_banlance_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }
        if (ITEM_TYPE_ONE == viewType) {

        }
        if (ITEM_TYPE_TWO == viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_yue_kefu_item, parent, false);
            v.setOnClickListener(view -> {
                Toast.makeText(v.getContext(), "!!!", Toast.LENGTH_SHORT).show();
            });
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) == 0) {
            return ITEM_TYPE_ZERO;
        }
        if (mData.get(position) == 1) {
            return ITEM_TYPE_ONE;
        }
        if (mData.get(position) == 2) {
            return ITEM_TYPE_TWO;
        }
        return super.getItemViewType(position);
    }

    public void initLinerChart() {

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
