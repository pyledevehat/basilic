/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui.comps;

import charvax.swing.JMenuItem;
import charva.awt.Toolkit;
import charva.awt.Point;
import basilic.ui.UI;
/**
 *
 * @author per_ewan
 */
public class BMenuItem extends JMenuItem {

    public BMenuItem(String text_, int mnemonic_) {
        super(text_, mnemonic_);
    }

    public BMenuItem(String text_) {
        super(text_);
    }



    @Override
    public String getText() {
        return UI.getLocText(super.getText());
    }

    @Override
    public void draw() {
         /* Get the absolute origin of this component.
         */
        Point origin = getLocationOnScreen();
        Toolkit term = Toolkit.getDefaultToolkit();
        term.setCursor(origin);
        int colorpair = getCursesColor();

        int attribute;
        if (!super.isEnabled()) {
            attribute = Toolkit.A_NORMAL;
            term.addString("<", attribute, colorpair);
            term.addString(getText(), attribute, colorpair);
            term.addString(">", attribute, colorpair);
        } else {
            attribute = (super.hasFocus()) ? Toolkit.A_BOLD : Toolkit.A_NORMAL;
            term.addString(" ", attribute, colorpair);
            term.addString(getText(), attribute, colorpair);
            term.addString(" ", attribute, colorpair);
        }

        if (super.getMnemonic() > 0) {
            int mnemonicPos = getText().indexOf((char) super.getMnemonic());
            if (mnemonicPos != -1) {
                term.setCursor(origin.addOffset(1 + mnemonicPos, 0));
                term.addChar(super.getMnemonic(), attribute | Toolkit.A_UNDERLINE, colorpair);
            }
        }
    }



}
