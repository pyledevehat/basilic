/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui.comps;

import charvax.swing.JButton;
import basilic.ui.UI;
/**
 *
 * @author per_ewan
 */
public class BButton extends JButton {

    public BButton() {
        super();
    }

    public BButton(String text_) {
        super(text_);
    }



    @Override
    public String getText() {
        return UI.getLocText(super.getText());
    }



}
