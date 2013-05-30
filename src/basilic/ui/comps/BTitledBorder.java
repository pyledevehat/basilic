/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basilic.ui.comps;

import charva.awt.Color;
import charva.awt.Component;
import charva.awt.Font;
import charvax.swing.border.Border;
import charvax.swing.border.TitledBorder;
import charva.awt.Toolkit;
import charva.awt.Point;
import basilic.ui.UI;

/**
 *
 * @author per_ewan
 */
public class BTitledBorder extends TitledBorder {

    public BTitledBorder(String title_) {
        super(title_);
    }

    @Override
    public String getTitle() {
        return UI.getLocText(super.getTitle());
    }

    @Override
    public void paintBorder(Component component_, int graphics_, int x_, int y_, int width_, int height_) {
        /* First draw the specified border (which, in the case of the CHARVA
         * package, is always a LineBorder).
         */
        _border.paintBorder(component_, graphics_, x_, y_, width_, height_);

        /* Now insert the title. The background color is obtained from
         * component_. If the titleColor has not been set explicitly,
         * the foreground color is also obtained from component_.
         */
        Color background = component_.getBackground();
        if (_titleColor == null)
            _titleColor = component_.getForeground();

        int colorpair = Color.getCursesColor(_titleColor, background);
        Toolkit term = Toolkit.getDefaultToolkit();
        if (_title.length() != 0) {
            Point origin = new Point(x_, y_);
            term.setCursor(origin.addOffset(1, 0));
            term.addChar(' ', 0, colorpair);
            term.addString(UI.getLocText(_title), 0, colorpair);
            term.addChar(' ', 0, colorpair);
        }
    }






}
