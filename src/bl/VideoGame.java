
package bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VideoGame {
    private BufferedReader br = null;
    private String line = "";
    private String csvSplitBy = ",";
    
    public void readInCSV(File file) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(file));
        
        while ((line = br.readLine()) != null) {
            String[] game = line.split(csvSplitBy);
            System.out.println("game = " + game[0]);
        }
        br.close();
    }
}
