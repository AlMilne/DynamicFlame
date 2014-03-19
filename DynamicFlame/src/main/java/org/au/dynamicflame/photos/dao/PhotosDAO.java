package org.au.dynamicflame.photos.dao;

import java.util.List;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;

/**
 * PhotosDAO.java - DAO interface for handling photos
 *
 * @author Alasdair
 * @since 09/03/2014
 */
public interface PhotosDAO {

    List<Album> getAlbums();

    Album getAlbumByName(String albumName);

    Image getImageById(final int imageId);

    Image getImageByTitle(final String imageTitle);

    List<Image> getAllImages();

    List<Image> getImagesByAlbumId(short albumId);

    List<Image> getImagesByAlbumName(String albumName);

    void addImage(Image image);

    void deleteImage(Short imageId);

    void addAlbum(final Album album);

    void editImage(Image image);

}
