% Funzione che ricevendo in ingresso la posizione dell'amminoacido
% normalizzata sulla lunghezza della proteina restituisce il valore
% della funzione gaussiana con media = "media" e deviazione standard = "sigma".
function peso=gaussiana(percentuale,media,sigma)
% "percentuale" varia tra 0 e 1, lo si moltiplica per 20 per farlo variare
% tra 0 e 20. Questo non è assolutamente necessario e non influisce nelle
% prestazioni. È stato fatto solo per trovare un buon proporzionamento tra
% media e varianza a livello visivo, da cui partire per trovare
% gli iperparametri ("media" e "sigma") migliori. Lo stesso vale per il
% valore 70 che moltiplica il valore della gaussiana.
perc=percentuale*20;
% calcolo del valore della funzione gaussiana moltiplicato per 70.
peso=((1/sqrt(2*pi*(sigma^2)))*exp(-((perc-media)^2)/(2*(sigma^2))))*70;
end