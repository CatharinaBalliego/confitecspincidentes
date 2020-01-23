package br.com.confitecsp.java.web.model;

import javax.faces.bean.ManagedBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

@ManagedBean
public class User {
    private String userName;
    private InetAddress ip;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String computerName(){
        setUserName(System.getProperty("user.name"));
        return  userName;

    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public InetAddress hstName() throws UnknownHostException {
        setIp(InetAddress.getLocalHost());
        return ip;
    }
}