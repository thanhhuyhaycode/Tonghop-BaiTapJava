package view;

import model.XmlElement;
import model.XmlHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class XmlGUI extends JFrame {
    private JTextField tagField, valueField;
    private JTable table;
    private DefaultTableModel tableModel;
    private java.util.List<XmlElement> elementList = new ArrayList<>();
    private XmlHandler handler = new XmlHandler();
    private final String FILE_PATH = "data.xml";

    public XmlGUI() {
        setTitle("XML CRUD Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tagField = new JTextField(10);
        valueField = new JTextField(10);

        JButton addBtn = new JButton("Thêm");
        JButton updateBtn = new JButton("Sửa");
        JButton deleteBtn = new JButton("Xoá");
        JButton saveBtn = new JButton("Ghi XML");
        JButton loadBtn = new JButton("Đọc XML");

        tableModel = new DefaultTableModel(new Object[]{"Tag", "Value"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tag:"));
        inputPanel.add(tagField);
        inputPanel.add(new JLabel("Value:"));
        inputPanel.add(valueField);
        inputPanel.add(addBtn);
        inputPanel.add(updateBtn);
        inputPanel.add(deleteBtn);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveBtn);
        bottomPanel.add(loadBtn);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Sự kiện
        addBtn.addActionListener(e -> {
            String tag = tagField.getText().trim();
            String value = valueField.getText().trim();
            if (!tag.isEmpty() && !value.isEmpty()) {
                elementList.add(new XmlElement(tag, value));
                tableModel.addRow(new Object[]{tag, value});
                tagField.setText("");
                valueField.setText("");
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    tagField.setText(tableModel.getValueAt(row, 0).toString());
                    valueField.setText(tableModel.getValueAt(row, 1).toString());
                }
            }
        });

        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String newTag = tagField.getText().trim();
                String newValue = valueField.getText().trim();
                if (!newTag.isEmpty() && !newValue.isEmpty()) {
                    elementList.set(row, new XmlElement(newTag, newValue));
                    tableModel.setValueAt(newTag, row, 0);
                    tableModel.setValueAt(newValue, row, 1);
                }
            }
        });

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                elementList.remove(row);
                tableModel.removeRow(row);
            }
        });

        saveBtn.addActionListener(e -> {
            handler.writeToFile(elementList, FILE_PATH);
            JOptionPane.showMessageDialog(this, "Đã ghi XML!");
        });

        loadBtn.addActionListener(e -> {
            elementList = handler.readFromFile(FILE_PATH);
            tableModel.setRowCount(0);
            for (XmlElement e1 : elementList) {
                tableModel.addRow(new Object[]{e1.getTagName(), e1.getValue()});
            }
            JOptionPane.showMessageDialog(this, "Đã đọc XML!");
        });

        setVisible(true);
    }
}