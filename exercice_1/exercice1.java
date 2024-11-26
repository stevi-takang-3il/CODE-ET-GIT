public class FactureManager {

    // Calcul le total d'une facture
    public double calculerFacture(String typeProduit, int quantite, double prixUnitaire) {
        //Total avant reduction
        double total = totalAvantReduction(quantite, prixUnitaire);

        // Reduction sur le type
        total = totalParProduit(typeProduit, quantite, prixUnitaire);

        // Reduction sur le total
        total = appliquerReduction(total, reductionByTotal(total));

        return total;
    }


   // Méthode pour calculer le total avant réduction
    public double totalAvantReduction(int quantite, double prixUnitaire) {
        return quantite * prixUnitaire;
    }

    // Méthode pour appliquer une réduction sur le montant total
    public double appliquerReduction(double total, double reduction) {
        return total - (total * reduction);  // Applique la réduction en pourcentage
    }


    // Méthode pour calculer le total après réduction en fonction du type de produit
    public double totalParProduit(String typeProduit, int quantite, double prixUnitaire) {
        double total = totalAvantReduction(quantite, prixUnitaire);  // Calcul du total sans réduction

        switch (typeProduit) {
            case "Alimentaire":
                total = appliquerReduction(total, 0.05);  // Applique une réduction de 5%
                break;
            case "Electronique":
                total = appliquerReduction(total, 0.10);  // Applique une réduction de 10%
                break;
            case "Luxe":
                total = appliquerReduction(total, 0.15);  // Applique une réduction de 15%
                break;
            default:
                // Aucun type de produit correspondant, aucune réduction
                break;
        }

        return total;  // Retourne le total après réduction
    }

    public double reductionByTotal(double total) {
        return total > 1000 ? total * 0.05 : total ;
    }

}


/*public class FactureManager {

    // Méthode principale pour calculer le total d'une facture après toutes les réductions
    public double calculerFacture(String typeProduit, int quantite, double prixUnitaire) {
        double total = quantite * prixUnitaire;  // Calcul du montant initial sans réduction
        
        // Réduction sur le total si le montant dépasse 1000
        if (total > 1000) {
            total -= total * 0.05; // Réduction de 5% pour les gros montants
        }

        // Réduction spécifique selon le type de produit
        switch (typeProduit) {
            case "Alimentaire":
                total -= total * 0.05; // Réduction de 5% pour les produits alimentaires
                break;
            case "Electronique":
                total -= total * 0.10; // Réduction de 10% pour les produits électroniques
                break;
            case "Luxe":
                total -= total * 0.15; // Réduction de 15% pour les produits de luxe
                break;
            default:
                // Aucun type de produit correspondant, aucune réduction supplémentaire
                break;
        }

        return total;  // Retourne le total après toutes les réductions
    }

    // Méthode pour calculer le total avant réduction
    public double totalAvantReduction(int quantite, double prixUnitaire) {
        return quantite * prixUnitaire;
    }

    // Méthode pour appliquer une réduction sur le montant total
    public double appliquerReduction(double total, double reduction) {
        return total - (total * reduction);  // Applique la réduction en pourcentage
    }

    // Méthode pour calculer le total après réduction en fonction du type de produit
    public double totalParProduit(String typeProduit, int quantite, double prixUnitaire) {
        double total = totalAvantReduction(quantite, prixUnitaire);  // Calcul du total sans réduction

        switch (typeProduit) {
            case "Alimentaire":
                total = appliquerReduction(total, 0.05);  // Applique une réduction de 5%
                break;
            case "Electronique":
                total = appliquerReduction(total, 0.10);  // Applique une réduction de 10%
                break;
            case "Luxe":
                total = appliquerReduction(total, 0.15);  // Applique une réduction de 15%
                break;
            default:
                // Aucun type de produit correspondant, aucune réduction
                break;
        }

        return total;  // Retourne le total après réduction
    }
}

 */