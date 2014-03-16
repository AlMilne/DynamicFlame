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

    public List<Album> getAlbums();

    public Album getAlbumByName(String albumName);

    public Image getImageById(final int imageId);

    public Image getImageByTitle(final String imageTitle);

    public List<Image> getAllImages();

    public List<Image> getImagesByAlbumId(short albumId);

    public List<Image> getImagesByAlbumName(String albumName);

    public void addImage(Image image);

    public void deleteImage(Short imageId);

    public void addAlbum(final Album album);

    public void editImage(Image image);

}
