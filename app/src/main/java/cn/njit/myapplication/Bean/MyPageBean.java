package cn.njit.myapplication.Bean;

public class MyPageBean {

    /**
     * myBalance : 100
     * mySpace : 1
     * myCoupon : 0
     * tbUser : {"userId":1,"userName":"tony","userPhone":"17798567311","userAdress":"无","userPwd":"12346","userEmail":"523224616@qq.com","userSex":"男","userRegtime":"2020-05-02T19:56:19.000+0000"}
     */

    private int myBalance;
    private int mySpace;
    private int myCoupon;
    private TbUserBean tbUser;

    public int getMyBalance() {
        return myBalance;
    }

    public void setMyBalance(int myBalance) {
        this.myBalance = myBalance;
    }

    public int getMySpace() {
        return mySpace;
    }

    public void setMySpace(int mySpace) {
        this.mySpace = mySpace;
    }

    public int getMyCoupon() {
        return myCoupon;
    }

    public void setMyCoupon(int myCoupon) {
        this.myCoupon = myCoupon;
    }

    public TbUserBean getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUserBean tbUser) {
        this.tbUser = tbUser;
    }

    public static class TbUserBean {
        /**
         * userId : 1
         * userName : tony
         * userPhone : 17798567311
         * userAdress : 无
         * userPwd : 12346
         * userEmail : 523224616@qq.com
         * userSex : 男
         * userRegtime : 2020-05-02T19:56:19.000+0000
         */

        private int userId;
        private String userName;
        private String userPhone;
        private String userAdress;
        private String userPwd;
        private String userEmail;
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

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
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
