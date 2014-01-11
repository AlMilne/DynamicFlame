package com.au.dynamicflame.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

/**
 * News.java - Domain object representing the News table in the dynamic flame database. Will hold the details about 1
 * news article including the id's of any related images.
 * 
 * @author Alasdair
 * @since 11/01/2014
 */

public class NewsArticle {

    String title;
    String subtitle;
    String content;
    String author;
    Timestamp posted_date;
    short image_id;
    byte likes;
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }
    
    /**
     * @param subtitle the subtitle to set
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * @return the posted_date
     */
    public Timestamp getPosted_date() {
        return posted_date;
    }
    
    /**
     * @param posted_date the posted_date to set
     */
    public void setPosted_date(Timestamp posted_date) {
        this.posted_date = posted_date;
    }
    
    /**
     * @return the image_id
     */
    public short getImage_id() {
        return image_id;
    }
    
    /**
     * @param image_id the image_id to set
     */
    public void setImage_id(short image_id) {
        this.image_id = image_id;
    }
    
    /**
     * @return the likes
     */
    public byte getLikes() {
        return likes;
    }
    
    /**
     * @param likes the likes to set
     */
    public void setLikes(byte likes) {
        this.likes = likes;
    }

    
}
