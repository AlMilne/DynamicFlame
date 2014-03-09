package org.au.dynamicflame.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;
import org.au.dynamicflame.photos.service.PhotosService;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * PhotosServiceTest.java - Test class for testing the PhotosService. Will test CRUD operations on dynamicflame database
 * using the photosService methods.
 *
 * @author Alasdair
 * @since 09/03/2014
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml", "classpath*:testContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class PhotosServiceTest {
    private static final Logger LOGGER = Logger.getLogger("PhotosServiceTest");

    @Autowired
    private SessionFactory sessionFactory;

    protected FlushMode flushMode = FlushMode.MANUAL;

    @Autowired
    private PhotosService photosService;

    protected void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    /**
     * Test method for {@link PhotosService#getAlbums()} .
     */
    @Test
    public void testGetAlbums() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Album> albumsList = photosService.getAlbums();

        assertNotNull(albumsList);

        assertEquals(3, albumsList.size());

        for (Album album : albumsList) {
            LOGGER.info(album.getAlbumName());
        }

    }

    /**
     * Test method for {@link PhotosService#getImageById(int imageId)} .
     */
    @Test
    public void testGetImageById() {
        Image image = photosService.getImageById(1);

        assertNotNull(image);

        LOGGER.info(image.getTitle());

    }
}
