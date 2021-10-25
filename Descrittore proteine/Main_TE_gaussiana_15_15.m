% Main per il "Descrittore distribuzione gaussiana" con iperparametri di 
% media=15 e deviazione standard=15

clear all
warning off

load Phage_TR_VA_TE.mat

media=15;
deviazione=15;

%rappresento vettorialmente ogni proteina:
% prima del training,per settare pesi dell'algoritmo
% poi testare su dati reali
for prot=1:length(Training)
    Proteina=Training{prot};%sequenza amino-acidica
    TrainingSet(prot,:)=Descrittore_distribuzione_gaussiana(Proteina,media,deviazione);%rappresentare proteina in formato vettoriale
end

for prot=1:length(Test)
    Proteina=Test{prot};%sequenza amino-acidica
    TestSet(prot,:)=Descrittore_distribuzione_gaussiana(Proteina,media,deviazione);%rappresentare proteina in formato vettoriale
end

ScoreLocale=PoolSVMnormalizationRID(double(TrainingSet),double(TestSet),double(labelTR'),double(labelTE'));
[a,b]=max(ScoreLocale,[],2);%
sum(b==labelTE')%numero di proteine correttamente classificate