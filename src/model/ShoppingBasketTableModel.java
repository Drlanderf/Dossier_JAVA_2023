package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ShoppingBasketTableModel extends AbstractTableModel {
    private List<Article> articles;
    private String[] columnNames = {"Nom", "Prix HTVA", "Prix TVAC", "Quantité"};

    public ShoppingBasketTableModel(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public int getRowCount() {
        return articles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Article article = articles.get(row);
        switch (column) {
            case 0:
                return article.getNom();
            case 1:
                return article.getPrixHTVA();
            case 2:
                return article.getPrixTVAC();
            case 3:
                return article.getQuantite();
            default:
                return null;
        }
    }
}
