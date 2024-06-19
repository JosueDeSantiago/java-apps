package gto.talent.tech;

import gto.talent.tech.model.Album;
import gto.talent.tech.model.Artist;
import gto.talent.tech.model.Song;
import gto.talent.tech.util.PopulateMusicData;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Artist> artists = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        List<List<String>> albumSongs = new ArrayList<>();

        PopulateMusicData.populate(artists, songs, albums, albumSongs);

        System.out.println("Artists: " + artists.size());
        // Imprime toda la lista de artistas usando foreach
        artists.forEach(artist -> System.out.println(artist));

        System.out.println("Albums: " + albums.size());
        // Imprime toda la lista de albumes usando foreach
        albums.forEach(album -> System.out.println(album));

        System.out.println("Songs: " + songs.size());
        // Imprime toda la lista de canciones usando foreach
        songs.forEach(song -> System.out.println(song));

        System.out.println("Album Songs: " + albumSongs.size());
        // Imprime toda la lista de albums y canciones usando foreach
        albumSongs.forEach(albumSong -> System.out.println(albumSong));

        // Challenge 1: Artistas que sean de genero Country
        List<Artist> countryArtists = artists.stream()
                .filter(artist -> "Country".equalsIgnoreCase(artist.getGenre()))
                .collect(Collectors.toList());
        System.out.println("Country Artists: " + countryArtists);

        // Challenge 2: Nombre de canciones cuya duracion es mayor de 200 segundos
        List<String> longSongs = songs.stream()
                .filter(song -> parseDuration(song.getDuration()) > 200)
                .map(Song::getTitle)
                .collect(Collectors.toList());
        System.out.println("Songs longer than 200 seconds: " + longSongs);

        // Challenge 3: Id de la cancion mas corta de toda la lista
        Optional<String> shortestSongId = songs.stream()
                .min(Comparator.comparingInt(song -> parseDuration(song.getDuration())))
                .map(Song::getTitle);
        shortestSongId.ifPresent(id -> System.out.println("Shortest Song ID: " + id));

        // Challenge 4: Nombre del artista con el album de duracion mas larga
        Map<String, Integer> albumDurations = new HashMap<>();
        for (int i = 0; i < albumSongs.size(); i++) {
            List<String> songIds = albumSongs.get(i);
            int totalDuration = songIds.stream()
                    .map(id -> songs.stream().filter(song -> song.getId().equals(id)).findFirst().orElse(null))
                    .filter(Objects::nonNull)
                    .mapToInt(song -> parseDuration(song.getDuration()))
                    .sum();
            albumDurations.put(albums.get(i).getId(), totalDuration);
        }

        Optional<Album> longestAlbum = albums.stream()
                .max(Comparator.comparingInt(album -> albumDurations.getOrDefault(album.getId(), 0)));
        longestAlbum.ifPresent(album -> {
            Optional<Artist> artist = artists.stream()
                    .filter(a -> a.getId().equals(album.getArtistId()))
                    .findFirst();
            artist.ifPresent(a -> System.out.println("Artist with longest album: " + a.getName()));
        });
    }

    public static int parseDuration(String duration) {
        // Assuming the duration format is "mm:ss"
        String[] parts = duration.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
}
