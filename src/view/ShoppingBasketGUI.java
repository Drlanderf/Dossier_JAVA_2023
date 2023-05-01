package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

import model.Article;
import model.ShoppingBasket;

public class ShoppingBasketGUI {
    private JPanel mainFrame;
    private JTable shoppingBasketTable;

    public ShoppingBasketGUI(ShoppingBasket shoppingBasket) {
        // Créer un modèle de table personnalisé pour la JTable
        ShoppingBasketTableModel tableModel = new ShoppingBasketTableModel((ArrayList<Article>) shoppingBasket.getArticles());

        // Attribuer le modèle de table à la JTable
        shoppingBasketTable.setModel(tableModel);

        // Définir les noms de colonne de la table
        shoppingBasketTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Nom");
        shoppingBasketTable.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Prix HTVA");
        shoppingBasketTable.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Quantité");
        shoppingBasketTable.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Total TTC");
/*
        // Ajouter un article par défaut
        Article defaultArticle = new Article("Default article", 10.0, 1,"Dafault Code 128");
        shoppingBasket.ajouterArticle(defaultArticle,1);
        tableModel.fireTableDataChanged();*/
    }

    public JPanel getMainFrame() {
        return mainFrame;
    }

    // Définition du modèle de table personnalisé
    private class ShoppingBasketTableModel extends AbstractTableModel {
        // Définir les noms de colonne
        private String[] columnNames = {"Nom", "Prix HTVA", "Quantité", "Total TTC"};

        // Récupérer les articles du panier
        private ArrayList<Article> articles;

        //Update le tableau
        public void updateTable() {
            fireTableDataChanged();
        }

        public ShoppingBasketTableModel(ArrayList<Article> articles) {
            this.articles = articles;
        }

        @Override
        public int getRowCount() {
            return Math.max(1, articles.size());
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (articles.isEmpty()) {
                return null;
            }
            Article article = articles.get(rowIndex);

            switch (columnIndex) {
                case 0: return article.getNom();
                case 1: return article.getPrixHTVA();
                case 2: return article.getQuantite();
                case 3: return article.getTotal();
                default: return null;
            }
        }
    }
}
