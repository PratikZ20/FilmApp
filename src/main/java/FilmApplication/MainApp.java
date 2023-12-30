package FilmApplication;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private  static FilmServise servise = new FilmServise();
     private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("SELECTION OPERATION :");
        System.out.println("1. Insert operation :");
        System.out.println("2. Update operation :");
        System.out.println("3. Display Rating :");
        System.out.println("4. Display film for oscers :");
        System.out.println("5. exit");

        int ch = sc.nextInt();

        switch (ch){
            case 1:
                insertFilm();
                break;
            case 2:
                updateFilm();
                break;
            case 3:
                showRating();
                break;
            case 4:
                showFiveFilm();
            break;
            case 5:
                System.exit(0);
            default:
                System.out.println("invalid input ");
        }
        main(args);
    }

    public static void insertFilm()
    {
        System.out.println("ENTER THE FILMID");
        int filmId = sc.nextInt();
        System.out.println("ENTER THE FILM NAME ");
        String filmName = sc.next();
        System.out.println("ENTER THE FILM YEAR ");
        int filmYear = sc.nextInt();
        System.out.println("ENTER THE FILM LANG ");
        String filmLang = sc.next();
        System.out.println("ENTER THE FILM RATING ");
        int filmRating =sc.nextInt();

        Film newFilm = new Film(filmId, filmName, filmYear, filmLang, filmRating);
        servise.insertFilm(newFilm);
        System.out.println("FILM ADDED SUCCESSFULLY ");
    }
    public static void updateFilm(){
        System.out.println("ENTER THE FILM YEAR TO UPDATE ");
        int filmYear = sc.nextInt();
        System.out.println("ENTER THE FILM NAME ");
        String filmName = sc.next();

        Film newFilm = new Film(filmYear, filmName);
       servise.updateFilm(newFilm);
        System.out.println(" film updated successfully ");
    }
    public static void showRating(){
        List<Film> filmList = servise.showRating();
        for(Film f : filmList)
        {
            System.out.println(f.getFilmRating());
        }

    }
    public static void showFiveFilm(){

        List<Film> filmList = servise.showFiveFilm();
        for(Film F : filmList){
            System.out.println(F.getFilmName());
        }
    }
}
