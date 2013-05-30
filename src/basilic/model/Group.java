/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import basilic.persistxml.PersistXML;
import java.lang.ArrayIndexOutOfBoundsException;
import basilic.log.Log;
import basilic.ui.UI;
import java.util.logging.Level;

/**
 *
 * @author per_ewan
 */
public class Group {

    private ArrayList<Utilisateur> utils = new ArrayList<Utilisateur>();

    public Group() {

        Document doc = PersistXML.getPersistXML().getDocument();
        List<Element> elemList = new ArrayList<Element>();
        elemList = doc.getRootElement().getChildren("utilisateur");
        Iterator<Element> i = elemList.iterator();
        while(i.hasNext()) {
            utils.add(new Utilisateur(i.next().getChildText("nom")));
        }
    
    }

    public ArrayList<Utilisateur> getUtils() {
        return utils;
    }

    public void addUtilisateur(Utilisateur u) {
        Document doc = PersistXML.getPersistXML().getDocument();
        Element racine = doc.getRootElement();
        Element util = new Element("utilisateur");
        racine.addContent(util);
        Element nom = new Element("nom");
        util.addContent(nom);
        nom.setText(u.getNom());
        PersistXML.getPersistXML().writeToPersistXML(doc);
    }

    public void removeUtilisateur(Utilisateur u) {
        Document doc = PersistXML.getPersistXML().getDocument();
        Element racine = doc.getRootElement();
        List<Element> list = racine.getChildren("utilisateur");
        Iterator<Element> i = list.iterator();
        while(i.hasNext()) {
            Element el = (Element) i.next();
            if(el.getChild("nom").getText().equals(u.getNom()))
                i.remove();
        }

        /*for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getChild("nom").getText() == u.getNom()) {
                list.remove(i);
            }
        }*/
        PersistXML.getPersistXML().writeToPersistXML(doc);


    }

    public Utilisateur getUtilisateur(String nomUtil) {
        Utilisateur u = null;
        try {
            u = utils.get(utils.indexOf(new Utilisateur(nomUtil)));
        } catch(ArrayIndexOutOfBoundsException e) {
            Log.getLog().writeToLog(Level.WARNING, UI.getLocText("log1"));
        }
        return u;
    }

    // @TODO
    public Utilisateur getUtilisateur(int uidUtil) {
        Utilisateur u = null;
        return u;
    }

}
