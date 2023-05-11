package controler;

import model.Article;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArticleControle {
    private HashMap<String, Article> articles = new HashMap<>();

    /**
     * @ordre_du_csv : Code barre,Nom,Prix HTVA,Quantite
     * @param filename
     */
    public ArticleControle(String filename) {
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String codeBarre = fields[0];
                String nom = fields[1];
                double prixHTVA = Double.parseDouble(fields[2]);
                int quantite = Integer.parseInt(fields[3]);
                Article article = new Article(codeBarre, nom, prixHTVA, quantite);
                articles.put(codeBarre, article);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("[ArticleControle]  Erreur ! Fichier non trouve... "+e);
        }
        catch (IOException e){
            System.out.println("[ArticleControle] Erreur d'IO : "+e);
        } catch (Exception e){
            System.out.println("[ArticleControle] Erreur : "+e);
        }
    }

    public Article findArticleByCodeBarre(String codeBarre) {
        return articles.get(codeBarre);
    }
    public void afficherArticles() {
        for (Map.Entry<String, Article> entry : articles.entrySet()) {
            System.out.println("Code barre: " + entry.getKey());
            Article article = entry.getValue();
            System.out.println("Nom: " + article.getNom());
            System.out.println("Prix HTVA: " + article.getPrixHTVA());
            System.out.println("Prix TVAC: " + article.getPrixTVAC());
            System.out.println("Quantité: " + article.getQuantite());
            System.out.println("----------------------------");
        }
    }


}
