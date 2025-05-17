package com.example.cooking_proj;

public class Admin extends Person{
    private String name;
    private int ID;
    private String Address;
    private String phoneNumber;

    public Admin(int customerID, String customerName, String customerAddress, String customerPhone)
    {
        super(customerID,customerName);
        this.name = customerName;
        this.Address = customerAddress;
        this.phoneNumber = customerPhone;
        this.ID = customerID;

    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPassword()
    {
        return Address;
    }
    public void setPassword(String Address)
    {
        this.Address = Address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString()
    {
        return name;
    }

}