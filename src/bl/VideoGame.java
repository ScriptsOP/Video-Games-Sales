package bl;

import database.DataBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VideoGame {

    private BufferedReader br = null;
    private String line = "";
    private String csv_split_by = ",";

    private ArrayList<VideoGame> videogames = new ArrayList<>();
    private String name;
    private String platform;
    private int year_of_release;
    private String genre;
    private String publisher;
    private double na_sales;
    private double eu_sales;
    private double jp_sales;
    private double other_sales;
    private double global_sales;

    public VideoGame() {
    }
    
    public VideoGame(String name, String platform, int year_of_release, String genre, String publisher, double na_sales, double eu_sales, double jp_sales, double other_sales, double global_sales) {
        this.name = name;
        this.platform = platform;
        this.year_of_release = year_of_release;
        this.genre = genre;
        this.publisher = publisher;
        this.na_sales = na_sales;
        this.eu_sales = eu_sales;
        this.jp_sales = jp_sales;
        this.other_sales = other_sales;
        this.global_sales = global_sales;
    }
    
    public void readInCSV(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] game = line.split(csv_split_by);
            name = game[0];
            platform = game[1];
            try {
            year_of_release = Integer.parseInt(game[2]);
            } catch (Exception ex) {}
            genre = game[3];
            publisher = game[4];
            try {
            na_sales = Double.parseDouble(game[5]);
            } catch (Exception ex) {}
            try {
            eu_sales = Double.parseDouble(game[6]);
            } catch (Exception ex) {}
            try {
            jp_sales = Double.parseDouble(game[7]);
            } catch (Exception ex) {}
            other_sales = Double.parseDouble(game[8]);
            global_sales = Double.parseDouble(game[9]);
            
            videogames.add(new VideoGame(name, platform, year_of_release, genre, publisher, na_sales, eu_sales, jp_sales, other_sales, global_sales));
        }
        br.close();
    }
    
    public int calcGamesPerYear(int year) {
        int count = 0;
        for (VideoGame videogame : videogames) {
            if(year == videogame.year_of_release)
                count++;
        }
        try {
            DataBase.getInstance().insertYear(year, count);
        } catch (SQLException ex) {
            Logger.getLogger(VideoGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<VideoGame> getVideogames() {
        return videogames;
    }
    
    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public int getYear_of_release() {
        return year_of_release;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getNa_sales() {
        return na_sales;
    }

    public double getEu_sales() {
        return eu_sales;
    }

    public double getJp_sales() {
        return jp_sales;
    }

    public double getOther_sales() {
        return other_sales;
    }

    public double getGlobal_sales() {
        return global_sales;
    }
}
