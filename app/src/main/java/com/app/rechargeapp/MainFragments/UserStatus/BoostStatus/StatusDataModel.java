package com.app.rechargeapp.MainFragments.UserStatus.BoostStatus;

public class StatusDataModel {

    /*
    {
    "id": 1,
    "user_id": 13,
    "page_name": "page1",
    "post_link": "qqqqqqqqqqqqqqq",
    "ad_account": "Add acoount 1",
    "boost_amount": 40,
    "boost_run": 25,
    "start_date": "2021-05-28",
    "end_date": "2021-05-31",
    "boost_duration": 4,
    "boost_goal": "Video Views",
    "boost_status": "completed",
    "created_at": "2021-05-28T07:58:42.000000Z",
    "updated_at": "2021-05-29T07:37:15.000000Z"
  }
     */

    private int id;
    private int user_id;
    private String page_name;
    private String post_link;
    private String ad_account;
    private String boost_amount;
    private int boost_run;
    private String start_date;
    private String end_date;
    private String boost_duration;
    private String boost_goal;
    private String boost_status;


    public StatusDataModel(int id, int user_id, String page_name, String post_link, String ad_account, String boost_amount, int boost_run, String start_date, String end_date, String boost_duration, String boost_goal, String boost_status) {
        this.id = id;
        this.user_id = user_id;
        this.page_name = page_name;
        this.post_link = post_link;
        this.ad_account = ad_account;
        this.boost_amount = boost_amount;
        this.boost_run = boost_run;
        this.start_date = start_date;
        this.end_date = end_date;
        this.boost_duration = boost_duration;
        this.boost_goal = boost_goal;
        this.boost_status = boost_status;
    }

    public StatusDataModel() {

    }


    @Override
    public String toString() {
        return  "User id = " + user_id + "\n" +
                "Page Name = " + page_name + "\n" +
                "Boost Amount = " + boost_amount + "\n" +
                "Boost Duration = " + boost_duration + "\n" +
                "Boost Goal = " + boost_goal + "\n" +
                "Boost Status = " + boost_status;
    }


    // Original toString()
    /*
        @Override
    public String toString() {
        return "StatusDataModel{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", page_name='" + page_name + '\'' +
                ", post_link='" + post_link + '\'' +
                ", ad_account='" + ad_account + '\'' +
                ", boost_amount=" + boost_amount +
                ", boost_run=" + boost_run +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", boost_duration=" + boost_duration +
                ", boost_goal='" + boost_goal + '\'' +
                ", boost_status='" + boost_status + '\'' +
                '}';
    }
     */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPage_name() {
        return page_name;
    }

    public String setPage_name(String page_name) {
        this.page_name = page_name;
        return page_name;
    }

    public String getPost_link() {
        return post_link;
    }

    public void setPost_link(String post_link) {
        this.post_link = post_link;
    }

    public String getAd_account() {
        return ad_account;
    }

    public void setAd_account(String ad_account) {
        this.ad_account = ad_account;
    }


    public String getBoost_amount() {
        return boost_amount;
    }

    public String setBoost_amount(String boost_amount) {
        this.boost_amount = boost_amount;
        return boost_amount;
    }

    public int getBoost_run() {
        return boost_run;
    }

    public void setBoost_run(int boost_run) {
        this.boost_run = boost_run;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getBoost_duration() {
        return boost_duration;
    }

    public String setBoost_duration(String boost_duration) {
        this.boost_duration = boost_duration;
        return boost_duration;
    }

    public String getBoost_goal() {
        return boost_goal;
    }

    public void setBoost_goal(String boost_goal) {
        this.boost_goal = boost_goal;
    }

    public String getBoost_status(String boost_status) {
        return this.boost_status;
    }

    public String setBoost_status(String boost_status) {
        this.boost_status = boost_status;
        return boost_status;
    }
}
