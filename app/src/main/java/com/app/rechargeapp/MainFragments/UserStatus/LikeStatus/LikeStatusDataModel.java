package com.app.rechargeapp.MainFragments.UserStatus.LikeStatus;

public class LikeStatusDataModel {
    /*
            "id": 4,
            "user_id": 13,
            "page": "page2",
            "like_amount": 4500,
            "like_gained": 0,
            "date": "2021-06-02",
            "status": "pending",
            "created_at": "2021-06-02T08:49:41.000000Z",
            "updated_at": "2021-06-02T08:49:41.000000Z"
     */

    private int id;
    private int user_id;
    private String page;
    private long like_amount;
    private long like_gained;
    private String status;

    public LikeStatusDataModel(int id, int user_id, String page, long like_amount, long like_gained, String status) {
        this.id = id;
        this.user_id = user_id;
        this.page = page;
        this.like_amount = like_amount;
        this.like_gained = like_gained;
        this.status = status;
    }

    public LikeStatusDataModel() {

    }

    @Override
    public String toString() {
        return  "Page Name : " + page + '\n' +
                "Like Amount : " + like_amount  + '\n'+
                "Like Gained : " + like_gained + '\n' +
                "Boost Status : " + status;
    }


//    Original toString
    /*
        @Override
    public String toString() {
        return "LikeStatusDataModel{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", page='" + page + '\'' +
                ", like_amount=" + like_amount +
                ", like_gained=" + like_gained +
                ", status='" + status + '\'' +
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public long getLike_amount() {
        return like_amount;
    }

    public void setLike_amount(long like_amount) {
        this.like_amount = like_amount;
    }

    public long getLike_gained() {
        return like_gained;
    }

    public void setLike_gained(long like_gained) {
        this.like_gained = like_gained;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
