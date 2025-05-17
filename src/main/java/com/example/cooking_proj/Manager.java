package com.example.cooking_proj;

public class Manager extends Person {
    private String name;
    private int ID;// for login
    private String Address;
    private String phoneNumber;

    public Manager(String name, int ID, String Address, String phoneNumber) {
        super(ID,name);
        this.name = name;
        this.ID = ID;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String getPassword() {
        return Address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public void setPassword(String password)
    {
        this.Address = password;
    }
    @Override
    public String toString()
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void assign_task(Create_Custome_Meal_2 task, Chef name){
          name.add_task(task);
          System.out.println(task);
    }

}
