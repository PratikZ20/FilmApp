package FilmApplication;

public class Film{
    private int filmID ;
    private  String filmName;
    private  int filmYear ;
    private  String filmLang;
    private int filmRating;

    public Film(int filmID, String filmName, int filmYear, String filmLang, int filmRating) {
        this.filmID = filmID;
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.filmLang = filmLang;
        this.filmRating = filmRating;
    }

    public Film(int filmYear, String filmName) {
        this.filmYear = filmYear;
        this.filmName=filmName;
    }

    public Film(int filmRating) {
        this.filmRating=filmRating;
    }

    public Film(String filmName) {
        this.filmName=filmName;
    }


    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public void setFilmLang(String filmLang) {
        this.filmLang = filmLang;
    }

    public int getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(int filmRating) {
        this.filmRating = filmRating;
    }
}
