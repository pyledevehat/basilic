/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui;

import basilic.log.Log;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
import java.io.File;

import charvax.swing.JButton;
import charvax.swing.JLabel;
import charvax.swing.JMenu;
import charvax.swing.JMenuItem;
import charvax.swing.border.TitledBorder;
import charva.awt.Component;
import charva.awt.Container;

/**
 *
 * @author per_ewan
 */
public class UI {

    private static UI ui;
    private static FenetrePrincipale win;
    private static Locale locCourante = Locale.FRENCH;
    private static HashMap<Object, String> corresp;

    private UI() {

        win = new FenetrePrincipale();
        win.setVisible(true);

    }

    public static UI getUI() {
        if(ui == null)
            ui = new UI();
        return ui;
    }

    public static void setLocale(Locale loc) {
        locCourante = loc;
    }

    public static Locale getLocale() {
        return locCourante;
    }

    public static String getLocText(String key) {
        String ret = null;
        ResourceBundle resBundle = ResourceBundle.getBundle("basilic", locCourante);
        try {
            ret = resBundle.getString(key);
        } catch(MissingResourceException e) {
            ret = key;
        }
        return ret;
    }


    public static ArrayList<Locale> getPropertiesList() {
        ArrayList<Locale> locales = new ArrayList<Locale>();

        File rep = new File("/home/per_ewan/Stlenn/Mennadou/Basilic/resources/");
        String[] list = rep.list();
        for(int i=0 ; i<list.length ; i++) {
                if(list[i].endsWith(".properties")) {
                list[i] = list[i].replaceFirst("basilic", "");
                list[i] = list[i].replaceFirst("_", "");
                list[i] = list[i].replaceFirst(".properties", "");
                if(list[i].equals(""))
                    list[i] = "fr";
                locales.add(new Locale(list[i]));
            }
        }
        

        return locales;
    }

    public static void changeLabels(Container root) {
        ArrayList<Component> list = null;
        list = (ArrayList) Arrays.asList(root.getComponents());
        Iterator i = list.iterator();
        while(i.hasNext()) {
            
        }
    }

}
