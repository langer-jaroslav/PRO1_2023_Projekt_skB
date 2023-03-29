package org.example.gui;

import org.example.models.ShoppingListItem;
import org.example.models.ShoppingListTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private List<ShoppingListItem> items;
    public MainFrame(int witdh, int height){
        super("PRO1 2023 Projekt");
        items = new ArrayList<>();
        seedTestData(); // testovací data
        setSize(witdh, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGui();  // volat před setVisible
        initMenu(); // volat před setVisible
        setVisible(true);
    }
    private void initMenu(){
        JMenuBar bar = new JMenuBar();

        JMenu menu1 = new JMenu("Menu 1");
        bar.add(menu1);

        JMenuItem item1 = new JMenuItem("Nová položka");
        item1.addActionListener(e -> {
            System.out.println("Položka 1 v menu 1 clicked");

            NewItemDialog dialog = new NewItemDialog(this,"Zadejte položku");

        });


        JMenuItem item2 = new JMenuItem("Položka 2");
        item2.setEnabled(false);

        menu1.add(item1);
        menu1.add(item2);

        JMenu menu2 = new JMenu("Menu 2");
        bar.add(menu2);

        for (int i = 1; i < 5; i++) {
            menu2.add(new JMenuItem("Položka " + i));
        }

        setJMenuBar(bar);
    }
    private void initGui(){
        System.out.println("init gui");
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(initNorth(), BorderLayout.NORTH);
        mainPanel.add(initCenter(), BorderLayout.CENTER);
        add(mainPanel);
    }
    private JPanel initNorth(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Label 1"));

        JTextField textInput = new JTextField(20);
        JButton btn = new JButton("Button");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");

                System.out.println("Zadáno: " + textInput.getText());

                JOptionPane.showMessageDialog(null,
                        "Zpráva pro uživatele " + textInput.getText(),
                        "Info",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        btn.addActionListener(e -> System.out.println("button clicked 2"));
        btn.addActionListener(e -> {
            System.out.println("button clicked 3");
            // něco dalšího
        });


        panel.add(textInput);
        panel.add(btn);
        return panel;
    }
    private JPanel initCenter(){
        JPanel panel = new JPanel();
        /*Object[][] data = new Object[][]{
                {"0,0", "0,1", "0,2"},
                {"1,0", "1,1", "1,2"},
                {"2,0", "2,1", "2,2"},
        };
        String[] colNames = new String[] {"Col1", "Col2", "Col3"};
        JTable table = new JTable(data, colNames);*/

        ShoppingListTableModel tableModel = new ShoppingListTableModel(items);

        JTable table = new JTable();
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        return panel;
    }

    public void addItemFromDialog(){

    }

    private void seedTestData(){
        items.add(new ShoppingListItem("Máslo", 50d,2));
        items.add(new ShoppingListItem("Chléb", 31.9,1));
        items.add(new ShoppingListItem("Šunka", 22d,3));
        items.add(new ShoppingListItem("Sýr", 27d,1));
    }
}
