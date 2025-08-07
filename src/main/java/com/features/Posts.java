package com.features;

import com.groupe.Groupe;
import com.user.User;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

public class Posts {
    private Groupe groupe;
    private String content;
    private User author;
    private List<Comment> comments;

    public Posts(Groupe groupe, String content, User author) {
        this.groupe = groupe;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    //Getter
    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }
}
