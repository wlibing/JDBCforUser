package com.company;

import java.util.Date;

/**
 * Created by ttc on 18-1-23.
 */
public class PersonInof {
    private int pid;
    private String name;
    private String pkey;
    private Date birthday;
    private String email;
    private String power;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "PersonInof{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", pkey='" + pkey + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
