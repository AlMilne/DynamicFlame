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
    List<Album> getAlbums();

    Image getImageById(final int imageId);

    Image getImageByTitle(final String imageTitle);

    List<Image> getAllImages();

    Album getAlbumByName(String albumName);

    List<Image> getImagesByAlbumId(final short albumId);

    List<Image> getImagesByAlbumName(String albumName);

    void addImage(Image image);

    void deleteImage(Short imageId);

    void addAlbum(final Album album);

    void editImage(Image image);
}
