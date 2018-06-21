
package com.gapgram.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Posts implements Parcelable {

    @SerializedName("ID")
    private int iD;
    @SerializedName("PostId")
    private String postId;
    @SerializedName("DateCreate")
    private String dateCreate;
    @SerializedName("DateCreateString")
    private String dateCreateString;
    @SerializedName("TimeCreateString")
    private String timeCreateString;
    @SerializedName("DatePost")
    private String datePost;
    @SerializedName("DatePostString")
    private String datePostString;
    @SerializedName("TimePostString")
    private String timePostString;
    @SerializedName("Title")
    private String title;
    @SerializedName("PostDescription")
    private String postDescription;
    @SerializedName("PostSource")
    private String postSource;
    @SerializedName("LikeMe")
    private Object likeMe;
    @SerializedName("LikeMeID")
    private int likeMeID;
    @SerializedName("LikeCount")
    private int likeCount;
    @SerializedName("DislikeMe")
    private Object dislikeMe;
    @SerializedName("DislikeMeID")
    private int dislikeMeID;
    @SerializedName("DislikeCount")
    private int dislikeCount;
    @SerializedName("SeenMe")
    private Object seenMe;
    @SerializedName("SeenMeID")
    private int seenMeID;
    @SerializedName("SeenCount")
    private int seenCount;
    @SerializedName("Bookmark")
    private int bookmark;
    @SerializedName("ExpireDate")
    private String expireDate;
    @SerializedName("ExpireDateString")
    private String expireDateString;
    @SerializedName("UserID")
    private String userID;
    @SerializedName("Status")
    private int status;
    @SerializedName("Description")
    private Object description;

    protected Posts(Parcel in) {
        iD = in.readInt();
        postId = in.readString();
        dateCreate = in.readString();
        dateCreateString = in.readString();
        timeCreateString = in.readString();
        datePost = in.readString();
        datePostString = in.readString();
        timePostString = in.readString();
        title = in.readString();
        postDescription = in.readString();
        postSource = in.readString();
        likeMeID = in.readInt();
        likeCount = in.readInt();
        dislikeMeID = in.readInt();
        dislikeCount = in.readInt();
        seenMeID = in.readInt();
        seenCount = in.readInt();
        bookmark = in.readInt();
        expireDate = in.readString();
        expireDateString = in.readString();
        userID = in.readString();
        status = in.readInt();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateCreateString() {
        return dateCreateString;
    }

    public void setDateCreateString(String dateCreateString) {
        this.dateCreateString = dateCreateString;
    }

    public String getTimeCreateString() {
        return timeCreateString;
    }

    public void setTimeCreateString(String timeCreateString) {
        this.timeCreateString = timeCreateString;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getDatePostString() {
        return datePostString;
    }

    public void setDatePostString(String datePostString) {
        this.datePostString = datePostString;
    }

    public String getTimePostString() {
        return timePostString;
    }

    public void setTimePostString(String timePostString) {
        this.timePostString = timePostString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostSource() {
        return postSource;
    }

    public void setPostSource(String postSource) {
        this.postSource = postSource;
    }

    public Object getLikeMe() {
        return likeMe;
    }

    public void setLikeMe(Object likeMe) {
        this.likeMe = likeMe;
    }

    public int getLikeMeID() {
        return likeMeID;
    }

    public void setLikeMeID(int likeMeID) {
        this.likeMeID = likeMeID;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Object getDislikeMe() {
        return dislikeMe;
    }

    public void setDislikeMe(Object dislikeMe) {
        this.dislikeMe = dislikeMe;
    }

    public int getDislikeMeID() {
        return dislikeMeID;
    }

    public void setDislikeMeID(int dislikeMeID) {
        this.dislikeMeID = dislikeMeID;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Object getSeenMe() {
        return seenMe;
    }

    public void setSeenMe(Object seenMe) {
        this.seenMe = seenMe;
    }

    public int getSeenMeID() {
        return seenMeID;
    }

    public void setSeenMeID(int seenMeID) {
        this.seenMeID = seenMeID;
    }

    public int getSeenCount() {
        return seenCount;
    }

    public void setSeenCount(int seenCount) {
        this.seenCount = seenCount;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireDateString() {
        return expireDateString;
    }

    public void setExpireDateString(String expireDateString) {
        this.expireDateString = expireDateString;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(iD);
        parcel.writeString(postId);
        parcel.writeString(dateCreate);
        parcel.writeString(dateCreateString);
        parcel.writeString(timeCreateString);
        parcel.writeString(datePost);
        parcel.writeString(datePostString);
        parcel.writeString(timePostString);
        parcel.writeString(title);
        parcel.writeString(postDescription);
        parcel.writeString(postSource);
        parcel.writeInt(likeMeID);
        parcel.writeInt(likeCount);
        parcel.writeInt(dislikeMeID);
        parcel.writeInt(dislikeCount);
        parcel.writeInt(seenMeID);
        parcel.writeInt(seenCount);
        parcel.writeInt(bookmark);
        parcel.writeString(expireDate);
        parcel.writeString(expireDateString);
        parcel.writeString(userID);
        parcel.writeInt(status);
    }
}
