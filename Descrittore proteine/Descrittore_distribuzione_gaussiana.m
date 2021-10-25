% Questo descrittore è sviluppato a partire dal metodo “Amino-Acid 
% Composition (AS)” illustrato in “An Empirical Study of Different 
% Approaches for Protein Classification” (Nanni L., Lumini A., Brahnam S., 2014).
% Si è pensato di modificare quest’ultimo in modo che tenga conto anche
% della disposizione degli amminoacidi all’interno della sequenza proteica.
% Come primo approccio, si è fatto ciò sommando le posizioni all’interno
% della proteina per ognuno dei 20 amminoacidi invece di contare le sole
% occorrenze. Questo però lascia ancora un’ importante incertezza sulla
% disposizione univoca degli amminoacidi all’interno della proteina, in
% quanto differenti combinazioni di posizione possono dare lo stesso 
% risultato di somma. Si è cercato quindi di contrastare questo fenomeno
% sommando il valore di una funzione esponenziale, di variabile la posizione
% dell’amminoacido nella sequenza proteica, invece che la sola posizione.
% In conclusione si è preferito adottare una curva gaussiana al posto di una
% funzione esponenziale, avendo osservato che le prestazioni erano migliori
% e che si evitava l’esplosione numerica conseguente all’utilizzo di una
% funzione esponeziale. La funzione gaussiana è in funzione della posizione
% dell’amminoacido, normalizzata sulla lunghezza della proteina
% (posizione/lunghezza proteina). Si ha quindi in uscita un vettore di 
% lunghezza 20, dove ogni elemento è la somma dei valori della gaussiana per
% un dato amminoacido.


function som=Descrittore_distribuzione_gaussiana(pr,media,sigma)
    % stringa contenente la codifica in ordine alfabetico dei 20 amminoacidi:
    alf='ACDEFGHIKLMNPQRSTVWY';
    % inizializzazione del vettore di codifica della proteina
    som=zeros(1,20);
    % salvo la lunghezza della sequenza proteica in una variabile in memoria.
    lung=(length(pr));
    % eseguo il ciclo per ognuno dei 20 amminoacidi di cui si può
    % costituire la proteina
    for n=1:20
        % percorro la sequenza proteica
        for am=1:lung
            % se l'amminoacido "am" è del tipo "n" che sto attualmente
            % valutando, addiziono il valore della funzione "gaussiana"
            % (corrispondente alla posizione "am") moltiplicato per la
            % lunghezza della proteina alla somma di valori dell'amminoacido "n".
            if pr(am)==alf(n)
                som(n)=som(n)+ gaussiana(am/lung,media,sigma)*lung;
            end
        end
    end
end