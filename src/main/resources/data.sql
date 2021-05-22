/*
    SQL statements to initialise in-memory H2 database with mock data

DROP TABLE IF EXISTS music_videos CASCADE;

CREATE TABLE music_videos(
    id VARCHAR(250) PRIMARY KEY,
    title VARCHAR(250) NOT NULL
);

INSERT INTO music_videos (id, title) VALUES
    ('PVjiKRfKpPI', 'Hozier - Take Me To Church (Official Video)');

DROP TABLE IF EXISTS reviews;


*/