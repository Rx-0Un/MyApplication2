package cn.njit.myapplication.view;

import cn.njit.myapplication.Bean.ParkingSpaceResult;

public interface ParkingSpaceView {
    void showProgress();

    void hideProgress();

    void loadRecyclerView(ParkingSpaceResult parkingSpaceResult);
}
