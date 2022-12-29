package com.app.rechargeapp.MainFragments.PaymentHistory;

public class DataModel {

    // Data Style
    /*
        "id": 1,
        "user_id": 13,
        "payment_date": "2021-05-29",
        "paid_amount": 20,
        "created_at": "2021-05-29T09:00:06.000000Z",
        "updated_at": "2021-05-29T09:00:06.000000Z"
     */

    private String payment_date;
    private String paid_amount;

    public DataModel(String payment_date, String paid_amount) {
        this.payment_date = payment_date;
        this.paid_amount = paid_amount;
    }

    public DataModel() {

    }

    @Override
    public String toString() {
        return "Payment Date : " + payment_date + '\n' +
                "Paid Amount : " + paid_amount;
    }


    //Original toString
    /*
        @Override
    public String toString() {
        return "DataModel{" +
                "payment_date='" + payment_date + '\'' +
                ", paid_amount='" + paid_amount + '\'' +
                '}';
    }

     */

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount;
    }
}
