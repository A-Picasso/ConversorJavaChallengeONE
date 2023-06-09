package com.picasso.menu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Returns the value of the roundness of the top left corner of the panel.
	 * @return The value of the roundness of the top left corner of the panel.
	*/
    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    /**
     *  Sets the value of the roundness for the top-left corner of the panel and triggers a repaint of the panel
     *  with the updated value. This method allows to customize the appearance of the panel by modifying the roundness of its corners.
     *   @param roundTopLeft the new value of the roundness for the top-left corner of the panel.
    */
    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    /**
	 * Returns the value of the roundness of the top right corner of the panel.
	 * @return The value of the roundness of the top right corner of the panel.
	*/
    public int getRoundTopRight() {
        return roundTopRight;
    }

    /**
     *  Sets the value of the roundness for the top-right corner of the panel and triggers a repaint of the panel
     *  with the updated value. This method allows to customize the appearance of the panel by modifying the roundness of its corners.
     *   @param roundTopRight the new value of the roundness for the top-right corner of the panel.
    */
    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    /**
	 * Returns the value of the roundness of the bottom left corner of the panel.
	 * @return The value of the roundness of the bottom left corner of the panel.
	*/
    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    /**
     *  Sets the value of the roundness for the bottom-left corner of the panel and triggers a repaint of the panel
     *  with the updated value. This method allows to customize the appearance of the panel by modifying the roundness of its corners.
     *   @param roundBottomLeft the new value of the roundness for the bottom-left corner of the panel.
    */
    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    /**
	 * Returns the value of the roundness of the bottom right corner of the panel.
	 * @return The value of the roundness of the bottom right corner of the panel.
	*/
    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    /**
     *  Sets the value of the roundness for the bottom-right corner of the panel and triggers a repaint of the panel
     *  with the updated value. This method allows to customize the appearance of the panel by modifying the roundness of its corners.
     *   @param roundBottomRight the new value of the roundness for the bottom-right corner of the panel.
    */
    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public PanelRound() {
        setOpaque(false);
    }

    /**
     * Overrides the paintComponent method from the superclass to customize the rendering of the component.
     * This method creates a new Graphics2D object, sets antialiasing rendering hint to improve the appearance of the rounded corners, fills a shape defined by the roundTopLeft, roundTopRight, roundBottomLeft and
     * roundBottomRight properties and disposes of the Graphics2D object. This method also calls the paintComponent method of the superclass to paint any child components of this PanelRound.
     *  @param grphcs the graphics context to use for painting.
    */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    /**
     *  Creates a Shape object that represents a rounded corner at the top-left of the panel.
     *  @return A Shape object representing the rounded corner at the top-left of the panel.
    */
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    /**
     * Creates a Shape object that represents a rounded corner at the top-right of the panel.
     * @return A Shape object representing the rounded corner at the top-right of the panel.
    */
    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    /**
     * Creates a Shape object that represents a rounded corner at the bottom-left of the panel.
     * @return A Shape object representing the rounded corner at the bottom-left of the panel.
    */
    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    /**
     * Creates a Shape object that represents a rounded corner at the bottom-right of the panel.
     * @return A Shape object representing the rounded corner at the bottom-right of the panel.
    */
    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}
