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
    public List<Image> getImagesByAlbum(final int p_albumId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addImage(final Image p_image) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteImage(final Short p_imageId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAlbum(final String p_albumName) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editImage(final Image p_image) {
        // TODO Auto-generated method stub

    }

}
