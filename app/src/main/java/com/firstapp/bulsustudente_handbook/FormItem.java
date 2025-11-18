package com.firstapp.bulsustudente_handbook;

/**
 * Data model for a downloadable form.
 */
public class FormItem {
    private String title;
    private String downloadUrl;

    public FormItem(String title, String downloadUrl) {
        this.title = title;
        this.downloadUrl = downloadUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}