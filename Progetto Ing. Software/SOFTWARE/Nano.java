//Trambaiollo Luca      1196021
public class Nano implements Pedina
{
    public int attacco;
    public int difesa;
    public Nano () // costruttore con valori di default
    {
            attacco = 2;
            difesa = 5;
    }
    public int get_attacco() //metodo che ritorna valore di attacco
    {
        return attacco;
    }
    public int get_difesa() //metodo che ritorna valore di difesa
    {
        return difesa;
    }
    public void set_bonus(int condizione) //metodo che controlla le condizioni ambientali o temporali e se ci sono le giuste condizioni applica il modificatore
    {
        if (condizione == 2)
        {
            attacco = 4;
            difesa = 5;
        }
        else
        {
            attacco = 2;
            difesa = 5;
        }
    }
}
