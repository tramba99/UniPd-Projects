// Trambaiollo Luca    1196021
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Mappa
{
    Cella mappa[][]; // la mappa è una matrice di Celle
    int M;
    int N;
    // costruttore della mappa(MxN) con lettore del file di testo "disposizione_pedine.txt"   
    public Mappa(int numr,int numc) throws FileNotFoundException, IOException
    {
        M = numr;
        N = numc;
        mappa = new Cella[M][N];
        for (int i = 0; i < M;i++ )
            for (int j = 0; j < N; j++)
                mappa[i][j] = new Cella(i,j);
        BufferedReader in = new BufferedReader (new FileReader("disposizione_pedine.txt"));
        String next = in.readLine();
        int numeroCelleRiempite = 0;
        while (next != null)
        {
        	System.out.println("***********************FILE*********************");
            int colonna = Integer.parseInt(next);
            int riga = Integer.parseInt(in.readLine());
            String tipo = in.readLine();
            mappa[riga][colonna].insert_pedina(tipo);
            System.out.println(colonna);
            System.out.println(riga);
            System.out.println(tipo);

            numeroCelleRiempite ++;
            next = in.readLine();
        }
        System.out.println(numeroCelleRiempite);

        in.close();
    }
    public int elfi() //metodo che restituisce il numero di elfi presenti sulla mappa
    {
        int elfi = 0;
        for(int i=0; i < M; i++)
            for (int j=0; j < N; j++)
                elfi = elfi + mappa[i][j].numero_elfi();
        return elfi;
    }
    public int nani() //metodo che restituisce il numero di nani presenti sulla mappa
    {
        int nani = 0;
        for(int i=0; i < M; i++)
            for (int j=0; j < N; j++)
                nani = nani + mappa[i][j].numero_nani();
        return nani;
    }
    public int orchi() //metodo che restituisce il numero di orchi presenti sulla mappa
    {
        int orchi = 0;
        for(int i=0; i < M; i++)
            for (int j=0; j < N; j++)
                orchi = orchi + mappa[i][j].numero_orchi();
        return orchi;
    }
    public String max_valore_difesa_giorno() //metodo che restituisce le coordinate x,y della cella con il maggior valore di difesa di giorno (nel caso ce ne sia più di una restituisce la prima trovata)
    {
	    int max = mappa[0][0].valore_difesa_giorno();
        int riga = 0;
        int colonna = 0;
		for(int i=0; i < M; i++)
            {
                for (int j=0; j < N; j++)
		              {
			                  if (max < mappa[i][j].valore_difesa_giorno())
                              {
                                  max = mappa[i][j].valore_difesa_giorno();
                                  riga = i;
                                  colonna = j;
			                  }
		              }
            }
         return mappa[riga][colonna].get_riga_colonna();
    }
    public String max_valore_difesa_notte() //metodo che restituisce le coordinate x,y della cella con il maggior valore di difesa di notte (nel caso ce ne sia più di una restituisce la prima trovata)
    {
        int max = mappa[0][0].valore_difesa_notte();
        int riga= 0;
        int colonna= 0;
		for(int i=0; i < M; i++)
            {
                for (int j=0; j < N; j++)
		              {
			                  if (max < mappa[i][j].valore_difesa_notte())
                              {
                                  max = mappa[i][j].valore_difesa_notte();
                                  riga = i;
                                  colonna = j;
			                  }
		              }
            }
         return mappa[riga][colonna].get_riga_colonna();
    }
    public String max_valore_attacco_giorno() //metodo che restituisce le coordinate x,y della cella con il maggior valore di attacco di giorno (nel caso ce ne sia più di una restituisce la prima trovata)
    {
        int max = mappa[0][0].valore_attacco_giorno();
        int riga = 0;
        int colonna=0;
		for(int i=0; i < M; i++)
            {
                for (int j=0; j < N; j++)
		              {
			                  if (max < mappa[i][j].valore_attacco_giorno())
                              {
                                  max = mappa[i][j].valore_attacco_giorno();
                                  riga = i;
                                  colonna = j;
			                  }
		              }
            }
         return mappa[riga][colonna].get_riga_colonna();
    }
    public String max_valore_attacco_notte() //metodo che restituisce le coordinate x,y della cella con il maggior valore di attacco di notte (nel caso ce ne sia più di una restituisce la prima trovata)
    {
        int max = mappa[0][0].valore_attacco_notte();
        int riga= 0;
        int colonna =0;
		for(int i=0; i < M; i++)
            {
                for (int j=0; j < N; j++)
		              {
			                  if (max < mappa[i][j].valore_attacco_notte())
                              {
                                  max = mappa[i][j].valore_attacco_notte();
                                  riga = i;
                                  colonna = j;
			                  }
		              }
            }
         return mappa[riga][colonna].get_riga_colonna();
    }
    public String max_numero_pezzi_stesso_tipo() // metodo che restituisce le coordinate x,y della cella con il maggior numero di pedine dello stesso tipo (nel caso ce ne sia più di una restituisce la prima trovata)
    {
        int numero_stesso_tipo_max = 0;
        int numero_elfi = 0;
        int numero_nani = 0;
        int numero_orchi = 0;
        int riga = 0;
        int colonna = 0;
        for(int i=0; i < mappa.length; i++)
            {
                for (int j=0; j < mappa[i].length; j++)
                {
                    numero_elfi = mappa[i][j].numero_elfi();
                    numero_nani = mappa[i][j].numero_nani();
                    numero_orchi = mappa[i][j].numero_orchi();
                    if (numero_elfi > numero_nani && numero_elfi > numero_orchi && numero_elfi > numero_stesso_tipo_max)
                    {
                        numero_stesso_tipo_max = numero_elfi;
                        riga = i;
                        colonna = j;
                    }
                    else if (numero_nani > numero_elfi && numero_nani > numero_orchi && numero_nani > numero_stesso_tipo_max)
                    {
                        numero_stesso_tipo_max = numero_nani;
                        riga = i;
                        colonna = j;
                    }
                    else if(numero_orchi > numero_elfi && numero_orchi > numero_nani && numero_orchi > numero_stesso_tipo_max)
                    {
                        numero_stesso_tipo_max = numero_orchi;
                        riga = i;
                        colonna = j;
                    }
                }
            }
        return mappa[riga][colonna].get_riga_colonna();
    }
}
