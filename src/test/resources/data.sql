/*
    SQL statements to initialise in-memory H2 database with mock data
*/
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS video_types CASCADE;
DROP TABLE IF EXISTS videos CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;

CREATE TABLE user_roles (
    role VARCHAR(256) PRIMARY KEY NOT NULL
);

INSERT INTO user_roles (role) VALUES
('USER'),
('ADMIN');

CREATE TABLE users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) UNIQUE NOT NULL,
    password VARCHAR(256) NOT NULL,
    role VARCHAR(256) NOT NULL DEFAULT 'USER',
    FOREIGN KEY (role) REFERENCES user_roles (role) ON DELETE CASCADE
);

INSERT INTO users (name, password, role) VALUES
('TestUserOne', 'saltedHashPassword', 'USER');

CREATE TABLE video_types (
    video_type VARCHAR(256) PRIMARY KEY NOT NULL
);

INSERT INTO video_types (video_type) VALUES
('MUSIC');

CREATE TABLE videos (
    video_id VARCHAR(256) PRIMARY KEY NOT NULL,
    title VARCHAR(512) NOT NULL,
    video_type VARCHAR(256) NOT NULL DEFAULT 'MUSIC',
    thumbnail_url VARCHAR(512) NOT NULL,
    FOREIGN KEY (video_type) REFERENCES video_types (video_type) ON DELETE CASCADE
);

INSERT INTO videos (video_id, title, video_type, thumbnail_url) VALUES
('PVjiKRfKpPI', 'Hozier - Take Me To Church (Official Video)', 'MUSIC', 'https://i.ytimg.com/vi/PVjiKRfKpPI/mqdefault.jpg'),
('1nnRC6jDOCI', 'Hozier - Take Me To Church (Pop-Up Show in NYC Subway)', 'MUSIC', 'https://i.ytimg.com/vi/1nnRC6jDOCI/mqdefault.jpg'),
('l2UiY2wivTs', 'Lemon Tree - Fools Garden (Lyrics) 🎵', 'MUSIC', 'https://i.ytimg.com/vi/l2UiY2wivTs/mqdefault.jpg'),
('bCDIt50hRDs', 'Fool&#39;s Garden - Lemon Tree', 'MUSIC', 'https://i.ytimg.com/vi/bCDIt50hRDs/mqdefault.jpg'),
('HfdEk5RbzrA', '蘇慧倫 Tarcy Su【Lemon Tree】Official Music Video', 'MUSIC', 'https://i.ytimg.com/vi/HfdEk5RbzrA/mqdefault.jpg'),
('w0AOGeqOnFY', 'The Coconut Song - (Da Coconut Nut)', 'MUSIC', 'https://i.ytimg.com/vi/w0AOGeqOnFY/mqdefault.jpg'),
('h1kWMX0qrOY', 'The coconut song, but Among us', 'MUSIC', 'https://i.ytimg.com/vi/h1kWMX0qrOY/mqdefault.jpg');

CREATE TABLE reviews (
    review_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rating DOUBLE NOT NULL,
    title VARCHAR(512) NOT NULL,
    content CLOB NOT NULL,
    created_on TIMESTAMP NOT NULL,
    last_modified_on TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    video_id VARCHAR(256) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES videos (video_id)
);

INSERT INTO reviews(rating, title, content, created_on, last_modified_on, user_id, video_id) VALUES
(5.0, 'Best MV ever', 'I love this MV so much because there is so much going on here', TIMESTAMP '1970-01-01 00:00:01', TIMESTAMP '1970-01-01 00:00:01', 1, 'PVjiKRfKpPI'),
(3.0, 'Just another "woke" MV', 'Stop pretending to understand the feelings of the marginalized when you are in a privileged position', TIMESTAMP '1970-01-01 00:00:01', TIMESTAMP '1970-01-01 00:00:05', 1, 'PVjiKRfKpPI'),
(2.0, 'Did not even watch it', 'As expressed in the title', TIMESTAMP '1997-01-01 00:00:01', TIMESTAMP '1998-01-01 00:00:01', 1, 'PVjiKRfKpPI'),
(5.0, 'One word: nostalgia.', 'This was and is my childhood. Catchy tune coupled with crazy cartoons. Great.', TIMESTAMP '2020-09-08 13:41:01', TIMESTAMP '2021-09-08 18:51:01', 1, 'l2UiY2wivTs'),
(5.0, 'Love the vibes', 'No one can resist vibing to this song. The MV is just the cream on the cake.', TIMESTAMP '2021-09-08 14:43:01', TIMESTAMP '2021-10-08 18:51:01', 1, 'l2UiY2wivTs'),
(5.0, 'Gotta love this', 'Love this video', TIMESTAMP '2021-09-08 14:43:01', TIMESTAMP '2021-10-08 18:51:01', 1, 'l2UiY2wivTs'),
(4.0, '-1 for the annoying song', 'The video is quite and creative but the rest is...', TIMESTAMP '2019-04-02 19:43:01', TIMESTAMP '2021-10-08 18:51:01', 1, 'l2UiY2wivTs'),
(1.0, 'Cannot be compared to the OG MV', 'a silly song should be matched with silly graphics, not something like this. Total party pooper', TIMESTAMP '2020-06-03 12:11:01', TIMESTAMP '2021-04-09 18:51:01', 1, 'bCDIt50hRDs'),
(3.0, 'So-so bah', 'Just another MV, you know what I mean?', TIMESTAMP '2020-06-03 12:11:01', TIMESTAMP '2021-04-09 18:51:01', 1, 'bCDIt50hRDs'),
(4.0, 'Very 2000s feels', 'The aesthetics, the color scheme, the font choice...everything screams 2000s', TIMESTAMP '2020-09-02 04:12:01', TIMESTAMP '2021-04-09 22:51:01', 1, 'bCDIt50hRDs'),
(4.0, 'Da da la da da di la da', '超赞耶', TIMESTAMP '2013-03-03 14:10:04', TIMESTAMP '2013-03-03 14:10:04', 1, 'bCDIt50hRDs'),
(5.0, 'One word: nostalgia.', 'This was and is my childhood. Catchy tune coupled with crazy cartoons. Great.', TIMESTAMP '2020-09-08 13:41:01', TIMESTAMP '2021-09-08 18:51:01', 1, 'w0AOGeqOnFY'),
(5.0, 'Love the vibes', 'No one can resist vibing to this song. The MV is just the cream on the cake.', TIMESTAMP '2021-09-08 14:43:01', TIMESTAMP '2021-10-08 18:51:01', 1, 'w0AOGeqOnFY'),
(5.0, 'Gotta love this', 'Love this video', TIMESTAMP '2021-09-08 14:43:01', TIMESTAMP '2021-10-08 18:51:01', 1, 'w0AOGeqOnFY'),
(2.0, 'Cannot be compared to the OG MV', 'a silly song should be matched with silly graphics, not something like this. Total party pooper', TIMESTAMP '2020-06-03 12:11:01', TIMESTAMP '2021-04-09 18:51:01', 1, 'h1kWMX0qrOY'),
(3.0, 'So-so bah', 'Just another MV, you know what I mean?', TIMESTAMP '2020-06-03 12:11:01', TIMESTAMP '2021-04-09 18:51:01', 1, 'h1kWMX0qrOY');
