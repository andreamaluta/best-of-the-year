package org.lesson.java.best_of_the_year.classes;

public class Song {
    private int id;
    private String title;

    public Song() {
    };

    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    };

    public int getId() {
        return id;
    };

    public void setTitle(String title) {
        this.title = title;
    };

    public void setId(int id) {
        this.id = id;
    };
}
