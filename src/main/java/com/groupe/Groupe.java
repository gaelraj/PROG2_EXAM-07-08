package com.groupe;

import com.features.Posts;
import com.user.User;
import com.user.UserType;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private String groupeName;
    private List<User> userList;
    private List<Posts> postList;

    public Groupe(String groupeName) {
        this.groupeName = groupeName;
        this.userList = new ArrayList<>();
        this.postList = new ArrayList<>();
    }

    //Getter
    public String getGroupeName() {
        return groupeName;
    }

    public List<User> getUserList() {
        return userList;
    }

    //Setter

    public void setGroupeName(String groupeName) {
        this.groupeName = groupeName;
    }

    public void createPost(Posts post) {
        postList.add(post);
    }

    public void commentPost(Posts post, Comment comment) {
        post.addComment(comment);
    }

    public void deletePost(User whoAreYou, Posts post) {
        UserType userType = whoAreYou.getUserType();
        if (userType == UserType.MODERATOR || userType == UserType.ADMIN) {
            postList.remove(post);
        }else{
            throw new IllegalArgumentException("Only moderators and admins can delete this post");
        }
    }

    public void deleteComment(User whoAreYou, Posts posts, Comment whichCommentInThePost) {
        UserType userType = whoAreYou.getUserType();
        if (userType == UserType.MODERATOR || userType == UserType.ADMIN) {
            posts.deleteComment(whichCommentInThePost);
        }else {
            throw new IllegalArgumentException("Only moderators and admins can delete this comment");
        }
    }

    public void deleteUser(User whoAreYou, Posts post , User userToDelete) {
        UserType userType = whoAreYou.getUserType();
        if (userType == UserType.ADMIN ) {
            userList.remove(userToDelete);
        }
    }

    public void searchPost (String keyword) {
        for (Posts post : postList) {
            if(post.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(post);
            }
        }
    }

    public void searchUser (User user) {
        for (User u : userList) {
            if(u.getId() == user.getId() || u.getUserName() == user.getUserName()){
                System.out.println("User found");
            }
        }
    }

    public static void main(String[] args) {
        Groupe groupe = new Groupe("groupe");
        User user1 = new User("a","Gael","email@gmail.com");
        Posts posts = new Posts("postako",user1);
        groupe.createPost(posts);
        groupe.searchPost("ako");


    }
}
