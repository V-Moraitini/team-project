package GUI;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUITACreateInterlineReport extends JDialog {
    private JPanel mainPanel;
    private JButton logOutButton;
    private JButton addButton;
    private JButton backButton;
    private JTextField advNametf;
    private JTextField advIDtf;
    private JTextField blankNumtf;
    private JTextField saleAmounttf;
    private JTextField paymentTypetf;
    private JTextField localTaxestf;
    private JTextField otherTaxestf;
    private JTextField comRatetf;
    private JTextField totalAmounttf;
    private JTextField datetf;
    private JLabel datelbl;
    private JTable table1;
    private JButton createBtn;
    private JTextField saleAmount;
    private JTextField localTaxtf;
    private JTextField otherTaxtf;
    private JScrollPane jTabletable;

    public GUITACreateInterlineReport(JFrame parent) {

        super(parent);
        setTitle("Reassign Blank");
        createTable();
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (advNametf.getText().equals("") ||advIDtf.getText().equals("")||blankNumtf.getText().equals("")
                        || saleAmounttf.getText().equals("") || paymentTypetf.getText().equals("")
                        || localTaxestf.getText().equals("")|| otherTaxestf.getText().equals("") || comRatetf.getText().equals("") || totalAmounttf.getText().equals("") || datetf.getText().equals("")) {
                    JOptionPane.showMessageDialog(GUITACreateInterlineReport.this,"Please enter all data!");
                } else{
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{advNametf.getText(),advIDtf.getText(),blankNumtf.getText(),saleAmounttf.getText(),
                            paymentTypetf.getText(),localTaxestf.getText(),otherTaxestf.getText(),comRatetf.getText(), totalAmounttf.getText(), datetf.getText()});
                    JOptionPane.showMessageDialog(GUITACreateInterlineReport.this,"Sale recorded");
                } }
        });


        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                excelSpread();

            }
        });


        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                mainPanel.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITACreateReport(null).setVisible(false);
                mainPanel.setVisible(false);
            }
        });


        setVisible(true);

    }


    private void createTable() {
        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"Advisor Name", "Advisor ID", "Blank Number", "Sale Amount", "Payment Type", "Local Taxes", "Other Taxes", "Commission Rate", "Total Amount", "Date"}


        ));
    }

    public void excelSpread(){
        // Create an ArrayList to store report data
        ArrayList<String[]> data = new ArrayList<String[]>();
        // get the table we made in the form
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        // loop through each row of the table
        for(int i =0; i<model.getRowCount(); i++) {
            //create a new array to store data in each row
            String[] row = new String[model.getColumnCount()];
            //loop through each column
            for (int j = 0; j < model.getColumnCount(); j++) {
                //create a new array to store data in each row
                row[j] = model.getValueAt(i, j).toString();
                //add the value that is in the cell to the row array

            }

            // add the row array to the data ArrayList
            data.add(row);
        }

        //create the workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create the spreadsheet
        XSSFSheet sheet = workbook.createSheet("domReports");

        // Set the header row
        XSSFRow headerRow = sheet.createRow(0);
        for (int k = 0; k < model.getColumnCount(); k++) {
            XSSFCell cell = headerRow.createCell(k);
            cell.setCellValue(model.getColumnName(k));
        }

        // Populate the data rows
        for (int m = 0; m < data.size(); m++) {
            String[] rowData = data.get(m);
            XSSFRow row3 = sheet.createRow(m+ 1);
            for (int o = 0; o < rowData.length; o++) {
                XSSFCell cell = row3.createCell(o);
                cell.setCellValue(rowData[o]);
            }

            //Auto size the columns
            for (int k = 0; k< model.getColumnCount(); k++){
                sheet.autoSizeColumn(k);
            }

        }

        // Write the workbook to a file
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("domReports.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JFileChooser saveFile = new JFileChooser();
        saveFile.setDialogTitle("Save file");
        saveFile.setSelectedFile(new File("DomesticReport.xlsx"));
        if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File output = saveFile.getSelectedFile();
            try (FileOutputStream out = new FileOutputStream(output)) {
                workbook.write(out);

            } catch (IOException ex) {
                Logger.getLogger(GUITACreateInterlineReport.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(GUITACreateInterlineReport.this,"Report created!");
    }




    public static void main(String[] args) {
        GUITACreateInterlineReport panel = new GUITACreateInterlineReport(null);
    }
}

