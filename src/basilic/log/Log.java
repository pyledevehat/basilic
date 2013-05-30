/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.log;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.io.File;
import java.util.logging.LogManager;
import java.util.Enumeration;
import java.util.logging.Handler;


/**
 *
 * @author per_ewan
 */
public class Log {


    /**
     *
     */
    private Logger logger;

    /**
     *
     */
    private static Log log;

    /**
     *
     */
    private Log(File f) {
        LogManager lm = LogManager.getLogManager();
        lm.reset();
        File logFile = f;
        logger = Logger.getLogger("basilic");
        logger.setLevel(Level.ALL);
        try {
            FileHandler handler = new FileHandler(logFile.getPath(), true);
            handler.setFormatter(new LogFormatter());
            logger.addHandler(handler);
        } catch(java.io.IOException e) {
            System.err.println("Il y a eu des problèmes en ouvrant le fichier de log");
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    /**
     * Retourne une l'instance courante de Log avec le fichier de log par défaut /var/log/servertool.log
     *
     * @return
     */
    public static Log getLog() {
        //return getLog("/var/log/servertool.log");
        return getLog("/home/per_ewan/servertool.log");
    }

    /**
     * Retourne l'instance courante de Log avec le fichier de log défini par le chemin path
     *
     * @param path Le chemin du fichier de log de l'instance de Log à retourner
     * @return
     */
    public static Log getLog(String path) {
        return getLog(new File(path));
    }

    /**
     * Retourne l'instance courante de Log avec le fichier de log défini par l'objet File f passé en paramètre
     *
     * @param f L'objet File représentant le fichier de log de l'instance de Log à retourner
     * @return
     */
    public static Log getLog(File f) {
        if(log == null) {
            log = new Log(f);
        }
        return log;
    }

    /**
     * Écrit line dans le fichier de log courant, avec le niveau level
     *
     * @param level Niveau de la ligne à écrire
     * @param line Chaîne de caractère à écrire dans le fichier de log
     */
    public void writeToLog(Level level, String line) {
        logger.log(level, line);
    }

    public static void getLogInformations() {
        LogManager lm = LogManager.getLogManager();
        Enumeration<String> lognames = lm.getLoggerNames();


        while(lognames.hasMoreElements()) {
            String nomLogger = lognames.nextElement();
            Logger l = Logger.getLogger(nomLogger);
            System.out.println("Nom du Logger : " + nomLogger);
            System.out.println("Level : " + l.getLevel());
            Logger parent = l.getParent();
            System.out.print("Parent : ");
            if (parent == null)
                System.out.println("Le root n'a pas de parent");
            else if(parent.getName().equals(""))
                System.out.println("Root");
            else
            System.out.println(""+parent.getName());
            Handler[] handlers = l.getHandlers();
            for(Handler h : handlers) {
                System.out.println("Handler : " + h.getClass().getName());
            }
            System.out.println("======================");
        }

    }

}
