/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui.comps;

import charvax.swing.JLabel;
import basilic.ui.UI;

/**
 *
 * @author per_ewan
 */
public class BLabel extends JLabel {

    public BLabel(String text_, int align_) {
        super(UI.getLocText(text_), align_);
    }

    @Override
    public synchronized void setText(String label_) {
        super.setText(UI.getLocText(label_));
    }

}
