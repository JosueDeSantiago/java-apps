package gto.talent.tech.model;

public class Album {
    private String id;
    private String title;
    private String year;
    private String artistId;

    public Album(String id, String title, String year, String artistId) {
        this.id = id;
        this.title = title;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", artistId='" + artistId + '\'' +
                '}';
    }
}
