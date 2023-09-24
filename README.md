Progetto svolto da Elena Ricci per l'esame di Programmazione Avanzata

L’obiettivo del progetto è quello di realizzare una libreria Java che consenta la simulazione di
uno sciame di robot che si muovono nello spazio.
L’implementazione realizzata si basa sul pattern di programmazione MVC, difatti vi sono 3 pacchetti :
- Model (i componenti che presentano gli oggetti principali)
- View (gestisce la comunicazione con l’utente)
- Controllers (qui si trovano la componente che gestisce l’interazione dell’utente con l’area e i vari oggetti)
- Utilities (le classi utili al funzionamento delle classi Model)

Di seguito le responsabilità e le corrispettive classi
•	Creazione e gestione dell’area di gioco
Area (model) : Rappresenta lo spazio dove si muovono i robot ed ha base e altezza prestabilite.
DefaultArea (model) : Implementazione di default dell'interfaccia Area.
ControllerArea (controller) : Controller dell’area, lavora su un unico oggetto di tipo DefaultArea e si occupa principalmente di aggiornarlo a seconda dei movimenti dei robot nell’area.
•	Creazione e gestione dei robot
RobotFactory (model) : Interfaccia che rappresenta un robot. Il robot si trova all'interno di una DefaultArea e ha posizione, velocità, angolo e un id che serve per individuare il robot interessato.
Robot (model): Implementazione di un robot dell'interfaccia RobotFactory.
DefaultArea (model): Si occupa della creazione di un robot, nonché di aggiornare la sua posizione nell’area, tiene traccia dei robot creati nell’area di gioco e permette di recuperarne le informazioni (es. label, id, ecc.).
ControllerArea (controller) : Contiene principalmente l’implementazione dei vari comandi del robot e si preoccupa di aggiornare la sua posizione e le sue informazioni
•	Creazione e gestione delle figure
Shape (model) : Interfaccia che rappresenta una figura (rettangolo/cerchio), ossia una zona delimitata dell’area contrassegnata da una label.
Rectangle (model): Implementazione dell'interfaccia Shape rappresentante un’area rettangolare.
Circle (model): Implementazione dell'interfaccia Shape rappresentante un’area circolare.
DefaultArea (model): Si occupa della creazione e gestione di oggetti di tipo Rectangle e Circle che immagazzina in due ArrayList.
ControllerArea (controller) : E’ in questa classe che vengono effettivamente create le figure (rettangolo/cerchio).
•	Esecuzione
FileManager (view) : Si occupa in generale di gestire i file txt dati in input, li legge e chiama su un oggetto di tipo ControllerArea i metodi necessari a eseguire le richieste scritte nei file, infine genera un file di output con scritto il risultato dell’operazione.
App : Questa classe funge da main del programma, perciò lo manda in esecuzione.

L’app va in esecuzione grazie al metodo run() in FileManager che recupera i file di input e li passa come parametri ai rispettivi metodi addetti alla loro lettura ed esecuzione, infine si occupa di scrivere il risultato dell’operazione in un file di output.
L’esecuzione può essere effettuata anche andando sulla sezione Gradle in alto a dx, cliccando su Tasks>application>run oppure in Run Configurations.
Nella cartella del progetto sono già presenti due file txt, shapes e input, contenenti degli esempi di possibili comandi che il programma può eseguire.
