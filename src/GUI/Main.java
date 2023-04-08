package GUI;

import javax.swing.table.DefaultTableModel;

public class Main {

    public static void main(String[] args) {
        GUILogin login = new GUILogin(null);
        DefaultTableModel model = new DefaultTableModel(
                null,
                new String [] {"Blank ID", "Quantity", "Blank Type"}
        );

    }
    }

