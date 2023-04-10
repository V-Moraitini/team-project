package GUI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUITACreateDomReport extends JDialog{
    private JPanel panel1;
    private JButton backButton;
    private JButton createButton;
    private JButton logOutButton;
    private JTextField advisorNametf;
    private JTextField advisorIDtf;
    private JTextField blankNumbertf;
    private JTextField paymentTypetf;
    private JTextField saleAmounttf;
    private JTextField taxestf;
    private JTextField tAmounttf;
    private JButton addButton;
    private JTable table1;

    public GUITACreateDomReport(JFrame parent) {

        super(parent);
        setTitle("Create Individual Domestic Report");
        createTable();
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUITravelAdvisor(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUILogin(null).setVisible(false);
                panel1.setVisible(false);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (advisorNametf.getText().equals("") ||advisorIDtf.getText().equals("")||blankNumbertf.getText().equals("")
                        || saleAmounttf.getText().equals("") || paymentTypetf.getText().equals("")
                        || taxestf.getText().equals("")|| tAmounttf.getText().equals("")) {
                    JOptionPane.showMessageDialog(GUITACreateDomReport.this,"Please enter all data!");
                } else{
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{advisorNametf.getText(),advisorIDtf.getText(),blankNumbertf.getText(),saleAmounttf.getText(),
                            paymentTypetf.getText(),taxestf.getText(),tAmounttf.getText()});
                    JOptionPane.showMessageDialog(GUITACreateDomReport.this,"Sale recorded");
                } }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    excelSpread();

            }
        });

        setVisible(true);

    }

    private void createTable() {
        table1.setModel(new DefaultTableModel(
                null,
                new String[]{"Advisor Name", "Advisor ID", "Blank Number", "Sale Amount", "Payment Type", "Taxes", "Total Amount"}


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
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GUITACreateDomReport.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                JOptionPane.showMessageDialog(GUITACreateDomReport.this,"Report created!");
            }









    public static void main(String[] args) {
        GUITACreateDomReport login = new GUITACreateDomReport(null);


    }
}

