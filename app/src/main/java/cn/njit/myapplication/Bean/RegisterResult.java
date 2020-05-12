package cn.njit.myapplication.Bean;

public class RegisterResult {

    /**
     * registerCode : 1
     * registerDetail : 用户已经存在
     */

    private int registerCode;
    private String registerDetail;

    public int getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(int registerCode) {
        this.registerCode = registerCode;
    }

    public String getRegisterDetail() {
        return registerDetail;
    }

    public void setRegisterDetail(String registerDetail) {
        this.registerDetail = registerDetail;
    }
}
