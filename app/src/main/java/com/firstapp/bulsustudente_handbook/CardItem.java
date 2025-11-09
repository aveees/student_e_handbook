package com.firstapp.bulsustudente_handbook;

public class CardItem {
    private int iconResId;
    private String title;
    private String description;

    public CardItem(int iconResId, String title, String description) {
        this.iconResId = iconResId;
        this.title = title;
        this.description = description;
    }

    public int getIconResId() { return iconResId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
