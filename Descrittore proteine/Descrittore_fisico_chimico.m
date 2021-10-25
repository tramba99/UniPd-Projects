%Questo metodo ha lo scopo di codificare la proteina in un vettore di lunghezza fissa 
%pari a 9, in cui ogni cella rappresenta una diversa proprietà fisico/chimica di tutti gli
%amminoacidi che la compongono.

function out = Descrittore_fisico_chimico(Proteina)


%mat è la matrice che rappresenta le proprietà fisico/chimiche dei vari amminoacidi, 
%in cui le colonne rappresentano, nell'ordine, le proprietà 
%( Hydrophobicity, Hydrophilicity, Rigidity, Flexibility, 
%Irreplaceability, Mass, pI, pK(alpha-COOH), pK(alpha-NH_3^+) ).
%Le righe corrispondono ai 20 amminoacidi in ordine alfabetico.

 mat = [0.62 -0.5 -1.338 -3.102 0.52 15 6.11 2.35 9.87;
	0.29 -1 -1.511 0.957 1.12 47 5.02 1.71 10.78;
	-0.9 3 -0.204 0.424 0.77 59 2.98 1.88 9.6;
	-0.74 3 -0.365 2.009 0.76 73 3.08 2.19 9.67;
	1.19 -2.5 2.877 -0.466 0.86 91 5.91 2.58 9.24;
	0.48 0 -1.097 -2.746 0.56 1 6.06 2.34 9.6;
	-0.4 -0.5 2.269 -0.223 0.94 82 7.64 1.78 8.97;
	1.38 -1.8 -1.741 0.424 0.65 57 6.04 2.32 9.76;
	-1.5 3 -1.822 3.950 0.81 73 9.47 2.2 8.9;
	1.06 -1.8 -1.741 0.424 0.58 57 6.04 2.36 9.6;
	0.64 -1.3 -1.741 2.484 1.25 75 5.74 2.28 9.21;
	-0.78 0.2 -0.204 0.424 0.79 58 10.76 2.18 9.09;
	0.12 0 1.979 -2.404 0.61 42 6.3 1.99 10.6;
	-0.85 0.2 -0.365 2.009 0.86 72 5.65 2.17 9.13;
	-2.53 3 1.169 3.060 0.60 101 10.76 2.18 9.09;
	-0.18 0.3 -1.511 0.957 0.64 31 5.68 2.21 9.15;
	-0.05 -0.4 -1.641 -1.339 0.56 45 5.6 2.15 9.12;
	1.08 -1.5 -1.641 -1.339 0.54 43 6.02 2.29 9.74;
	0.81 -3.4 5.913 -1.000 1.82 130 5.88 2.38 9.39;
	0.26 -2.3 2.714 -0.672 0.98 107 5.63 2.2 9.11];


%Per rappresentare la proteina inizilizzo vettore di 9 elementi 
%corrispondenti alle 9 proprietà fisico/chimiche delgli amminoacidi,
%nel medesimo ordine con cui sono ripotate nella matrice mat 
out = zeros(1,9);


%inizializzazione stringa contenente i 20 amminoacidi che servirà per la ricerca
%degli amminoacidi all'interno della proteina
a = 'ACDEFGHIKLMNPQRSTVWY';


%variabile contenente la lunghezza della proteina in esame
len = length(Proteina);


%cicli per ricerca di ognuno dei 20 amminoacidi in ordine alfabetico
for n = 1:20
	
	%ciclo scansione degli amminoacidi della proteina in esame
	for ammin = 1:length(Proteina)

		%per ogni istanza per cui l'amminoacido n è uguale a quello presente nella Proteina
		%nella posizione ammin 
		if Proteina(ammin) == a(n)

			%per ogni colonna col della matrice mat sommo il valore relativo
			%all'aminoacido n con il valore del vettore out in posizione col
			for col = 1:9
				out(col) = out(col) + mat(n,col);
			end
		end
	end
end