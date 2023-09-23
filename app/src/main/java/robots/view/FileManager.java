package robots.view;

/**
 * La classe FileManager gestisce l'elaborazione di comandi da file di input, l'invocazione di metodi
 * sulle aree(cerchio/rettangolo) attraverso l'oggetto ControllerArea e la scrittura dei risultati su file di output.
 * È progettata per leggere comandi da due file specifici, uno contenente istruzioni per la creazione di aree
 * (shapesFile) e l'altro per comandi su robot (commandsFile).
 */

import robots.controllers.ControllerArea;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileManager {

    /**
     * L'oggetto ControllerArea è utilizzato per gestire e monitorare le forme geometriche e i robot.
     */
    static ControllerArea controllerArea = new ControllerArea();

    /**
     * Esegue il processo di elaborazione dei comandi dai file di input, l'invocazione dei metodi sulle forme geometriche
     * e la scrittura dei risultati su un file di output.
     */
    public void run() throws IOException {
        // Percorsi dei file di input e output
        Path shapesFile = Paths.get("D:\\UNICAM\\PA\\RicciElena114995\\shapes.txt");
        Path commandsFile = Paths.get("D:\\UNICAM\\PA\\RicciElena114995\\input.txt");

        // StringBuilder per contenere l'output
        StringBuilder outputContent = new StringBuilder();

        // Elabora le istruzioni per le aree
        processInstructionsShapesFile(controllerArea, shapesFile, outputContent);
        // Elabora i comandi sui robot
        processInstructionsCMDFile(controllerArea, commandsFile, outputContent);

        // Scrive l'output su un file
        writeOutputToFile("output.txt", outputContent.toString());
    }

    /**
     * Questo metodo elabora le istruzioni per la creazione di aree contenute in un file specifico.
     * Le istruzioni vengono lette dal file, i parametri vengono estratti e passati al ControllerArea per
     * la creazione delle forme. Inoltre, viene generato un output che descrive le operazioni svolte.
     *
     * @param controllerArea  L'oggetto ControllerArea utilizzato per gestire le aree.
     * @param file            Il percorso del file contenente le istruzioni per le aree.
     * @param outputContent   Il StringBuilder utilizzato per accumulare l'output delle operazioni.
     */
    private static void processInstructionsShapesFile(ControllerArea controllerArea, Path file, StringBuilder outputContent) {

        try {
            // Legge le linee dal file e itera su ciascuna di esse
            Files.lines(file).forEach(line -> {
                // Suddivide la linea in parti utilizzando uno spazio come delimitatore
                String[] parts = line.split(" ");
                // Estrae il tipo di forma (CIRCLE/RECTANGLE) dalla seconda parte
                String shape = parts[1];
                // Crea un array di oggetti per memorizzare i parametri
                Object[] parameters = new Object[parts.length];

                // Assegna il primo elemento dell'array dei parametri (comando) dalla prima parte
                parameters[0] = parts[0];

                for (int i = 1; i < parts.length; i++) {
                    // Verifica se la parte corrente può essere convertita in un numero intero
                    if (isInteger(parts[i])) {
                        // Se sì, converte la parte in un intero e la memorizza nell'array dei parametri
                        parameters[i] = Integer.parseInt(parts[i]);
                        // Altrimenti, verifica se può essere convertita in un numero decimale (double)
                    } else if (isDouble(parts[i])) {
                        // Se sì, converte la parte in un double e la memorizza nell'array dei parametri
                        parameters[i] = Double.parseDouble(parts[i]);
                        // Se non può essere convertita in un numero, la memorizza direttamente
                        // nell'array dei parametri come una stringa
                    } else {
                        parameters[i] = parts[i];
                    }
                }
                /*ogni case genera un'area utilizzando i parametri specificati,
                *crea una stringa di output per indicare che è stata creata un'area,
                *stampa la stringa di output sulla console e
                *aggiunge la stringa di output al contenuto dell'output
                 */
                switch (shape) {
                    case "CIRCLE":
                        controllerArea.generateCircle(parameters);
                        String circleOutput = "New area: " + Arrays.toString(parameters);
                        System.out.println(circleOutput);
                        outputContent.append(circleOutput + "\n");
                        break;
                    case "RECTANGLE":
                        controllerArea.generateRectangle(parameters);
                        String rectangleOutput = "New area: " + Arrays.toString(parameters);
                        System.out.println(rectangleOutput);
                        outputContent.append(rectangleOutput + "\n");
                        break;
                    default:
                        // Se il tipo di area è sconosciuto, crea una stringa di errore
                        String errorOutput = "Unknown command: " + shape;
                        // Stampa la stringa di errore sulla console
                        System.out.println(errorOutput);
                        // Aggiunge la stringa di errore al contenuto dell'output
                        outputContent.append(errorOutput + "\n");
                        break;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Questo metodo elabora i comandi relativi ai robot contenuti in un file specifico.
     * I comandi vengono letti dal file, i parametri vengono estratti e passati al ControllerArea per
     * eseguire le operazioni sui robot. Inoltre, viene generato un output che descrive le operazioni svolte.
     *
     * @param controllerArea  L'oggetto ControllerArea utilizzato per gestire i robot.
     * @param file            Il percorso del file contenente i comandi sui robot.
     * @param outputContent   Il StringBuilder utilizzato per accumulare l'output delle operazioni.
     */
    private static void processInstructionsCMDFile(ControllerArea controllerArea, Path file, StringBuilder outputContent) {

        try {
            // Legge le linee dal file e itera su ciascuna di esse
            Files.lines(file).forEach(line -> {
                // Suddivide la linea in parti utilizzando uno spazio come delimitatore
                String[] parts = line.split(" ");
                // Estrae il comando dalla prima parte della linea
                String command = parts[0];
                // Crea un array di oggetti per memorizzare i parametri (escludendo il comando)
                Object[] parameters = new Object[parts.length - 1];

                // Itera attraverso le restanti parti della linea
                for (int i = 1; i < parts.length; i++) {
                    // Verifica se la parte corrente può essere convertita in un numero intero
                    if (isInteger(parts[i])) {
                        // Se sì, converte la parte in un intero e la memorizza nell'array dei parametri
                        parameters[i - 1] = Integer.parseInt(parts[i]);
                    }
                    // Altrimenti, verifica se può essere convertita in un numero decimale (double)
                    else if (isDouble(parts[i])) {
                        // Se sì, converte la parte in un double e la memorizza nell'array dei parametri
                        parameters[i - 1] = Double.parseDouble(parts[i]);
                    }
                    // Se non può essere convertita in un numero, la memorizza direttamente nell'array dei parametri come una stringa
                    else {
                        parameters[i - 1] = parts[i];
                    }
                }

                /*ogni case esegue un comando utilizzando i parametri specificati,
                 *crea una stringa di output per indicare che l'esecuzione è avvenuta,
                 *stampa la stringa di output sulla console e
                 *aggiunge la stringa di output al contenuto dell'output
                 */
                switch (command) {
                    case "MOVE":
                        controllerArea.move(parameters);
                        String moveOutput = "Moving robot with parameters: " + Arrays.toString(parameters);
                        System.out.println(moveOutput);
                        outputContent.append(moveOutput + "\n");
                        break;
                    case "MOVE_RANDOM":
                        controllerArea.moveRandom(parameters);
                        String moveRandomOutput = "Moving robot with parameters: " + Arrays.toString(parameters);
                        System.out.println(moveRandomOutput);
                        outputContent.append(moveRandomOutput + "\n");
                        break;
                    case "SIGNAL":
                        controllerArea.signal(parameters);
                        String signalOutput = "Robot's id and current label: " + Arrays.toString(parameters);
                        System.out.println(signalOutput);
                        outputContent.append(signalOutput + "\n");
                        break;
                    case "UNSIGNAL":
                        controllerArea.unsignal(parameters);
                        String unsignalOutput = "Robot's id and deprecated label: " + Arrays.toString(parameters);
                        System.out.println(unsignalOutput);
                        outputContent.append(unsignalOutput + "\n");
                        break;
                    case "FOLLOW":
                        controllerArea.follow(parameters);
                        String followOutput = "Robot is following others based on parameters: " + Arrays.toString(parameters);
                        System.out.println(followOutput);
                        outputContent.append(followOutput + "\n");
                        break;
                    case "CONTINUE":
                        controllerArea.continuecmd(parameters);
                        String continueOutput = "Robot keeps moving with parameters: " + Arrays.toString(parameters);
                        System.out.println(continueOutput);
                        outputContent.append(continueOutput + "\n");
                        break;
                    case "STOP":
                        controllerArea.stop(parameters);
                        String stopOutput = "This robot stopped moving: " + Arrays.toString(parameters);
                        System.out.println(stopOutput);
                        outputContent.append(stopOutput + "\n");
                        break;
                    default:
                        // Se il comando è sconosciuto, crea una stringa di errore
                        String errorOutput = "Unknown command: " + command;
                        // Stampa la stringa di errore sulla console
                        System.out.println(errorOutput);
                        // Aggiunge la stringa di errore al contenuto dell'output
                        outputContent.append(errorOutput + "\n");
                        break;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se una stringa può essere convertita in un numero intero.
     *
     * @param input La stringa da verificare.
     * @return True se la stringa può essere convertita in un numero intero, altrimenti False.
     */
    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica se una stringa può essere convertita in un numero decimale (double).
     *
     * @param input La stringa da verificare.
     * @return True se la stringa può essere convertita in un numero decimale (double), altrimenti False.
     */
    private static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Scrive il contenuto specificato su un file con il nome specificato.
     *
     * @param filename Il nome del file in cui scrivere il contenuto.
     * @param content  Il contenuto da scrivere sul file.
     */
    private static void writeOutputToFile(String filename, String content) {
        Path outputPath = Paths.get(filename);
        try {
            Files.write(outputPath, content.getBytes());
            System.out.println("Output written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
