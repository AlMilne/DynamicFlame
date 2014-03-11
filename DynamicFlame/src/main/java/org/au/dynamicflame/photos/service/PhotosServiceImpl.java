package org.au.dynamicflame.photos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;
import org.au.dynamicflame.photos.dao.PhotosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PhotosServiceImpl.java - Service layer class for the PhotosService.
 *
 * @author Alasdair
 * @since 09/03/2014
 */
@Service
@Transactional
public class PhotosServiceImpl implements PhotosService {

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
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteImage(final Short imageId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAlbum(final String albumName) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editImage(final Image image) {
        // TODO Auto-generated method stub

    }

}
