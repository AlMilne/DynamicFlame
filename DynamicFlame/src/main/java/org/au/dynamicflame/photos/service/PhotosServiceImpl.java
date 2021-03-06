package org.au.dynamicflame.photos.service;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;
import org.au.dynamicflame.photos.dao.PhotosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PhotosServiceImpl.java - Service layer class for the PhotosService.
 *
 * @author Alasdair
 * @since 09/03/2014
 */
@Service
@Transactional
public class PhotosServiceImpl implements PhotosService {
    private static final Logger LOGGER = Logger.getLogger("PhotosServiceImpl");

    @Autowired
    private PhotosDAO photosDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> getAlbums() {
        return photosDAO.getAlbums();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImageById(final int imageId) {
        return photosDAO.getImageById(imageId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Image> getImagesByAlbumId(final short albumId) {
        return photosDAO.getImagesByAlbumId(albumId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Image> getImagesByAlbumName(final String albumName) {
        return photosDAO.getImagesByAlbumName(albumName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addImage(final Image image) {
        photosDAO.addImage(image);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteImage(final Short imageId) {
        photosDAO.deleteImage(imageId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAlbum(final Album album) {
        File dir = new File("src\\main\\webapp\\resources\\images\\" + album.getAlbumName());

        boolean success = dir.mkdir();

        if (success) {
            LOGGER.log(Level.INFO, "Created directory: {0}", album.getAlbumName());
        } else {
            LOGGER.log(Level.INFO, "Directory {0} already exists", album.getAlbumName());
        }

        photosDAO.addAlbum(album);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editImage(final Image image) {
        photosDAO.editImage(image);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Album getAlbumByName(final String albumName) {
        return photosDAO.getAlbumByName(albumName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImageByTitle(final String imageTitle) {
        return photosDAO.getImageByTitle(imageTitle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Image> getAllImages() {
        return photosDAO.getAllImages();
    }

}
