package com.firstapp.bulsustudente_handbook;

public class LSCOfficer {
    private String name;
    private String position;
    private int imageResId;   // Drawable resource ID
    private String credential;
    private String course;

    public LSCOfficer(String name, String position, int imageResId, String credential, String course) {
        this.name = name;
        this.position = position;
        this.imageResId = imageResId;
        this.credential = credential;
        this.course = course;
    }

    // Getters
    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getImageResId() { return imageResId; }
    public String getCredential() { return credential; }
    public String getCourse() { return course; }
}