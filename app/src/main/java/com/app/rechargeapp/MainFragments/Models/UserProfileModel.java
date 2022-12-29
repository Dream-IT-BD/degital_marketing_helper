package com.app.rechargeapp.MainFragments.Models;

public class UserProfileModel {

    private String name;
    private String email;
    private String totalBill;
    private String paidAmount;

    public UserProfileModel(String name, String email, String totalBill, String paidAmount) {
        this.name = name;
        this.email = email;
        this.totalBill = totalBill;
        this.paidAmount = paidAmount;
    }

    public UserProfileModel() {

    }

    @Override
    public String toString() {
        return "Username : " + name + '\n' +
                "Email : " + email + '\n' +
                "Total Bill : " + totalBill + '\n' +
                "Paid Amount : " + paidAmount;
    }


    // Original To String
    /*
        @Override
    public String toString() {
        return "UserProfileModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", totalBill='" + totalBill + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                '}';
    }
     */



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }
}
