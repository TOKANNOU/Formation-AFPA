package test;

import com.regis.model.Message;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class MessageTest {
    // déclaration et récupération du chemin menant au répertoire projet
    private final String home = System.getProperty("user.dir");
    // récupération du chemin menant au fichier contenant (ou qui contiendra) le message encodé
    private final Path msgEncodedPath = Paths.get(home,"msgEncodedTest.txt");
    // récupération du chemin menant au fichier contenant la clé cryptée
    private final Path keyPath = Paths.get(home,"keyTest.txt");


    /**
     * test du message clair (non encodé)
     */
    @Test
    public void msgClearTest() {
        // récupération du chemin menant au fichier contenant le message clair (non encodé)
        Path msgClearPath = Paths.get(home,"msgClearTest.txt");
        // construction d'un nouveau message et exécution de ce dernier lorsque le message n'est pas encodé
        Message messageTest = new Message(false, msgClearPath, msgEncodedPath, keyPath);
        // exécution de la méthode readNwrite() pour encoder le message
        messageTest.readNwrite();
    }

    /**
     * test du message encodé
     */
    @Test
    public void msgEncodedTest() {
        // récupération du chemin menant au fichier contenant (ou qui contiendra) le message décodé
        Path msgClearPath = Paths.get(home,"decodedTest.txt");
        // construction d'un nouveau message et exécution de ce dernier lorsque le message est encodé
        Message messageTest = new Message(true, msgClearPath, msgEncodedPath, keyPath);
        // exécution de la méthode readNwrite() pour décoder le message
        messageTest.readNwrite();
    }
}
