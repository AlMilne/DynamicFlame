package org.au.dynamicflame.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.au.dynamicflame.model.Album;
import org.au.dynamicflame.model.Image;
import org.au.dynamicflame.photos.service.PhotosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
    private PhotosService photosService;

    protected void tearDown() throws Exception {

    }

    /**
     * Test method for {@link PhotosService#getAlbums()} .
     */
    @Test
    public void testGetAlbums() {
        List<Album> albumsList = photosService.getAlbums();

        assertNotNull(albumsList);

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

    /**
     * Test method for {@link PhotosService#getImagesByAlbum(int albumId)} .
     */
    @Test
    public void testGetImagesByAlbumId() {
        short id = 1;
        List<Image> images = photosService.getImagesByAlbumId(id);

        assertNotNull(images);
        if (images.size() > 0) {
            verifyImageIsInAlbum(images, "Tournaments");
        }

        id = 2;
        images = photosService.getImagesByAlbumId(id);
        assertNotNull(images);
        if (images.size() > 0) {
            verifyImageIsInAlbum(images, "Venues");
        }

        id = 3;
        images = photosService.getImagesByAlbumId(id);
        assertNotNull(images);
        if (images.size() > 0) {
            verifyImageIsInAlbum(images, "Social");
        }
    }

    /**
     * Test method for {@link PhotosService#getImagesByAlbumName(String albumName)} .
     */
    @Test
    public void testGetImagesByAlbumName() {
        // Get all images that are in the Tournaments album
        List<Image> images = photosService.getImagesByAlbumName("Tournaments");
        assertNotNull(images);
        if (images.size() > 0) {
            verifyImageIsInAlbum(images, "Tournaments");
        }

        // Get all images that are in the Venues album
        images = photosService.getImagesByAlbumName("Venues");
        assertNotNull(images);
        if (images.size() > 0) {
            verifyImageIsInAlbum(images, "Venues");
        }

        // Get all images that are in the Social album
        images = photosService.getImagesByAlbumName("Social");
        assertNotNull(images);
        if (images.size() > 0) {
            verifyImageIsInAlbum(images, "Social");
        }
    }

    /**
     * verifyImageIsInAlbum - Test that all the images passed in are in the same given album
     *
     * @param images
     */
    private void verifyImageIsInAlbum(final List<Image> images, final String albumName) {
        Set<Album> albums = images.get(0).getAlbums();

        // Test that all the images returned are in the associated Tournaments album
        for (Album album : albums) {
            assertEquals(albumName, album.getAlbumName());
        }
    }

    /**
     * Test method for {@link PhotosService#addImage(Image)} .
     */
    @Test
    public void testAddImage() {
        Image image = new Image();

        image.setTitle("TestImage");
        image.setLocation("TestLocation");
        image.setMetaType("JPEG");

        Set<Album> albums = new HashSet<Album>();
        Album album = new Album();
        album.setAlbumName("Venues");

        albums.add(album);

        image.setAlbums(albums);

        photosService.addImage(image);
    }

    /**
     * Test method for {@link PhotosService#addAlbum(Album)} .
     */
    @Test
    @Rollback(true)
    public void testAddAlbum() {
        Album album = new Album();

        String albumName = "TestAlbum";

        album.setAlbumName(albumName);

        photosService.addAlbum(album);

        Album testAlbum = photosService.getAlbumByName(albumName);

        assertEquals(testAlbum.getAlbumName(), albumName);
    }

    /**
     * Test method for {@link PhotosService#deleteImage(imageId)} .
     */
    @Test
    public void testDeleteImage() {
        Image imageToDelete = photosService.getImageByTitle("TestImage");

        int numOfImages = photosService.getAllImages().size();

        photosService.deleteImage(imageToDelete.getImageId());

        assertEquals(numOfImages - 1, photosService.getAllImages().size());
    }

    /**
     * Test method for {@link PhotosService#getImageByTitle(imageName)} .
     */
    @Test
    public void testGetImageByTitle() {
        Image image = photosService.getImageByTitle("TestImage");

        assertEquals("TestImage", image.getTitle());
    }

}
