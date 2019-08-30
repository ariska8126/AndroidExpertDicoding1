package ariska.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title;
    private String overview;
    private String director;
    private String status;
    private String releaseDate;
    private String language;
    private String runtime;
    private int image;

    public Movie(String title, String overview, String director, String status, String releaseDate, String language, String runtime, int image) {
        this.title = title;
        this.overview = overview;
        this.director = director;
        this.status = status;
        this.releaseDate = releaseDate;
        this.language = language;
        this.runtime = runtime;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Movie() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.director);
        dest.writeString(this.status);
        dest.writeString(this.releaseDate);
        dest.writeString(this.language);
        dest.writeString(this.runtime);
        dest.writeInt(this.image);
    }

    protected Movie(Parcel in) {
        this.title = in.readString();
        this.overview = in.readString();
        this.director = in.readString();
        this.status = in.readString();
        this.releaseDate = in.readString();
        this.language = in.readString();
        this.runtime = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
