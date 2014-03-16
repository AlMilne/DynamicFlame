package org.au.dynamicflame.photos.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        query.setParameter("albumName", albumName);

        return query.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addImage(final Image image) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(image);

        session.getTransaction().commit();

        session.flush();
        session.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteImage(final Short imageId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Image where image_id = :imageId");
        query.setParameter("imageId", imageId);
        query.executeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAlbum(final Album album) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            LOGGER.log(Level.INFO, "Adding album: {0}", album.getAlbumName());

            tx = session.beginTransaction();
            session.save(album);
            tx.commit();
            session.flush();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editImage(final Image image) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Album getAlbumByName(final String albumName) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Album where album_name = :albumName");
        query.setParameter("albumName", albumName);

        return (Album) query.list().get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImageByTitle(final String imageTitle) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Image where title = :imageTitle");
        query.setParameter("imageTitle", imageTitle);

        return (Image) query.list().get(0);
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
