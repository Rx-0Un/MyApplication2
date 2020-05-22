package cn.njit.myapplication.listener;

import cn.njit.myapplication.Bean.ParkingSpaceResult;

public interface OnParkingSpaceFinishedListener {
    void onLoadParkingSpaceSuccess(ParkingSpaceResult parkingSpaceResult);
}
