package gto.talent.tech.model;

public class Song {
    private String id;
    private String title;
    private String duration;
    private String artistId;

    public Song(String id, String title, String duration, String artistId) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artistId = artistId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", artistId='" + artistId + '\'' +
                '}';
    }
}
