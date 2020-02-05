package tencent.com.gao_xiao_tong_chi.java.houduan;

import java.util.ArrayList;

public class DBFormat {

    private Boolean infodebug;

    private String infomsg;

    private Object inforesult;

    private Boolean infostatus;

    public Boolean getInfodebug() {
        return infodebug;
    }

    public void setInfodebug(Boolean infodebug) {
        this.infodebug = infodebug;
    }

    public String getInfomsg() {
        return infomsg;
    }

    public void setInfomsg(String infomsg) {
        this.infomsg = infomsg;
    }

    public Object getInforesult() {
        return inforesult;
    }

    public void setInforesult(Object inforesult) {
        this.inforesult = inforesult;
    }

    public Boolean getInfostatus() {
        return infostatus;
    }

    public void setInfostatus(Boolean infostatus) {
        this.infostatus = infostatus;
    }

    @Override
    public String toString() {
        return "DBFormat{" +
                "infodebug=" + infodebug +
                ", infomsg='" + infomsg + '\'' +
                ", inforesult=" + inforesult +
                ", infostatus=" + infostatus +
                '}';
    }
}
