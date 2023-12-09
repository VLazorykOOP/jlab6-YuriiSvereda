import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lab1Task3GUI extends JFrame {
    private JPanel panel;
    private JButton readFileButton;
    private JLabel statusLabel;
    private JTable table;

    public Lab1Task3GUI() {
        setTitle("Matrix and Array Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        readFileButton = new JButton("Read File");
        statusLabel = new JLabel("Status: ");
        table = new JTable();

        readFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] matrix = readMatrixFromFile("E:\\university\\java\\jlab6-YuriiSvereda\\src\\inputMatrix.txt");
                    int[] resultArray = Lab1Task3.function(matrix);
                    updateTable(matrix, resultArray);
                    statusLabel.setText("Status: File Read Successfully");
                } catch (IOException ex) {
                    statusLabel.setText("Status: Error reading file");
                    JOptionPane.showMessageDialog(Lab1Task3GUI.this, "Error reading file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Status: Incorrect data format in file");
                    JOptionPane.showMessageDialog(Lab1Task3GUI.this, "Incorrect data format in file: " + ex.getMessage(), "Format Error", JOptionPane.ERROR_MESSAGE);
                } catch (CustomArithmeticException ex) {
                    statusLabel.setText("Status: Custom Exception occurred");
                    JOptionPane.showMessageDialog(Lab1Task3GUI.this, "Custom Arithmetic Exception: " + ex.getMessage(), "Custom Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(readFileButton, BorderLayout.NORTH);
        panel.add(statusLabel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private int[][] readMatrixFromFile(String fileName) throws IOException, NumberFormatException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int size = Integer.parseInt(br.readLine());
        int[][] matrix = new int[size][size];
        int row = 0;
        while ((line = br.readLine()) != null && row < size) {
            String[] values = line.trim().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);
            }
            row++;
        }
        br.close();
        return matrix;
    }

    private void updateTable(int[][] matrix, int[] resultArray) {
        String[] columnNames = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            columnNames[i] = "Row " + (i + 1);
        }
        Object[][] data = new Object[1][resultArray.length];
        for (int i = 0; i < resultArray.length; i++) {
            data[0][i] = resultArray[i];
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}

