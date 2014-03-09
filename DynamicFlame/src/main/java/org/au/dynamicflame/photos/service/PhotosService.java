package org.au.dynamicflame.photos.service;

import java.util.List;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;

/**
 * PhotosService.java - PhotosService interface. Will handle CRUD operations for photos.
 *
 * @author Alasdair
 * @since 09/03/2014
 */
public interface PhotosService {

    /**
     * getAlbums - returns a list of all Albums
     *
     * @return list of Albums
     */
    public List<Album> getAlbums();

    public Image getImageById(final int imageId);

    public List<Image> getImagesByAlbum(final int albumId);

    public void addImage(Image image);

    public void deleteImage(Short imageId);

    public void addAlbum(String albumName);

    public void editImage(Image image);
}
