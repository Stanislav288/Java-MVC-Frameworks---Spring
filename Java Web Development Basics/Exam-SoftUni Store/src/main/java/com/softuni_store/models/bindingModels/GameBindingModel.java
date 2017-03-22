package com.softuni_store.models.bindingModels;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Galin on 5.3.2017 г..
 */
public class GameBindingModel {

    @Pattern(regexp = "^[A-Z].{3,100}$",message = "Invalid Title")
    private String title;

    //@Size(min=0,message = "Invalid Price")
    private String price;

    //@Size(min=0,message = "Invalid Size")
    private String size;

    @Size(min=11,max = 11,message = "Invalid Trailer")
    private String trailer;

    private String releaseDate;

    @Pattern(regexp = "^((http:\\/\\/)|(https:\\/\\/)).+$",message = "Invalid Image Thumbnail URL")
    private String imageThumbnail;

    @Size(min = 20,message = "Invalid Description")
    private String description;

//    private LoggedUserModel loggedUserModel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
