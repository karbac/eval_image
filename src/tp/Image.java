/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

/**
 *
 * @author formation_gep
 */
public class Image {

    /**
     * @param args the command line arguments
     */
    // Les images sont représentées par des matrice 5 x 6
    final static int NL = 5;
    final static int NC = 6;
    public static void main(String[] args) {
        // Matrice test
        int[][] M = new int[][] {   {25, 28, 100, 100, 100, 100},
                                    {44, 45, 50, 100, 100, 100},
                                    {65, 65, 50, 20, 100, 100},
                                    {90, 62, 100, 5, 0, 0},
                                    {60, 87, 100, 0, 100, 100}
            
        };
        System.out.print("Inversion des couleurs : ");
        afficher(inverser(M));
        
        System.out.print("Accentuation du contraste : ");
        afficher(accentuer_contraste(M));
        
        System.out.print("Diminution du contraste : ");
        afficher(diminuer_contraste(M));
    }
    
     
    
    public static int[][] inverser(int[][] matrice){
        for(int i = 0 ; i < NL ; i++){
            for(int j = 0 ; j < NC ; j++){
                matrice[i][j] = 100 - matrice[i][j]; // Permet d'inverser la saturation de chaque case
            }
        }
        return matrice;
    }
    
     // Permet d'afficher une matrice dans la console
    public static void afficher(int[][] matrice){
        System.out.println();
        for(int i = 0 ; i < NL ; i++){
            for(int j = 0 ; j < NC ; j++){
                System.out.printf("%d \t" , matrice[i][j]);
            }
            System.out.println();
        }        
    }
    
    public static int[][] accentuer_contraste (int[][] matrice) {
        int sat;
        for(int i = 0 ; i < NL ; i++){
            for(int j = 0 ; j < NC ; j++){
                sat = matrice[i][j];
                if( sat > 75)
                    matrice[i][j] = 100;
                else if (sat <= 50)
                    matrice[i][j] /= 2;
                else
                    matrice[i][j] = 75;
            }
        }
        return matrice;
    }
    
    
    
    public static double moyenne(int[][] matrice){
        int somme = 0;
        for(int i = 0 ; i < NL ; i++){
            for(int j = 0 ; j < NC ; j++){
                somme += matrice[i][j]; // calcul de la somme des saturations
            }
        }
        return (double) somme / (NL * NC); // calcul de la moyenne des saturations
    }
    
    
    public static int[][] diminuer_contraste(int[][] matrice) {        
        double moy = moyenne(matrice); // calcul de la saturation moyenne
        
        // la saturation de chaque case est tirée vers la saturation moyenne
        for(int i = 0 ; i < NL ; i++){
            for(int j = 0 ; j < NC ; j++){
                matrice[i][j] = (int) Math.round( (matrice[i][j] + moy ) / 2);
            }
        }
        return matrice;        
    }
        
    
}
