package com.example.lalitha.ucbjson;

// a class that will function as a container for the things in *A*
// list element. Remember this is one list element.. Can contain many parts
// depending on what the list element must show as data and how the data
// needs to be manipulated for getting/setting etc.
// Ideal encapsulation ! of a list element 
public class FeedItem {
    private String title;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setThumbnail(String link) {
        this.link = link;
    }
}
