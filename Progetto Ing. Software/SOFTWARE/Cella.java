//Trambaiollo Luca     1196021
import java.util.Random;
import java.lang.*;
public class Cella
{
    public String frasi[] = {"pianura", "bosco", "montagna"};
    public int ambiente; //0=pianura, 1=bosco, 2=montagna
    public int tempo; //3=giorno, 4=notte
    public int numero; // numero di pedine per ogni cella
    public Pedina cella[]; // La cella è un array di Pedine
    public int riga;
    public int colonna;
    public Cella(int x, int y) // costruttore di cella con max 5 pedine con ambientazione casuale tra pianura/bosco/montagna. Inizialmente è impostata a "giorno"
    {
        riga = x;
        colonna = y;
        Random rand = new Random();
        ambiente = rand.nextInt(frasi.length);
        tempo = 3;
        cella = new Pedina[5];
        numero = 0;

        System.out.println("inizializzata cella    ( "+ x +", " + y + " ;"  );
    }
    //metodo che inserisce le pedina del tipo(elfo/nano/orco) specificato come input nella cella
    public void insert_pedina(String r) throws IllegalArgumentException
    {
        if (numero < cella.length)
        {
            if(r.equals("elfo"))
            {
                cella[numero] = new Elfo();
                numero= numero+1;
                System.out.println("	inserito elfo in ( "+ colonna + "  " + riga + ") ;" );
            }
            else if(r.equals("nano"))
            {
                cella[numero] = new Nano();
                numero = numero+1;
                System.out.println("	inserito nano in ( "+ colonna + "  " + riga + ") ;" );

            }
            else if(r.equals("orco"))
            {
                cella[numero] = new Orco();
                numero = numero+1;
                System.out.println("	inserito orco in ( "+ colonna + "  " + riga + ") ;" );

            }
            else
            {
                throw new IllegalArgumentException("Tipologia di pedina non consentita");

            }
        }
    }
    public String get_riga_colonna() //metodo che restituisce la coordinata x e y di una cella
    {
        return colonna + "  " + riga;
    }
    public int get_ambiente() //metodo che restituisce l'ambiente(pianura, bosco o montagna)
    {
        return ambiente;
    }
    public int get_tempo() //metodo che restituisce il tempo (giorno o notte)
    {
        return tempo;
    }
    public void set_notte() //metodo che imposta il tempo a "notte"
    {
        tempo = 4;
    }
    public void set_giorno() //metodo che imposta il tempo a "giorno"
    {
        tempo = 3;
    }
    public int valore_difesa_giorno() //metodo che ritorna il valore complessivo di difesa di giorno di tutte le pedine presenti nella cella
    {
        int difesa = 0;
        set_giorno();
        if (get_tempo() == 3)
        {
            for(int i = 0; i < numero; i++) {
                cella[i].set_bonus(ambiente);
                cella[i].set_bonus(tempo);
                difesa = difesa + cella[i].get_difesa(); }
        }
        System.out.println("calcolato valore difesa giorno in " + colonna + "  " + riga + "     = " +difesa);
        return difesa;
    }
    public int valore_difesa_notte() //metodo che ritorna il valore complessivo di difesa di notte di tutte le pedine presenti nella cella
    {
        int difesa = 0;
        set_notte();
        if (get_tempo() == 4)
        {
            for(int i = 0; i < numero; i++) {
                cella[i].set_bonus(ambiente);
                cella[i].set_bonus(tempo);
                difesa = difesa + cella[i].get_difesa(); }
        }
        System.out.println("calcolato valore difesa notte in " + colonna + "  " + riga + "     = " +difesa);
        return difesa;
    }
    public int valore_attacco_giorno() //metodo che ritorna il valore complessivo di attacco di giorno di tutte le pedine presenti nella cella
    {
        int attacco = 0;
        set_giorno();
        if (get_tempo() == 3)
        {
            for(int i = 0; i < numero; i++) {
                cella[i].set_bonus(ambiente);
                cella[i].set_bonus(tempo);
                attacco = attacco + cella[i].get_attacco(); }
        }
        System.out.println("calcolato valore attacco giorno in " + colonna + "  " + riga + "     = " +attacco);
        return attacco;
    }
    public int valore_attacco_notte() //metodo che ritorna il valore complessivo di attacco di notte di tutte le pedine presenti nella cella
    {
        int attacco = 0;
        set_notte();
        if (get_tempo() == 4)
        {
            for(int i = 0; i < numero; i++) {
                cella[i].set_bonus(ambiente);
                cella[i].set_bonus(tempo);
                attacco = attacco + cella[i].get_attacco(); }
        }
        System.out.println("calcolato valore attacco notte in " + colonna + "  " + riga + "     = " +attacco);

        return attacco;
    }
    public int numero_elfi() //metodo che ritorna il numero di elfi presenti nella cella
    {
        int numero_elfi = 0;
        for(int i = 0; i < numero; i++)
            if(cella[i].getClass() == Elfo.class)
                numero_elfi = numero_elfi + 1;
        System.out.println("contati " + numero_elfi + "   elfi in   "+ colonna + "  " + riga);

        return numero_elfi;
    }
    public int numero_nani() //metodo che ritorna il numero di nani presenti nella cella
    {
        int numero_nani = 0;
        for(int i = 0; i < numero; i++)
            if(cella[i].getClass() == Nano.class)
                numero_nani = numero_nani + 1;
        System.out.println("contati " + numero_nani + "   nani in   "+ colonna + "  " + riga);
        return numero_nani;
    }
    public int numero_orchi() //metodo che ritorna il numero di orchi presenti nella cella
    {
        int numero_orchi = 0;
        for(int i = 0; i < numero; i++)
            if(cella[i].getClass() == Orco.class)
                numero_orchi = numero_orchi + 1;
        System.out.println("contati " + numero_orchi + "   orchi in   "+ colonna + "  " + riga);
        return numero_orchi;
    }
}
