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

    public Image getImageByTitle(final String imageTitle);

    public List<Image> getAllImages();

    public Album getAlbumByName(String albumName);

    public List<Image> getImagesByAlbumId(final short albumId);

    public List<Image> getImagesByAlbumName(String albumName);

    public void addImage(Image image);

    public void deleteImage(Short imageId);

    public void addAlbum(final Album album);

    public void editImage(Image image);
}
