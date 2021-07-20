package sg.edu.rp.c346.id2006248.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public Song(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String a = "*";
        if(stars == 2){
            a = "**";
        }
        else if(stars == 3){
            a = "***";
        }
        else if(stars == 4){
            a = "****";
        }
        else if(stars == 5){
            a = "*****";
        }


        if (title == null && singers == null){
            return Integer.toString(year);
        }
        else{
            return title + '\n' +
                    singers + " - " + year + '\n' +
                    a;
        }


    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
