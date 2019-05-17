package bl;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableRenderer implements TableCellRenderer {

    /**
     * Sets the name for the columns.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        VideoGame vg = (VideoGame) value;
        JLabel label = new JLabel();
        label.setOpaque(true);

        switch (column) {
            case 0:
                label.setText(vg.getName());
                break;
            case 1:
                label.setText(vg.getPlatform());
                break;
            case 2:
                label.setText(vg.getYear_of_release() + "");
                break;
            case 3:
                label.setText(vg.getGenre());
                break;
        }

        return label;
    }

}
