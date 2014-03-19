package org.au.dynamicflame.photos.dao;

import java.util.List;
import java.util.logging.Level;
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
    /** IMAGE_ID */
    private static final String IMAGE_ID = "imageId";

    /** ALBUM_NAME */
    private static final String ALBUM_NAME = "albumName";

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
        query.setParameter(IMAGE_ID, imageId);

        return (Image) query.uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Image> getImagesByAlbumId(final short albumId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select i from Album a join a.images i where a.albumId = :albumId");
        query.setParameter("albumId", albumId);

        return query.list();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Image> getImagesByAlbumName(final String albumName) {
        Query query = sessionFactory.getCurrentSession().createQuery("select i from Album a join a.images i where a.albumName = :albumName");
        query.setParameter(ALBUM_NAME, albumName);

        return query.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addImage(final Image image) {
        sessionFactory.getCurrentSession().save(image);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteImage(final Short imageId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Image where image_id = :imageId");
        query.setParameter(IMAGE_ID, imageId);
        query.executeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAlbum(final Album album) {
        sessionFactory.getCurrentSession().save(album);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editImage(final Image image) {
        LOGGER.log(Level.INFO, "Image being updated: {0}", image.getLocation());

        // Retrieve the article from db that is to be updated
        Image imageToUpdate = (Image) sessionFactory.getCurrentSession().load(Image.class, image.getImageId());

        // Set the article values to be updated
        if (null != imageToUpdate) {
            imageToUpdate.setLocation(image.getLocation());
            imageToUpdate.setMetaType(image.getMetaType());
            imageToUpdate.setTitle(image.getTitle());
            imageToUpdate.setAlbums(image.getAlbums());

            sessionFactory.getCurrentSession().update(imageToUpdate);
        } else {
            LOGGER.log(Level.SEVERE, "no image to update found");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Album getAlbumByName(final String albumName) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Album where album_name = :albumName");
        query.setParameter(ALBUM_NAME, albumName);

        return (Album) query.uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImageByTitle(final String imageTitle) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Image where title = :imageTitle");
        query.setParameter("imageTitle", imageTitle);

        return (Image) query.uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Image> getAllImages() {
        return sessionFactory.getCurrentSession().createQuery("FROM Image").list();
    }

}
