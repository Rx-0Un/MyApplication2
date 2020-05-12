package cn.njit.myapplication.Bean;

import java.util.List;

public class CouponResult {


    private List<TbCouponListBean> tbCouponList;

    public List<TbCouponListBean> getTbCouponList() {
        return tbCouponList;
    }

    public void setTbCouponList(List<TbCouponListBean> tbCouponList) {
        this.tbCouponList = tbCouponList;
    }

    public static class TbCouponListBean {
        /**
         * couponId : 2
         * couponAmount : 1
         * couponUsageCount : 1
         * couponLocation : 1
         * couponCount : 1
         * couponReleaseTime : 2020-04-30T12:43:55.000+0000
         * couponStartTime : 2020-04-30T12:43:53.000+0000
         * couponEndTime : 2020-04-30T12:43:56.000+0000
         * couponSituation : 1
         */

        private int couponId;
        private int couponAmount;
        private int couponUsageCount;
        private String couponLocation;
        private int couponCount;
        private String couponReleaseTime;
        private String couponStartTime;
        private String couponEndTime;
        private int couponSituation;

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public int getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(int couponAmount) {
            this.couponAmount = couponAmount;
        }

        public int getCouponUsageCount() {
            return couponUsageCount;
        }

        public void setCouponUsageCount(int couponUsageCount) {
            this.couponUsageCount = couponUsageCount;
        }

        public String getCouponLocation() {
            return couponLocation;
        }

        public void setCouponLocation(String couponLocation) {
            this.couponLocation = couponLocation;
        }

        public int getCouponCount() {
            return couponCount;
        }

        public void setCouponCount(int couponCount) {
            this.couponCount = couponCount;
        }

        public String getCouponReleaseTime() {
            return couponReleaseTime;
        }

        public void setCouponReleaseTime(String couponReleaseTime) {
            this.couponReleaseTime = couponReleaseTime;
        }

        public String getCouponStartTime() {
            return couponStartTime;
        }

        public void setCouponStartTime(String couponStartTime) {
            this.couponStartTime = couponStartTime;
        }

        public String getCouponEndTime() {
            return couponEndTime;
        }

        public void setCouponEndTime(String couponEndTime) {
            this.couponEndTime = couponEndTime;
        }

        public int getCouponSituation() {
            return couponSituation;
        }

        public void setCouponSituation(int couponSituation) {
            this.couponSituation = couponSituation;
        }
    }
}
