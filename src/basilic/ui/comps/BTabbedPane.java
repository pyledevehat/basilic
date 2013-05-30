/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui.comps;

import charva.awt.Dimension;
import charvax.swing.JTabbedPane;
import charvax.swing.JButton;
import charva.awt.event.ActionListener;
import charva.awt.event.ActionEvent;
import charva.awt.Insets;
import charva.awt.Component;
import charva.awt.Point;
import charva.awt.Toolkit;
import basilic.ui.UI;

/**
 *
 * @author per_ewan
 */
public class BTabbedPane extends JTabbedPane {

    @Override
    public void addTab(String title_, Object icon_, Component component_, String keylabel_) {
        super.addTab(title_, icon_, component_, keylabel_);
    }

    @Override
    public void setSelectedIndex(int index_) {
        super.setSelectedIndex(index_);
    }

    @Override
    public Dimension minimumSize() {
        return super.minimumSize();
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public int indexOfTab(String title) {
        return super.indexOfTab(title);
    }

    @Override
    public String getTitleAt(int index) {
        return super.getTitleAt(index);
    }

    @Override
    public void setEnabledAt(int index, boolean enabled) {
        super.setEnabledAt(index, enabled);
    }

    @Override
    public void setTitleAt(int index, String title) {
        super.setTitleAt(index, title);
    }

    @Override
    public void debug(int level_) {
        super.debug(level_);
    }

    @Override
    public boolean isEnabledAt(int index) {
        return super.isEnabledAt(index);
    }



    public BTabbedPane() {
        super();
    }

    private class TabButton extends JButton implements ActionListener {
        public TabButton(String label_, Component c_, String keylabel_) {
            super(label_);
            _keylabel = keylabel_;
            _c = c_;
            addActionListener(this);
        }

        public String toString() {
            return "JTabbedPane.TabButton locaton=" + getLocation() +
                    " label=\"" + getLabel() +
                    "\" actionCommand=\"" + getActionCommand() + "\"";
        }

        public void actionPerformed(ActionEvent ev_) {
            setSelectedComponent(_c);
        }

        public String getKeyLabel() {
            return (_keylabel);
        }

        public void setKeyLabel(String keylabel_) {
            _keylabel = keylabel_;
        }

        public void requestFocus() {
            super.requestFocus();
            Point origin = getLocationOnScreen();
            Insets insets = super.getInsets();
            Toolkit.getDefaultToolkit().
                    setCursor(origin.addOffset(2 + insets.left, 0 + insets.top));
        }

        public void draw() {
            Point origin = getLocationOnScreen();
            Insets insets = super.getInsets();
            origin.translate(insets.left, insets.top);

            Toolkit term = Toolkit.getDefaultToolkit();

            term.setCursor(origin);

            int colorpair = getCursesColor();
            term.addChar(Toolkit.ACS_ULCORNER, 0, colorpair);
            term.addChar(' ', 0, colorpair);
            term.addString(getLabelString(), isEnabled() ? Toolkit.A_BOLD : 0,
                    colorpair);
            term.addChar(' ', 0, colorpair);
            term.addChar(Toolkit.ACS_URCORNER, 0, colorpair);
            if (isEnabled()) {
                if (getMnemonic() > 0) {
                    int mnemonicPos = getText().indexOf((char) getMnemonic());
                    if (mnemonicPos != -1) {
                        term.setCursor(origin.addOffset(2 + mnemonicPos, 0));
                        term.addChar(getMnemonic(), Toolkit.A_UNDERLINE |
                                Toolkit.A_REVERSE, colorpair);
                    }
                }
            }
            term.setCursor(origin.addOffset(0, 1));
            if (isSelected()) {
                term.addChar(Toolkit.ACS_LRCORNER, 0, colorpair);
                for (int j = 0; j < getText().length() + 2; j++) {
                    term.addChar(' ', 0, colorpair);
                }
                term.addChar(Toolkit.ACS_LLCORNER, 0, colorpair);
            } else {
                term.addChar(Toolkit.ACS_BTEE, 0, colorpair);
                term.setCursor(origin.addOffset(getText().length() + 3, 1));
                term.addChar(Toolkit.ACS_BTEE, 0, colorpair);
                if (isEnabled()) {
                    term.setCursor(origin.addOffset(1, 1));
                    term.addString(_keylabel, Toolkit.A_BOLD, colorpair);
                }
            }
        }

        public int getWidth() {
            Insets insets = super.getInsets();
            return super.getText().length() + insets.left + insets.right + 4;
        }

        private String _keylabel;
        private Component _c;
    }



}
