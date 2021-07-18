package com.joanneong.snapshot;

import com.joanneong.snapshot.models.Review;
import com.joanneong.snapshot.models.User;
import com.joanneong.snapshot.models.UserRole;
import com.joanneong.snapshot.models.Video;
import com.joanneong.snapshot.models.VideoType;

import java.time.LocalDateTime;

public class TestDataHelper {
    public static final Video TAKE_ME_TO_CHURCH_OFFICIAL = new Video("PVjiKRfKpPI",
            "Hozier - Take Me To Church (Official Video)", VideoType.MUSIC,
            "https://i.ytimg.com/vi/PVjiKRfKpPI/mqdefault.jpg");
    public static final Video TAKE_ME_TO_CHURCH_POP_UP = new Video("1nnRC6jDOCI",
            "Hozier - Take Me To Church (Pop-Up Show in NYC Subway)", VideoType.MUSIC,
            "https://i.ytimg.com/vi/1nnRC6jDOCI/mqdefault.jpg");
    public static final Video LEMON_TREE_LYRICS = new Video("l2UiY2wivTs",
            "Lemon Tree - Fools Garden (Lyrics) 🎵", VideoType.MUSIC,
            "https://i.ytimg.com/vi/l2UiY2wivTs/mqdefault.jpg");
    public static final Video LEMON_TREE_MUSIC = new Video("bCDIt50hRDs",
            "Fool&#39;s Garden - Lemon Tree", VideoType.MUSIC,
            "https://i.ytimg.com/vi/bCDIt50hRDs/mqdefault.jpg");
    public static final Video LEMON_TREE_CHINESE = new Video("HfdEk5RbzrA",
            "蘇慧倫 Tarcy Su【Lemon Tree】Official Music Video", VideoType.MUSIC,
            "https://i.ytimg.com/vi/HfdEk5RbzrA/mqdefault.jpg");
    public static final Video COCONUT_SONG = new Video("w0AOGeqOnFY",
            "The Coconut Song - (Da Coconut Nut)", VideoType.MUSIC,
            "https://i.ytimg.com/vi/w0AOGeqOnFY/mqdefault.jpg");
    public static final Video COCONUT_SONG_AMONG_US = new Video("h1kWMX0qrOY",
            "The coconut song, but Among us", VideoType.MUSIC,
            "https://i.ytimg.com/vi/h1kWMX0qrOY/mqdefault.jpg");
    public static final String INVALID_VIDEO_ID = "abcdefg";

    public static final User INVALID_USER = new User(-1L, "InvalidTestUser", "noPassword", UserRole.USER);
    public static final User VALID_USER = new User(1L, "TestUserOne", "saltedHashPassword", UserRole.USER);

    public static final Review TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_ONE = new Review(null, 5.0, "Best MV ever",
            "I love this MV so much because there is so much going on here",
            LocalDateTime.now(), LocalDateTime.now(), VALID_USER, TAKE_ME_TO_CHURCH_OFFICIAL);
    public static final Review TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_TWO = new Review(null, 3.0, "Just another \"woke\" MV",
            "Stop pretending to understand the feelings of the marginalized when you are in a privileged position",
            LocalDateTime.now(), LocalDateTime.now(), VALID_USER, TAKE_ME_TO_CHURCH_OFFICIAL);
    public static final Review TAKE_ME_TO_CHURCH_OFFICIAL_REVIEW_THREE = new Review(null, 2.0, "Did not even watch it",
            "As expressed in the title", LocalDateTime.now(), LocalDateTime.now(), VALID_USER, TAKE_ME_TO_CHURCH_OFFICIAL);
}
