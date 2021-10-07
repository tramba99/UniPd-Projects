%Trambaiollo Luca 1196021
%VOICE ACTIVE DETECTION Algorithm
%define vad

%pulizia del workspace e cancellazione del command window.
close all; clc;

%dimensione di ogni pacchetto(160 campioni audio)
dim = 160;

%inserimento da input del nome del file
track = input('Inserisci numero traccia dell input: ');
nome_in = strcat("inputaudio", int2str(track), ".data");
nome_out = strcat("outputVAD", int2str(track), ".txt");

%gestione file input/output
fileIDin = fopen(nome_in, 'r');
vect = fread(fileIDin, Inf, 'int8');
fIDout = fopen(nome_out,'w');

%numero totale di campioni audio
L = length(vect);

%calcolo numero totale di pacchetti approssimato al numero intero più vicino
a = (fix(L/dim));

%calcolo energia di ogni pacchetto(normalizzazione)
E = zeros(a,1);
for i=1:a
   for j=1:dim
        E(i) = E(i) + ((vect(j+(i*dim)-dim)/256).^2);
   end
end

%valore di threshold adottato (valore dell'energia della media dei primi 3 pacchetti in
%quanto si assume che non ci sia voce)
threshold = (E(1)+E(2)+E(3));

%creazione array di output (se il valore dell'energia è maggiore del
%threshold si inserisce 1 quindi si assume che sia presente voce,
%altrimenti 0
out = zeros(a,1); 
for k=1:a
    if E(k) > threshold
        out(k) = 1;
    else 
        out(k) = 0;
    end
end

%stampa su file il vettore di output
for s=1:a
    fprintf(fIDout, '%d' , out(s));
end

%chiusura file scrittura
fclose(fIDout);


%creazione del grafico
%creazione array uguale a quello di output solo che ogni valore viene
%replicato per 160 volte così da creare un array lungo L
outampl = zeros(L,1);
z = 1;
for t=1:a
    for q=1:dim
        outampl(z+q) = out(t);
    end
    z = z+160;
end

%creazione della traccia che mostra se è presente o meno la voce
graf = zeros(L, 1);
maxA = max(vect);
for t=1:L
    if outampl(t) == 1
        graf(t) = maxA;
    end
end

%disegno del grafico e della traccia voce/non voce
plot(1:L, vect , 1:L, graf);
xlabel("Time signal");
ylabel("Amplitude");
