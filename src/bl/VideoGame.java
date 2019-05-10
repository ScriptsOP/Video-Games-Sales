package bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VideoGame {

    private BufferedReader br = null;
    private String line = "";
    private String csv_split_by = ",";

    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> platfrom = new ArrayList<>();
    private ArrayList<Integer> year_of_release = new ArrayList<>();
    private ArrayList<String> genre = new ArrayList<>();
    private ArrayList<String> publisber = new ArrayList<>();
    private ArrayList<Double> na_sales = new ArrayList<>();
    private ArrayList<Double> eu_sales = new ArrayList<>();
    private ArrayList<Double> jp_sales = new ArrayList<>();
    private ArrayList<Double> other_sales = new ArrayList<>();
    private ArrayList<Double> global_sales = new ArrayList<>();

    public void readInCSV(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] game = line.split(csv_split_by);
            name.add(game[0]);
            platfrom.add(game[1]);
            try {
                year_of_release.add(Integer.parseInt(game[2]));
            } catch (Exception e) {
            }

            genre.add(game[3]);
            publisber.add(game[4]);
            try {
                na_sales.add(Double.parseDouble(game[5]));
            } catch (Exception e) {
            }
            try {
                eu_sales.add(Double.parseDouble(game[6]));
            } catch (Exception e) {
            }
            try {
                jp_sales.add(Double.parseDouble(game[7]));
            } catch (Exception e) {
            }
            other_sales.add(Double.parseDouble(game[8]));
            try {
                global_sales.add(Double.parseDouble(game[9]));
            } catch (Exception e) {
            }

        }
        br.close();
    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<String> getPlatfrom() {
        return platfrom;
    }

    public ArrayList<Integer> getYear_of_release() {
        return year_of_release;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public ArrayList<String> getPublisber() {
        return publisber;
    }

    public ArrayList<Double> getNa_sales() {
        return na_sales;
    }

    public ArrayList<Double> getEu_sales() {
        return eu_sales;
    }

    public ArrayList<Double> getJp_sales() {
        return jp_sales;
    }

    public ArrayList<Double> getOther_sales() {
        return other_sales;
    }

    public ArrayList<Double> getGlobal_sales() {
        return global_sales;
    }
}
