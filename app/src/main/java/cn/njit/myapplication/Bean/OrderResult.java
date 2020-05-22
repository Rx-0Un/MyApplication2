package cn.njit.myapplication.Bean;

import java.util.List;

public class OrderResult {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * orderId : 68
         * orderAmount : 0
         * tbUser : {"userId":1,"userName":"tony","userPhone":"17798567311","userAdress":"无","userPwd":"12346","userEmail":null,"userSex":"男","userRegtime":"2020-05-02T19:56:19.000+0000"}
         * orderPayer : tony
         * orderReceiver : tony
         * orderState : 未完成
         * orderPayType : 手机支付
         * orderPurchaseType : 固定车位购买
         */

        private int orderId;
        private int orderAmount;
        private TbUserBean tbUser;
        private String orderPayer;
        private String orderReceiver;
        private String orderState;
        private String orderPayType;
        private String orderPurchaseType;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(int orderAmount) {
            this.orderAmount = orderAmount;
        }

        public TbUserBean getTbUser() {
            return tbUser;
        }

        public void setTbUser(TbUserBean tbUser) {
            this.tbUser = tbUser;
        }

        public String getOrderPayer() {
            return orderPayer;
        }

        public void setOrderPayer(String orderPayer) {
            this.orderPayer = orderPayer;
        }

        public String getOrderReceiver() {
            return orderReceiver;
        }

        public void setOrderReceiver(String orderReceiver) {
            this.orderReceiver = orderReceiver;
        }

        public String getOrderState() {
            return orderState;
        }

        public void setOrderState(String orderState) {
            this.orderState = orderState;
        }

        public String getOrderPayType() {
            return orderPayType;
        }

        public void setOrderPayType(String orderPayType) {
            this.orderPayType = orderPayType;
        }

        public String getOrderPurchaseType() {
            return orderPurchaseType;
        }

        public void setOrderPurchaseType(String orderPurchaseType) {
            this.orderPurchaseType = orderPurchaseType;
        }

        public static class TbUserBean {
            /**
             * userId : 1
             * userName : tony
             * userPhone : 17798567311
             * userAdress : 无
             * userPwd : 12346
             * userEmail : null
             * userSex : 男
             * userRegtime : 2020-05-02T19:56:19.000+0000
             */

            private int userId;
            private String userName;
            private String userPhone;
            private String userAdress;
            private String userPwd;
            private Object userEmail;
            private String userSex;
            private String userRegtime;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserAdress() {
                return userAdress;
            }

            public void setUserAdress(String userAdress) {
                this.userAdress = userAdress;
            }

            public String getUserPwd() {
                return userPwd;
            }

            public void setUserPwd(String userPwd) {
                this.userPwd = userPwd;
            }

            public Object getUserEmail() {
                return userEmail;
            }

            public void setUserEmail(Object userEmail) {
                this.userEmail = userEmail;
            }

            public String getUserSex() {
                return userSex;
            }

            public void setUserSex(String userSex) {
                this.userSex = userSex;
            }

            public String getUserRegtime() {
                return userRegtime;
            }

            public void setUserRegtime(String userRegtime) {
                this.userRegtime = userRegtime;
            }
        }
    }
}
