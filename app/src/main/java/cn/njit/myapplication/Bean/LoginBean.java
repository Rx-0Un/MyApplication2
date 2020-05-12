package cn.njit.myapplication.Bean;

public class LoginBean {

    /**
     * loginCode : 1
     * loginDetail : 登录成功
     */

    private int loginCode;
    private String loginDetail;

    public int getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(int loginCode) {
        this.loginCode = loginCode;
    }

    public String getLoginDetail() {
        return loginDetail;
    }

    public void setLoginDetail(String loginDetail) {
        this.loginDetail = loginDetail;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "loginCode=" + loginCode +
                ", loginDetail='" + loginDetail + '\'' +
                '}';
    }
}
