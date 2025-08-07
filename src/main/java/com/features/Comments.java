package com.features;

import com.user.User;

public class Comments {
    private User commenter;
    private String comment;

    public Comments(User commenter, String comment) {
        this.commenter = commenter;
        this.comment = comment;
    }

    public String toString() {
        return comment + " " + commenter;
    }


}
