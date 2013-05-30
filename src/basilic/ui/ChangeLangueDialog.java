/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui;

import charvax.swing.JDialog;
import charvax.swing.JFrame;
import basilic.ui.comps.BButton;
import charvax.swing.DefaultListModel;
import charvax.swing.JList;
import charvax.swing.JScrollPane;
import charvax.swing.border.TitledBorder;
import charvax.swing.JLabel;
import charva.awt.Container;
import charva.awt.event.ActionListener;
import charva.awt.event.ActionEvent;
import charva.awt.Toolkit;
import charva.awt.Component;
import charva.awt.Color;
import charva.awt.Insets;
import charvax.swing.event.ListSelectionListener;
import charvax.swing.event.ListSelectionEvent;

import java.util.Locale;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

/**
 *
 * @author per_ewan
 */
public class ChangeLangueDialog extends JDialog {

    private FenetrePrincipale parent;

    private BButton annule;

    public ChangeLangueDialog(JFrame frame, String title) {
        super(frame, title);

        parent = (FenetrePrincipale) frame;

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        // Liste des langues disponibles
        ArrayList<Locale> langues = UI.getPropertiesList();

        DefaultListModel dlm = new DefaultListModel();
        Iterator<Locale> i = langues.iterator();
        while(i.hasNext()) {
            String intitLangue = i.next().getLanguage();
            dlm.addElement(intitLangue);
        }

        final JList list = new JList();
        list.setModel(dlm); // On attribue la DefaultListModel à une JList
        list.setVisibleRowCount(4);
        list.setColumns(20);

        
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if(list.getSelectedIndex() == -1) {
                    annule.setText("bouton8");
                    annule.requestFocus();
                } else {
                    annule.setText("bouton7");
                    annule.requestFocus();
                }
                
            }
        });

        JScrollPane listUtils = new JScrollPane(list); // On crée un JScrollPane avec la JList
        listUtils.setViewportBorder(new TitledBorder(UI.getLocText("lab3")));
        listUtils.setLocation(4, 3);



        contentPane.add(listUtils);

        // Bouton d'annulation

        annule = new BButton("bouton8");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(list.getSelectedIndex() != -1) {
                    UI.setLocale(new Locale(list.getModel().getElementAt(list.getSelectedIndex()).toString()));
                }
                ChangeLangueDialog.this.setVisible(false);
            }
        });
        annule.setLocation(10, 10);
        contentPane.add(annule);



        



        contentPane.setSize(30, 14);

        this.pack();

    }

}
