package bl;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private static String[] colNames = {"Name", "Publisher"};
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
        switch(colIdx){
            case 0: return "test";
            case 1: return "test";
            case 2: return "test";
            case 3: return "test";
            default: return "???";
        }
    }

}
