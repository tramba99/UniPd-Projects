% Questo descrittore non è finalizzato ad una rappresentazione univoca ed
% esatta della disposizione degli amminoacidi nella proteina. Punta invece
% a fornire una descrizione ”soffusa” del posizionamento di questi, tramite il
% calcolo di media, varianza e numero di occorrenze che caratterizzano la
% distribuzione di ognuno dei 20 amminoacidi. In particolare restituisce un
% vettore di lunghezza fissa pari a 60, in cui i primi 20 elementi rappresentano
% la media di ognuno dei 20 amminoacidi, i secondi 20 la varianza e gli
% ultimi 20 le varie occorenze all’interno della proteina.

function vettore=Descrittore_soffuso(pr)
    % stringa contenente la codifica in ordine alfabetico dei 20 amminoacidi:
    alf='ACDEFGHIKLMNPQRSTVWY';
    % inizializzazione dei vettori di media, varianza e numero di occorrenze
    % che verrano poi uniti a formare il vettore di codifica della proteina
    media=zeros(1,20);
    varianza=zeros(1,20);
    occorrenze=zeros(1,20);
    % salvo la lunghezza della sequenza proteica in una variabile in memoria
    lung=(length(pr));
    % eseguo il ciclo per ognuno dei 20 amminoacidi di cui si può
    % costituire la proteina
    for n=1:20
        % inizializzo/svuoto l'arrey "lis" che conterrà le posizioni
        % dell'amminoacido "n" nella proteina
        lis=[];
        % percorro la sequenza proteica
        for am=1:lung
            % se l'amminoacido "am" è del tipo "n" che sto attualmente
            % valutando, salvo la sua posizione nell'arrey "lis"
            if pr(am)==alf(n)
                lis(end+1)=am;
            end
        end
        % calcolo media, varianza e numero di occorrenze per ogni
        % amminoacido "n"
        if length(lis)>0
            media(n)=sum(lis)/length(lis);
            varianza(n)=sum((lis-media(n)).^2)/length(lis);
            occorrenze(n)=length(lis);
        else
            media(n)=0;
            varianza(n)=0;
            occorrenze(n)=0;
        end
    end

% unisco i vettori di media, varianza e occorrenze in un unico vettore
% di lunghezza 60 rappresentativo della proteina
vettore=[media varianza occorrenze];
end     