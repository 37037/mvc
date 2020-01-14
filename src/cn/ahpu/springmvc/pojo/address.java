package cn.ahpu.springmvc.pojo;

import java.util.Date;

public class address {
    private String address;
    private String user_id;
    private Date added;
    private String receiver;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public address() {
    }

    public address(String address, String user_id, Date added, String receiver, String receiver_phone) {
        this.address = address;
        this.user_id = user_id;
        this.added = added;
        this.receiver = receiver;
        this.receiver_phone = receiver_phone;
    }

    private String receiver_phone;
}
