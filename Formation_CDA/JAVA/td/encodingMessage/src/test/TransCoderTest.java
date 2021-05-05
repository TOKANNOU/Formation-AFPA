package test;

import com.regis.tools.TransCoder;
import org.junit.Assert;
import org.junit.Test;

public class TransCoderTest {
    // déclaration de la clé cryptée
    private final String keyCrypted = "6lUjKOzUj4e/Gelw9c6sDLqHniwulClN6XSayZ+HRF/kbZx+CMf95jxrhm4YFSY26OnxVlsrzGkO00IMeAFs3g==";
    // message de base à encoder
    private final String msgTest = "Salut les amis";
    // résultat du message encodé
    private final String msgEncodedTestResult = "BSACAPAAAYAFAPBOAGAFACBECDAG";

    /**
     * test du TransCoder
     */
    @Test
    public void createMapTest() {
        // appel du transcoder pour décrypter la clé et créer le mappage d'encodage et de décodage
        TransCoder transcodeTest = new TransCoder(keyCrypted);
        // appel de la méthode d'obtention du mappage d'encodage
        Assert.assertNotNull(transcodeTest.getEncode());
        System.out.println(transcodeTest.getEncode().toString()); // affichage du mappage d'encodage
        // appel de la méthode d'obtention du mappage de décodage
        Assert.assertNotNull(transcodeTest.getDecode());
        System.out.println(transcodeTest.getDecode().toString()); // affichage du mappage de décodage
    }

    /**
     * test de la méthode d'encodage
     */
    @Test
    public void encodeTest() {
        // appel du transcoder pour décrypter la clé et créer le mappage d'encodage et de décodage
        TransCoder transcodeTest = new TransCoder(keyCrypted);
        // encodage du message
        String msgEncodedTest = transcodeTest.encode(msgTest);
        // affichage du résultat
        System.out.println("Le message codé est : " + msgEncodedTest);
        // test d'égalité entre le message encodé et la sortie de la méthode d'encodage
        Assert.assertEquals("La méthode d'encodage ne fonctionne pas", msgEncodedTestResult, msgEncodedTest);
    }

    /**
     * test de la méthode de décodage
     */
    @Test
    public void decodeTest() {
        // appel du transcoder pour décrypter la clé et créer le mappage d'encodage et de décodage
        TransCoder transcodeTest = new TransCoder(keyCrypted);
        // décodage du message encodé
        String msgDecodedTest = transcodeTest.decode(msgEncodedTestResult);
        // affichage du résultat
        System.out.println("Le message décodé est : " + msgDecodedTest);
        // test d'égalité entre le message à encoder et la sortie de la méthode de décodage
        Assert.assertEquals("La méthode de décodage ne fonctionne pas", msgTest, msgDecodedTest);
    }
}