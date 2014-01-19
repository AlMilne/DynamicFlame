package org.au.dynamicflame.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * News.java - Domain object representing the News table in the dynamic flame database. Will hold the details about 1
 * news article including the id's of any related images.
 * 
 * @author Alasdair
 * @since 11/01/2014
 */
@Entity
@Table( name = "news" )
public class NewsArticle {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "story_id")
    int story_id;

    @NotEmpty
    @Column(name = "title")
    String title;
    
    @NotEmpty
    @Column(name = "subtitle")
    String subtitle;
    
    @NotEmpty
    @Column(name = "content")
    String content;
    
    @Column(name = "author")
    String author;
    
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "posted_time")
    Timestamp posted_time;
    
    @Column(name = "image_id")
    short image_id;
    
    @Column(name = "likes")
    byte likes;
    
    /**
     * @return the story_id
     */
    public int getStory_id() {
        return story_id;
    }

    /**
     * @param story_id the story_id to set
     */
    public void setStory_id(int story_id) {
        this.story_id = story_id;
    }

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_time")
    public Timestamp getPosted_time() {
        return posted_time;
    }
    
    /**
     * @param posted_date the posted_date to set
     */
    public void setPosted_time(Timestamp posted_time) {
        this.posted_time = posted_time;
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
