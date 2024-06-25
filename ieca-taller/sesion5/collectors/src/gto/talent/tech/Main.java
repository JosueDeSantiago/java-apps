package gto.talent.tech;

import gto.talent.tech.model.Album;
import gto.talent.tech.model.Artist;
import gto.talent.tech.model.Song;
import gto.talent.tech.util.PopulateMusicData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Artist> artists = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<Song> songs = new ArrayList<>();
        List<List<String>> albumSongs = new ArrayList<>();

        PopulateMusicData.populate(artists, songs, albums, albumSongs);

        System.out.println("Artists: " + artists.size());
        // TODO: Imprime toda la lista de artistas usando foreach

        System.out.println("Albums: " + albums.size());
        // TODO: Imprime toda la lista de albumes usando foreach

        System.out.println("Songs: " + songs.size());
        // TODO: Imprime toda la lista de canciones usando foreach

        System.out.println("Album Songs: " + albumSongs.size());
        // TODO: Imprime toda la lista de albums y canciones usando foreach

        //TODO: Challenge 1: Artistas que sean de genero Country
        //artists.stream().filter(artist -> artist.getGenre().equals("Country")).forEach(System.out::println);

        //TODO: Challenge 2: Nombre de canciones cuya duracion es mayor de 200 segundos
        //songs.stream().filter(song -> parseDuration(song.getDuration()) > 200).forEach(System.out::println);

        //TODO: Challenge 3: Id de la cancion mas corta de toda la lista
        //songs.stream().max(Comparator.comparingInt(song -> parseDuration(song.getDuration()))).map(Song::getId).ifPresent(System.out::println);

        //TODO: Challenge 4: Nombre del artista con el album de duracion mas larga
        // 1 crear mapa con IDSong y Duration ya procesada en segunds
        // 2 cambiar la duracion de cada uno de los valores del ID a segun
        //  el valor en el mapa de canciones
        // 3 replicar el mismo mapa que ya tengo (formar mapa a partir de mapa)
        // 4 hacer un sum sobre la lista de duracion
        // 5 tener el albumId

        Map<String,List<String>> albumSongsMap = albumSongs.stream()
                .collect(Collectors.groupingBy(albumSong->albumSong.get(0),
                        Collectors.mapping(albumSong->albumSong.get(1),Collectors.toList())));

        albumSongsMap.forEach((key, value) -> {
            System.out.println("Album ID: " + key + " Songs " + value);
        });

        Map<String, String> songDurations = songs.stream()
                .collect(Collectors.toMap(
                        song->song.getId(),
                        song->song.getDuration()));
        songDurations.forEach((key,value)-> System.out.println("Song ID: " + key + " Duration: " + value));

        Map<String, Integer> albumsByDuration = albumSongsMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry->entry.getValue().stream()
                                .mapToInt(songId->parseDuration(songDurations.get(songId)))
                                .sum()
                ));
        albumsByDuration.forEach((key, value) -> {
            System.out.println("Album ID: " + key + " Duration: " + value);
        });

        String albumId = albumsByDuration.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("not found");

        System.out.println("albumId: " + albumId);

        String artistId = albums.stream().filter(album -> album.getArtistId().equals(albumId)).findAny().get().getArtistId();
        System.out.println("artistId: " + artistId);
        System.out.println("Artist Name: " + artists.stream().filter(artist -> artist.getId().equals(artistId)).findAny().get().getName());
        
    }

    public static int parseDuration(String duration) {
        //TODO: Complete this method
        String[] parts = duration.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
}
