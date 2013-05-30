/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.persistxml;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;
import basilic.log.Log;
import basilic.ui.UI;
import java.util.logging.Level;

/**
 *
 * @author per_ewan
 */
public class PersistXML {

    private static File fichierXML;
    private static Log log;
    private static PersistXML persistXML;

    private PersistXML(File f) {
        fichierXML = f;
        createXMLFile();
    }

    private static void createXMLFile() {
        try {
            if(fichierXML.createNewFile()) {
                Element racine = new Element("serveur");
                Document doc = new Document(racine);
                PersistXML.getPersistXML().writeToPersistXML(doc);
            }
        } catch(IOException e) {
            Log.getLog().writeToLog(Level.SEVERE, UI.getLocText("log2"));
            Log.getLog().writeToLog(Level.SEVERE, e.getLocalizedMessage());
        }
        
    }

    /**
     *
     * @return
     */
    public static PersistXML getPersistXML() {
        //return PersistXML.getPersistXML(new File("/etc/servertool/serveur.xml"));
        return PersistXML.getPersistXML(new File("/home/per_ewan/serveur.xml"));
    }

    /**
     *
     * @param path
     * @return
     */
    public static PersistXML getPersistXML(String path) {
        return PersistXML.getPersistXML(new File(path));
    }

    /**
     *
     * @param f
     * @return
     */
    public static PersistXML getPersistXML(File f) {
        if(persistXML == null)
            persistXML = new PersistXML(f);
        return persistXML;
    }

    public File getFichierXML() {
        return fichierXML;
    }

    public Document getDocument() {
        Document doc = null;
        try {
            SAXBuilder builder = new SAXBuilder();
            doc = builder.build(PersistXML.getPersistXML().getFichierXML());
            
        } catch(JDOMException jdome) {

        } catch(IOException ioe) {
            
        }
        return doc;
    }

    public void writeToPersistXML(Document d) {
        XMLOutputter xo = new XMLOutputter();
        try {
            FileOutputStream fos = new FileOutputStream(fichierXML);
            xo.setFormat(Format.getPrettyFormat());
            xo.output(d, fos);
        } catch(FileNotFoundException e) {
            Log.getLog().writeToLog(Level.WARNING, UI.getLocText("log3"));
        } catch(IOException e) {

        }
    }

}
