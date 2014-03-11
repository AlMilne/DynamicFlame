-- Get all images and their albums
SELECT image.title, album.album_name FROM `image` 
LEFT JOIN `image_album` ON image.image_id = image_album.image_id 
LEFT JOIN `album` ON image_album.album_id = album.album_id;

-- Insert a new image and add it to a album
insert into image (title, meta_type, location) values ('Winners', 'JPEG', '/social/img_7922.jpg');
SET @image_id = LAST_INSERT_ID();

INSERT INTO image_album (image_id, album_id) VALUES(@image_id, '1');