package gto.talent.tech.util;

import gto.talent.tech.model.Album;
import gto.talent.tech.model.Artist;
import gto.talent.tech.model.Song;

import java.util.ArrayList;
import java.util.List;

public class PopulateMusicData {
    public static void populate(List<Artist> artists, List<Song> songs, List<Album> albums, List<List<String>> albumSongs) {
        generateAlbums(albums);
        generateArtists(artists);
        generateSongs(songs);
        generateAlbumSongs(albumSongs);
    }

    public static void generateArtists(List<Artist> artists) {
        Artist taylor = new Artist("1", "Taylor Swift", "Country");
        artists.add(taylor);
        artists.add(new Artist("2", "Ed Sheeran", "Pop"));
        artists.add(new Artist("3", "Adele", "Soul, Pop"));
        artists.add(new Artist("4", "Drake", "Hip-hop"));
    }

    public static void generateAlbums(List<Album> albums) {
        albums.add(new Album("1", "1989", "2014", "1"));
        albums.add(new Album("2", "Divide", "2017", "2"));
        albums.add(new Album("3", "25", "2015", "3"));
        albums.add(new Album("4", "Scorpion", "2018", "4"));
    }

    public static void generateSongs(List<Song> songs) {
        songs.add(new Song("1001", "Shake It Off", "3:39", "1"));
        songs.add(new Song("1002", "Blank Space", "3:51", "1"));
        songs.add(new Song("1003", "Perfect", "4:23", "2"));
        songs.add(new Song("1004", "Shape of You", "3:53", "2"));
        songs.add(new Song("1005", "Hello", "4:55", "3"));
        songs.add(new Song("1006", "Someone Like You", "4:45", "3"));
        songs.add(new Song("1007", "God's Plan", "3:18", "4"));
        songs.add(new Song("1008", "In My Feelings", "3:37", "4"));
        songs.add(new Song("1009", "Bad Blood", "3:32", "1"));
    }

    public static void generateAlbumSongs(List<List<String>> albumSongs) {
        // Album 1
        List<String> album1Songs = new ArrayList<>();
        album1Songs.add("1001");
        album1Songs.add("1002");
        album1Songs.add("1009");
        albumSongs.add(album1Songs);

        // Album 2
        List<String> album2Songs = new ArrayList<>();
        album2Songs.add("1003");
        album2Songs.add("1004");
        albumSongs.add(album2Songs);

        // Album 3
        List<String> album3Songs = new ArrayList<>();
        album3Songs.add("1005");
        album3Songs.add("1006");
        albumSongs.add(album3Songs);

        // Album 4
        List<String> album4Songs = new ArrayList<>();
        album4Songs.add("1007");
        album4Songs.add("1008");
        albumSongs.add(album4Songs);
    }
}
