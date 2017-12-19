# Versione-1

Si desidera realizzare, secondo un processo di sviluppo incrementale/iterativo,
un’applicazione software che consenta di gestire un servizio di archiviazione e prestito di
risorse multimediali appartenenti a diverse categorie.
L’applicazione prevede due tipologie di utenti: il fruitore, che chiede risorse in prestito,
e l’operatore, che mantiene e interroga l’archivio.

Un cittadino maggiorenne, per divenire fruitore dei servizi di prestito temporaneo, deve
avanzare una richiesta interagendo con l’applicazione software. Tale richiesta determina
l’attribuzione dello status di fruitore a partire dalla data di iscrizione del cittadino
all’elenco dei fruitori fino alla data di scadenza, fissata esattamente 5 anni dopo quella di
iscrizione. Lo status di fruitore può essere rinnovato, ogni volta per 5 anni, un numero
indefinito di volte purché l’interessato richieda il rinnovo entro la data di scadenza e non
prima dei 10 giorni precedenti la data della scadenza stessa. La mancata richiesta di
rinnovo nei termini prescritti comporta la decadenza dallo status di fruitore. Un fruitore
decaduto può comunque effettuare una nuova richiesta di iscrizione.
La prima versione dell’applicazione è focalizzata sulle funzionalità per la gestione di una
minimale “anagrafica fruitori” elencate di seguito, che non prevedono alcun intervento
da parte dell’operatore:
* iscrizione di un nuovo fruitore;
* decadenza (automatica) di un fruitore che non ha chiesto il rinnovo nei termini
prescritti;
* rinnovo dell’iscrizione di un fruitore che ne ha fatto richiesta nei termini prescritti.
Inoltre la prima versione dell’applicazione deve consentire all’operatore di visualizzare
l’elenco degli attuali fruitori.
