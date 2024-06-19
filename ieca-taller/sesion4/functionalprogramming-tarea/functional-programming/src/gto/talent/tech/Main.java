// package gto.talent.tech;

// import gto.talent.tech.model.Album;
// import gto.talent.tech.model.Artist;
// import gto.talent.tech.model.Song;
// import gto.talent.tech.util.PopulateMusicData;

// import java.util.*;
// import java.util.function.*;
// import java.util.stream.Collectors;

// public class Main {
//     public static void main(String[] args) {
//         List<Artist> artists = new ArrayList<>();
//         List<Album> albums = new ArrayList<>();
//         List<Song> songs = new ArrayList<>();
//         List<List<String>> albumSongs = new ArrayList<>();

//         PopulateMusicData.populate(artists, songs, albums, albumSongs);

//         System.out.println("Artists: " + artists.size());
//         // TODO: Imprime toda la lista de artistas usando foreach

//         System.out.println("Albums: " + albums.size());
//         // TODO: Imprime toda la lista de albumes usando foreach

//         System.out.println("Songs: " + songs.size());
//         // TODO: Imprime toda la lista de canciones usando foreach

//         System.out.println("Album Songs: " + albumSongs.size());
//         // TODO: Imprime toda la lista de albums y canciones usando foreach

//         //TODO: Challenge 1: Artistas que sean de genero Country

//         //TODO: Challenge 2: Nombre de canciones cuya duracion es mayor de 200 segundos

//         //TODO: Challenge 3: Id de la cancion mas corta de toda la lista

//         //TODO: Challenge 4: Nombre del artista con el album de duracion mas larga

//     }

//     public static int parseDuration(String duration) {
//         //TODO: Complete this method
//         return 0;
//     }
// }
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
                .map(Song::getId);
        shortestSongId.ifPresent(id -> System.out.println("Shortest Song ID: " + id));

        // Challenge 4: Nombre del artista con el album de duracion mas larga
        // Assuming albumSongs contains album durations as the last element in each list
        // Otherwise, you need to update the logic based on how the album durations are stored
        Map<String, Integer> albumDurations = new HashMap<>();
        for (int i = 0; i < albumSongs.size(); i++) {
            int totalDuration = albumSongs.get(i).subList(1, albumSongs.get(i).size()).stream()
                    .mapToInt(Main::parseDuration)
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
