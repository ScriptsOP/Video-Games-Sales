package bl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        VideoGame s = (VideoGame) value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.RED);

        switch (column) {
            case 0:
                label.setText("test");
                break;
            case 1:
                label.setText("test");
                break;
            case 2:
                label.setText("test");
                break;
            case 3:
                label.setText("test");
                break;
        }

        return label;
    }

}
