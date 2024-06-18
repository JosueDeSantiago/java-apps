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
        // TODO: Imprime toda la lista de artistas usando foreach

        System.out.println("Albums: " + albums.size());
        // TODO: Imprime toda la lista de albumes usando foreach

        System.out.println("Songs: " + songs.size());
        // TODO: Imprime toda la lista de canciones usando foreach

        System.out.println("Album Songs: " + albumSongs.size());
        // TODO: Imprime toda la lista de albums y canciones usando foreach

        //TODO: Challenge 1: Artistas que sean de genero Country

        //TODO: Challenge 2: Nombre de canciones cuya duracion es mayor de 200 segundos

        //TODO: Challenge 3: Id de la cancion mas corta de toda la lista

        //TODO: Challenge 4: Nombre del artista con el album de duracion mas larga

    }

    public static int parseDuration(String duration) {
        //TODO: Complete this method
        return 0;
    }
}
