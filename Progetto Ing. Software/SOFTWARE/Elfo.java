//Trambaiollo Luca    1196021
public class Elfo implements Pedina
{
    public int attacco;
    public int difesa;

    public Elfo () // costruttore con valori di default
    {
        attacco = 5;
        difesa = 2;
    }
    public int get_attacco() //metodo che ritorna valore di attacco
    {
        return difesa;
    }
    public int get_difesa() //metodo che ritorna valore di difesa
    {
        return attacco;
    }
    public void set_bonus(int condizione) //metodo che controlla le condizioni ambientali o temporali e se ci sono le condizioni applica il modificatore
    {
        if (condizione == 1)
        {
            attacco = 5;
            difesa = 4;
        }
        else
        {
            attacco = 5;
            difesa = 2;
        }
    }
}
