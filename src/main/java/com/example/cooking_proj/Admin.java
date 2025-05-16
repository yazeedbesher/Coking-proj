package com.example.cooking_proj;

public class Admin {
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private Boolean logState=false;

    public Admin()
    {

    }

    public Admin(String s1,String s2,String s3)
    {
        this.name=s3;
        this.username=s1;
        this.password=s2;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    @Override
    public String toString()
    {
        return name;
    }
    public Boolean getLogState() {
        return logState;
    }
    public void setLogState(Boolean logStat) {
        this.logState = logStat;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}