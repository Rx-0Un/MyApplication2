package cn.njit.myapplication.activity.parkingSpace.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.njit.myapplication.Bean.ParkingSpaceResult;
import cn.njit.myapplication.R;

public class ParkingSpaceRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<ParkingSpaceResult.ListBean> list;
    private Context mContext;

    public ParkingSpaceRecyclerViewAdapter(List<ParkingSpaceResult.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(mContext).inflate(R.layout.item_parking_space_all, parent, false);
        RecyclerView.ViewHolder holder = new ParkingSpaceViewHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ParkingSpaceViewHolder parkingSpaceViewHolder = (ParkingSpaceViewHolder) holder;
        ParkingSpaceResult.ListBean listBean = list.get(position);
        parkingSpaceViewHolder.tvLoaction.setText(listBean.getParkingSpaceLocation());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    class ParkingSpaceViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLoaction;
        public ParkingSpaceViewHolder(View itemView) {
            super(itemView);
            tvLoaction = itemView.findViewById(R.id.tv_location);
        }
    }
}
