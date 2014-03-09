package org.au.dynamicflame.photos.dao;

import java.util.List;
import java.util.logging.Logger;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * PhotosDAOImpl.java - Implementation of the PhotosDAO class to handle all operations relating to photos and their
 * Albums.
 *
 * @author Alasdair
 * @since 09/03/2014
 */
@Repository
public class PhotosDAOImpl implements PhotosDAO {
    private static final Logger LOGGER = Logger.getLogger("PhotosDAOImpl");

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Album> getAlbums() {
        return sessionFactory.getCurrentSession().createQuery("FROM Album").list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImageById(final int imageId) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Image where image_id = :imageId");
        query.setParameter("imageId", imageId);

        return (Image) query.list().get(0);
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
