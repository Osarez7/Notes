package co.edu.intecap.notes.model.datamodels;

import java.util.Date;

public class Note {

    private String name;
    private String description;
    private String imageUri;
    private Date creationDate;
    private boolean isFavorite;

    public Note(String name, String description, String imageUri, Date creationDate, boolean isFavorite) {
        this.name = name;
        this.description = description;
        this.imageUri = imageUri;
        this.creationDate = creationDate;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
