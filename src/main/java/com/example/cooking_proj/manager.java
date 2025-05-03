package com.example.cooking_proj;

public class manager {
    private String name;
    private int ID;// for login
    private String password;
    private String phoneNumber;

    public manager(String name, int ID, String password, String phoneNumber) {
        this.name = name;
        this.ID = ID;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String getPassword() {
        return password;
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
        this.password = password;
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
