package com.gapgram;

public class ListItem {

    private String head;
    private int imageIconID;
    private int imagePostID;
    private String descPost;
    private String viewAllComments;



    public ListItem(String head,int imageIconID,int imagePostID,String descPost, String viewAllComments ) {
        this.head = head;
        this.descPost = descPost;
        this.imageIconID=imageIconID;
        this.imagePostID= imagePostID;
        this.viewAllComments = viewAllComments;


    }

    public String getHead() {
        return head;
    }


    public int getImageIconID() { return imageIconID; }
    public int getImagePostID() { return imagePostID; }
    public String getDescPost() {
        return descPost;
    }
    public String getViewAllComments() { return viewAllComments; }

}
