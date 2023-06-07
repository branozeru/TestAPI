package com.example.testapi;

public class Data {

    private String date;
    private String time;

    private String ip;

    public Data(String date, String time, String ip){

        this.time = time;
        this.date = date;
        this.ip = ip;

    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Data{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }


}
