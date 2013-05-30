/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui;

import charvax.swing.JFrame;
import basilic.ui.comps.BButton;
import charvax.swing.JMenuBar;
import charvax.swing.JMenu;
import basilic.ui.comps.BMenuItem;
import charvax.swing.JScrollPane;
import charvax.swing.JList;
import charvax.swing.DefaultListModel;
import charvax.swing.border.CompoundBorder;
import basilic.ui.comps.BTitledBorder;
import charvax.swing.border.LineBorder;
import charva.awt.event.ActionListener;
import charva.awt.event.ActionEvent;
import charvax.swing.JPanel;
import charva.awt.Container;
import charva.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import basilic.model.Utilisateur;
import basilic.model.Group;





/**
 *
 * @author per_ewan
 */
public class FenetrePrincipale extends JFrame {

   private BButton newUser;

    public FenetrePrincipale() {
        super("Basilic 0.1");


        /*
         *  Gestion du menu
         */
        JMenuBar barMenu = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('M');


        // Item consultation des logs
        BMenuItem logs = new BMenuItem("bouton3");
        logs.setMnemonic('l');

        // Item changement de langue
        BMenuItem lang = new BMenuItem("bouton6");
        lang.setMnemonic('C');
        lang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ChangeLangueDialog chLang = new ChangeLangueDialog(FenetrePrincipale.this, UI.getLocText("bouton6"));
                chLang.setLocation(23, 5);
                chLang.setVisible(true);
            }
        });

        // Item quitter l'application
        BMenuItem quit = new BMenuItem("bouton2");
        quit.setMnemonic('Q');

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.gc();
                System.exit(0);
            }
        });
        
        menu.add(logs);
        menu.add(lang);
        menu.add(quit);


        barMenu.add(menu);

        this.setJMenuBar(barMenu);



        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);


        // Liste des utilisateurs
        ArrayList<Utilisateur> utils = new Group().getUtils(); // On récupère les utilisateurs dans une ArrayList
        
        DefaultListModel dlm = new DefaultListModel();

        Iterator<Utilisateur> i = utils.iterator();
        while(i.hasNext()) {
            final String nom = i.next().getNom();
            dlm.addElement(nom); //  On remplit une DefaultListModel
        }
        
        JList list = new JList();
        list.setModel(dlm); // On attribue la DefaultListModel à une JList
        list.setVisibleRowCount(12);
        list.setColumns(22);

        JScrollPane listUtils = new JScrollPane(list); // On crée un JScrollPane avec la JList
        listUtils.setViewportBorder(new CompoundBorder(new BTitledBorder("lab1"), new LineBorder(Color.red)));
        listUtils.setLocation(2, 1);
        
        contentPane.add(listUtils);

        // Bouton Nouvel d'utilisateur

        newUser = new BButton("bouton1");
        newUser.setLocation(2, 18);
        newUser.setMnemonic('N');

        contentPane.add(newUser);

        // Zone de description de l'utilisateur sélectionné

        JPanel descPan = new JPanel();
        descPan.setBorder(new BTitledBorder("lab5"));
        descPan.setLocation(30, 1);
        descPan.setSize(40, 16);

        contentPane.add(descPan);

        // Bouton Modifier

        BButton modif = new BButton("bouton5");
        modif.setLocation(32, 18);
        modif.setMnemonic('o');

        contentPane.add(modif);

        // Bouton Supprimer

        BButton suppr = new BButton("bouton4");
        suppr.setLocation(47, 18);
        suppr.setMnemonic('S');

        contentPane.add(suppr);




        
        contentPane.setSize(73, 20);


        pack();


    }

    public BButton getBut() {
        return newUser;
    }

}
