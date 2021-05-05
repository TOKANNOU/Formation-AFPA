package test;

import org.apache.commons.lang3.StringUtils;
import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;

public class ReadKeyTest {
    /**
     * test de cryptage et décryptage d'une clé
     */
    @Test
    public void decryptionTest() {
        // La clé cryptée donnée
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        // La clé décryptée que nous devrions obtenir
        String keyDecrypted = "CFfrkowl.aDzyS:eHjsGPZgMApWvRYVmtnK!BuU IQiEXTxbqhLdNJO,'c";
        // le test d'égalité entre la clé attendue et la sortie de la méthode de la librairie. Si le décryptage ne fonctionne pas nous aurons le message définit ici
        Assert.assertEquals("La librairie de décryptage est mal installée", keyDecrypted, ManaBox.decrypt(keyCrypted));
    }

    /**
     * test de lissage d'un message
     */
    @Test
    public void stripAccentsTest() {
        // message d'origine
        String message = "çàèéuytéçàéuèoàjçyé";
        // message lissé
        String stripMessage = "caeeuytecaeueoajcye";
        // test d'égalité entre le message lissé et la sortie de la méthode stripAccents de la librairie
        Assert.assertEquals("La librairie de lissage de message est mal installée", stripMessage, StringUtils.stripAccents(message));
    }
}
