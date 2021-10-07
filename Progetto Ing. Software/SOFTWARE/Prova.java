// Trambaiollo Luca     1196021
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Prova
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Scanner scan = new Scanner(System.in);
        int numr;
        int numc;
        Mappa mappa;
        System.out.println("BENVENUTO");
        System.out.print("Inserisci il numero di righe: ");
        numr = Integer.parseInt(scan.nextLine());
        System.out.print("Inserisci il numero di colonne: ");
        numc = Integer.parseInt(scan.nextLine());
        if (numr<=0 || numc<=0) {
            System.out.println("Numeri inseriti non validi, i numeri ammessi devono essere interi positivi"); }
        else {
        mappa = new Mappa(numr,numc);
        System.out.println("I CALCOLI: ");
        System.out.println("1) Il numero di pezzi presenti sulla mappa per ciascuna tipologia sono: ");
        System.out.print("Elfi: ");
        System.out.println(mappa.elfi());
        System.out.print("Nani: ");
        System.out.println(mappa.nani());
        System.out.print("Orchi: ");
        System.out.println(mappa.orchi());
        System.out.print("2) La casella con il maggior valore di difesa di giorno e' quella con le coordinate x,y: ");
        System.out.println(mappa.max_valore_difesa_giorno());
        System.out.print("3) La casella con il maggior valore di difesa di notte e' quella con le coordinate x,y: ");
        System.out.println(mappa.max_valore_difesa_notte());
        System.out.print("4) La casella con il maggior valore di attacco di giorno e' quella con le coordinate x,y: ");
        System.out.println(mappa.max_valore_attacco_giorno());
        System.out.print("5) La casella con il maggior valore di attacco di notte e' quella con le coordinate x,y: ");
        System.out.println(mappa.max_valore_attacco_notte());
        System.out.print("6) La casella con il maggior numero di pezzi dello stesso tipo e' quella con le coordinate x,y: ");
        System.out.println(mappa.max_numero_pezzi_stesso_tipo()); }
    }
}
