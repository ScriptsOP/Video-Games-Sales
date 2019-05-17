package bl;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private static String[] colNames = {"Name", "Publisher", "Year of Release", "Genre"};
    private ArrayList<VideoGame> vgames = new ArrayList<>();

    public void add(VideoGame vg) {
        vgames.add(vg);
        fireTableRowsInserted(vgames.size() - 1, vgames.size() - 1);
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];

    }

    @Override
    public int getRowCount() {
        return vgames.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIdx, int colIdx) {
        VideoGame vg = vgames.get(rowIdx);
        return vg;
    }

    public VideoGame getMostSoldGame() {
        VideoGame game = vgames.get(0);
        for (VideoGame vgame : vgames) {
            if (vgame.getGlobal_sales() > game.getGlobal_sales()) {
                game = vgame;
            }
        }
        return game;
    }
    
    public int getReleasedGames(int year) {
        int sum = 0;
        for (VideoGame vgame : vgames) {
            if(vgame.getYear_of_release() == year) {
                sum++;
            }
        }
        return sum;
    }
}
