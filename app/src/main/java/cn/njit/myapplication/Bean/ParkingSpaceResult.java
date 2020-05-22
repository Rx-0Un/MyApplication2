package cn.njit.myapplication.Bean;

import java.util.List;

public class ParkingSpaceResult {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * parkingSpaceId : 4
         * parkingSpaceLocation : 北10B111
         * parkingSpaceOccupy : null
         * parkingSpaceQuestion : null
         * parkingSpaceReservation : null
         * carId : null
         * expireDate : null
         * tbCar : null
         */

        private int parkingSpaceId;
        private String parkingSpaceLocation;
        private Object parkingSpaceOccupy;
        private Object parkingSpaceQuestion;
        private Object parkingSpaceReservation;
        private Object carId;
        private Object expireDate;
        private Object tbCar;

        public int getParkingSpaceId() {
            return parkingSpaceId;
        }

        public void setParkingSpaceId(int parkingSpaceId) {
            this.parkingSpaceId = parkingSpaceId;
        }

        public String getParkingSpaceLocation() {
            return parkingSpaceLocation;
        }

        public void setParkingSpaceLocation(String parkingSpaceLocation) {
            this.parkingSpaceLocation = parkingSpaceLocation;
        }

        public Object getParkingSpaceOccupy() {
            return parkingSpaceOccupy;
        }

        public void setParkingSpaceOccupy(Object parkingSpaceOccupy) {
            this.parkingSpaceOccupy = parkingSpaceOccupy;
        }

        public Object getParkingSpaceQuestion() {
            return parkingSpaceQuestion;
        }

        public void setParkingSpaceQuestion(Object parkingSpaceQuestion) {
            this.parkingSpaceQuestion = parkingSpaceQuestion;
        }

        public Object getParkingSpaceReservation() {
            return parkingSpaceReservation;
        }

        public void setParkingSpaceReservation(Object parkingSpaceReservation) {
            this.parkingSpaceReservation = parkingSpaceReservation;
        }

        public Object getCarId() {
            return carId;
        }

        public void setCarId(Object carId) {
            this.carId = carId;
        }

        public Object getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(Object expireDate) {
            this.expireDate = expireDate;
        }

        public Object getTbCar() {
            return tbCar;
        }

        public void setTbCar(Object tbCar) {
            this.tbCar = tbCar;
        }
    }
}
