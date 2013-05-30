/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui.comps;

import charvax.swing.JMenu;
import basilic.ui.UI;
/**
 *
 * @author per_ewan
 */
public class BMenu extends JMenu {

    public BMenu(String text_, int mnemonic_) {
        super(UI.getLocText(text_), mnemonic_);
    }

    @Override
    public void setText(String label_) {
        super.setText(UI.getLocText(label_));
    }

}
