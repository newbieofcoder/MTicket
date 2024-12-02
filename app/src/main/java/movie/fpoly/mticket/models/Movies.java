package movie.fpoly.mticket.models;

import java.sql.Date;
import java.sql.Time;

public class Movies {
    private int movie_id;
    private int category_id;
    private String movie_name;
    private String movie_description;
    private String movie_trailer;
    private Date movie_release;
    private String movie_poster;
    private String movie_length;

    public Movies() {
    }

    public Movies(String movie_length, int category_id, String movie_poster, Date movie_release, String movie_trailer, String movie_description, String movie_name, int movie_id) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.category_id = category_id;
        this.movie_length = movie_length;
        this.movie_poster = movie_poster;
        this.movie_release = movie_release;
        this.movie_trailer = movie_trailer;
        this.movie_description = movie_description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getMovie_length() {
        return movie_length;
    }

    public void setMovie_length(String movie_length) {
        this.movie_length = movie_length;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster = movie_poster;
    }

    public Date getMovie_release() {
        return movie_release;
    }

    public void setMovie_release(Date movie_release) {
        this.movie_release = movie_release;
    }

    public String getMovie_trailer() {
        return movie_trailer;
    }

    public void setMovie_trailer(String movie_trailer) {
        this.movie_trailer = movie_trailer;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
}
