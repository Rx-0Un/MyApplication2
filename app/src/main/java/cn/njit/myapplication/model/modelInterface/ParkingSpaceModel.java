package cn.njit.myapplication.model.modelInterface;

import cn.njit.myapplication.listener.OnParkingSpaceFinishedListener;

public interface ParkingSpaceModel {
    void selectNotOccupy(OnParkingSpaceFinishedListener listener);

    void selectParkingSpaceByUserId(String userId, OnParkingSpaceFinishedListener listener);
}
