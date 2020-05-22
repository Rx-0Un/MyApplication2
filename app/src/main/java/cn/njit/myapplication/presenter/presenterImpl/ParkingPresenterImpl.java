package cn.njit.myapplication.presenter.presenterImpl;

import cn.njit.myapplication.Bean.ParkingSpaceResult;
import cn.njit.myapplication.listener.OnParkingSpaceFinishedListener;
import cn.njit.myapplication.model.modelImpl.ParkingSpaceModelImpl;
import cn.njit.myapplication.model.modelInterface.ParkingSpaceModel;
import cn.njit.myapplication.presenter.presenterInterface.ParkingSpacePresenter;
import cn.njit.myapplication.view.ParkingSpaceView;

public class ParkingPresenterImpl implements ParkingSpacePresenter, OnParkingSpaceFinishedListener {
    ParkingSpaceModel parkingSpaceModel;
    ParkingSpaceView parkingSpaceView;

    public ParkingPresenterImpl(ParkingSpaceView parkingSpaceView) {
        this.parkingSpaceView = parkingSpaceView;
        this.parkingSpaceModel = new ParkingSpaceModelImpl();
    }

    @Override
    public void onLoadParkingSpaceSuccess(ParkingSpaceResult parkingSpaceResult) {
parkingSpaceView.loadRecyclerView(parkingSpaceResult);
    }

    @Override
    public void selectNotOccupy() {
        parkingSpaceModel.selectNotOccupy(this);
    }

    @Override
    public void selectParkingSpaceByUserId(String userId) {

    }
}
