package org.example.models;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ShoppingListTableModel extends AbstractTableModel {
    private List<ShoppingListItem> items;
    public ShoppingListTableModel(List<ShoppingListItem> items) {
        this.items = items;
    }
    @Override
    public int getRowCount() {
        return items.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0)
            return items.get(rowIndex).getName();
        if(columnIndex==1)
            return items.get(rowIndex).getPrice();
        if(columnIndex==2)
            return items.get(rowIndex).getPieces();
        if(columnIndex==3)
            return (rowIndex%2==1?true:false);
        return "N/A";
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)
            return "Název";
        if(column == 1)
            return "Cena";
        if(column == 2)
            return "Počet";
        return super.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==3)
            return Boolean.class;
        return super.getColumnClass(columnIndex);
    }
}
