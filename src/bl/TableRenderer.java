package bl;

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
        //label.setBackground(s.getHairColor());

        switch (column) {
            case 0:
          //      label.setText(s.getFirstname());
                break;
            case 1:
            //    label.setText(s.getLastname());
                break;
            case 2:
              //  label.setText(s.getBirthday().toString());
                break;
            case 3:
                //label.setText("");
                break;
        }

        return label;
    }

}
