package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class NewItemDialog extends JDialog {
    private JTextField inputName, inputPrice;
    private MainFrame mainFrame;
    public NewItemDialog(MainFrame mainFrame, String title){
        this.mainFrame = mainFrame;
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initGui();
        pack();
        setVisible(true);
    }

    private void initGui(){
        JPanel panelDialog = new JPanel(new GridLayout(4,2));
        add(panelDialog);   // je jedno zda předávám referenci teď a nebo až po přidání jednotlivých komponent

        panelDialog.add(new JLabel("Název"));
        inputName = new JTextField(15);
        panelDialog.add(inputName);

        panelDialog.add(new JLabel("Cena"));
        inputPrice = new JTextField(15);
        panelDialog.add(inputPrice);

        panelDialog.add(new JLabel("Počet"));
        panelDialog.add(new JTextField(15));

        panelDialog.add(new JPanel());
        JButton btnOk = new JButton("OK");
        panelDialog.add(btnOk);

        btnOk.addActionListener(e -> {
            System.out.println("btn Ok clicked");
            if(!validateInputs()){
                JOptionPane.showMessageDialog(this,
                        "Chyba vstupu",
                        "Chyba",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            //TODO založení položky

            mainFrame.addItemFromDialog();
            // voláme metodu na mainframu a předáme novou položku
            // alternativou by mohlo být vyvolání události na kterou bude reagovat mainframe
            dispose();
        });
    }
    private boolean validateInputs(){
        boolean isOk = true;
        if(inputName.getText().length()<1)
            isOk = false;
        if(inputPrice.getText().length()<1)
            isOk = false;
        //TODO další validace
        return isOk;
    }
}
