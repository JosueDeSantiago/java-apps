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

        /* no la veo pero s[i se gener[o
        System.out.println("Artists: " + artists.size());
        for(Artist artist : artists){
            System.out.println(artist);
        }

        System.out.println("Albums: " + albums.size());
        for(Album album : albums){
            System.out.println(album);
        }

        System.out.println("Songs: " + songs.size());
        for(Song song : songs){
            System.out.println(song);
        }

        System.out.println("Album Songs: " + albumSongs.size());
        for(List<String> list: albumSongs){
            System.out.println("album id: " + list.get(0));
            System.out.println("song id: " + list.get(1));
        }

    diferencia entre interfaz e interfaz funcional?
         */
        Function<String,String> holaFunction = (hola)->{return hola;};
        Predicate<Integer> comparePredicate = num->{return num == (20/2);};
        UnaryOperator<String> sumFifteen = num->{return num+15;};
        System.out.println("Hola dice: " + sumFifteen.apply("10"));

        Consumer<Artist> artistConsumer = artist -> {
            System.out.println(artist);
        };
        //artists.stream().forEach(artistConsumer);
        //artists.stream().forEach(artist->System.out.println(artist));
        //method reference
        //artists.stream().forEach(System.out::println);


        //Ejemplo: Artistas que sean de genero Pop
        //Predicate<Artist> compareArtistGenre = artist->{return artist.getGenre().equals("Pop");};
        System.out.println("Artists with genre Pop");
        artists.stream()
                .filter(artist->artist.getGenre().equals("Pop"))
                .forEach(System.out::println);

        //Ejemplo 2: canciones de un artista Id: 1
        //song.getArtist().equals("1")
        System.out.println("Songs with ArtistID = 1");
        songs.stream()
                .filter(song -> song.getArtistId().equals("1"))
                .forEach(System.out::println);

        //Ejemplo 3: Convertir nombres de canciones a UpperCase
        //Function<Song,String> getTitleFromSong = song -> song.getTitle();

        //Function<String,String> convertSongTitleToUppercase = title -> title.toUpperCase();

        System.out.println("Songs with uppercase title: ");
        songs.stream()
                .map(Song::getTitle)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Ejemplo 4: Calcular el promedio de la duracion de canciones
        System.out.println("Average song duration");

        songs.stream()
                .mapToInt(song -> parseDuration(song.getDuration()))
                .average()
                .ifPresent(System.out::println);

        //Ejemplo 5: Obtener el total de canciones
        Long songsCount = songs.stream().count();
        System.out.println("The total songs number: " + songsCount);

        //Ejemplo 6: Contar el numero de canciones por album
        System.out.println("Number of songs in each album:");

        Map<String,Long> albumSongCounts = albumSongs.stream()
                .collect(Collectors.groupingBy(albumSong -> albumSong.get(0),Collectors.counting()));

        albums.forEach(album -> System.out.println(album.getTitle() + ": " + albumSongCounts.getOrDefault(album.getId(), 0L) + " songs"));
    }

    public static int parseDuration(String duration) {
        String[] parts = duration.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
}
