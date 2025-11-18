package com.firstapp.bulsustudente_handbook;

public class StudentOrg {
    public String title;
    public String description;
    public int image;

    // Adviser
    public String adviserName;
    public String adviserPosition;
    public int adviserProfile;   // NEW: photo resource

    // President
    public String presidentName;
    public String presidentCourse;
    public int presidentProfile;  // NEW: photo resource

    public String fbLink;
    public String email;

    public StudentOrg(String title, String description, int image,
                      String adviserName, String adviserPosition, int adviserProfile,
                      String presidentName, String presidentCourse, int presidentProfile,
                      String fbLink, String email) {

        this.title = title;
        this.description = description;
        this.image = image;

        this.adviserName = adviserName;
        this.adviserPosition = adviserPosition;
        this.adviserProfile = adviserProfile;

        this.presidentName = presidentName;
        this.presidentCourse = presidentCourse;
        this.presidentProfile = presidentProfile;

        this.fbLink = fbLink;
        this.email =email;
    }
}

