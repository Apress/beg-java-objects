// ColorViewer.java

// Copyright 2005 by Jacquie Barker -- all rights reserved.

// Use this to look at all of the various colors defined by the JacquieColor class.  

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorViewer extends Frame {
	public ColorViewer() {
		super("Jacquie's Color Viewer");

		ScrollPane sp = new ScrollPane();
		this.add(sp);

		Panel p = new Panel();
		sp.add(p);

		GridLayout g = new GridLayout(94, 1);
		p.setLayout(g);

		Label l = new Label("aliceBlue");
		l.setBackground(JacquieColor.aliceBlue);
		p.add(l);

		l = new Label("antiqueWhite");
		l.setBackground(JacquieColor.antiqueWhite);
		p.add(l);

		l = new Label("aquamarine");
		l.setBackground(JacquieColor.aquamarine);
		p.add(l);

		l = new Label("azure");
		l.setBackground(JacquieColor.azure);
		p.add(l);

		l = new Label("beige");
		l.setBackground(JacquieColor.beige);
		p.add(l);

		l = new Label("bisque");
		l.setBackground(JacquieColor.bisque);
		p.add(l);

		l = new Label("blanchedAlmond");
		l.setBackground(JacquieColor.blanchedAlmond);
		p.add(l);

		l = new Label("blue *");
		l.setBackground(Color.blue);
		p.add(l);

		l = new Label("blueViolet");
		l.setBackground(JacquieColor.blueViolet);
		p.add(l);

		l = new Label("brown");
		l.setBackground(JacquieColor.brown);
		p.add(l);

		l = new Label("burylwood");
		l.setBackground(JacquieColor.burylwood);
		p.add(l);

		l = new Label("chartreuse");
		l.setBackground(JacquieColor.chartreuse);
		p.add(l);

		l = new Label("chocolate");
		l.setBackground(JacquieColor.chocolate);
		p.add(l);

		l = new Label("coral");
		l.setBackground(JacquieColor.coral);
		p.add(l);

		l = new Label("cornflowerBlue");
		l.setBackground(JacquieColor.cornflowerBlue);
		p.add(l);

		l = new Label("cornsilk");
		l.setBackground(JacquieColor.cornsilk);
		p.add(l);

		l = new Label("cyan *");
		l.setBackground(Color.cyan);
		p.add(l);

		l = new Label("darkGreen");
		l.setBackground(JacquieColor.darkGreen);
		p.add(l);

		l = new Label("darkTurquoise");
		l.setBackground(JacquieColor.darkTurquoise);
		p.add(l);

		l = new Label("deepPink");
		l.setBackground(JacquieColor.deepPink);
		p.add(l);

		l = new Label("dodgerBlue");
		l.setBackground(JacquieColor.dodgerBlue);
		p.add(l);

		l = new Label("firebrick");
		l.setBackground(JacquieColor.firebrick);
		p.add(l);

		l = new Label("floralWhite");
		l.setBackground(JacquieColor.floralWhite);
		p.add(l);

		l = new Label("forestGreen");
		l.setBackground(JacquieColor.forestGreen);
		p.add(l);

		l = new Label("ghostWhite");
		l.setBackground(JacquieColor.ghostWhite);
		p.add(l);

		l = new Label("gold");
		l.setBackground(JacquieColor.gold);
		p.add(l);

		l = new Label("goldenrod");
		l.setBackground(JacquieColor.goldenrod);
		p.add(l);

		l = new Label("green *");
		l.setBackground(Color.green);
		p.add(l);

		l = new Label("greenYellow");
		l.setBackground(JacquieColor.greenYellow);
		p.add(l);

		l = new Label("honeydew");
		l.setBackground(JacquieColor.honeydew);
		p.add(l);

		l = new Label("hotPink");
		l.setBackground(JacquieColor.hotPink);
		p.add(l);

		l = new Label("indianRed");
		l.setBackground(JacquieColor.indianRed);
		p.add(l);

		l = new Label("ivory");
		l.setBackground(JacquieColor.ivory);
		p.add(l);

		l = new Label("khaki");
		l.setBackground(JacquieColor.khaki);
		p.add(l);

		l = new Label("lavender");
		l.setBackground(JacquieColor.lavender);
		p.add(l);

		l = new Label("lavenderBlush");
		l.setBackground(JacquieColor.lavenderBlush);
		p.add(l);

		l = new Label("lawnGreen");
		l.setBackground(JacquieColor.lawnGreen);
		p.add(l);

		l = new Label("lemonChiffon");
		l.setBackground(JacquieColor.lemonChiffon);
		p.add(l);

		l = new Label("lightPink");
		l.setBackground(JacquieColor.lightPink);
		p.add(l);

		l = new Label("lightSkyBlue");
		l.setBackground(JacquieColor.lightSkyBlue);
		p.add(l);

		l = new Label("lightYellow");
		l.setBackground(JacquieColor.lightYellow);
		p.add(l);

		l = new Label("limeGreen");
		l.setBackground(JacquieColor.limeGreen);
		p.add(l);

		l = new Label("linen");
		l.setBackground(JacquieColor.linen);
		p.add(l);

		l = new Label("magenta *");
		l.setBackground(Color.magenta);
		p.add(l);

		l = new Label("maroon");
		l.setBackground(JacquieColor.maroon);
		p.add(l);

		l = new Label("mediumBlue");
		l.setBackground(JacquieColor.mediumBlue);
		p.add(l);

		l = new Label("mediumTurquoise");
		l.setBackground(JacquieColor.mediumTurquoise);
		p.add(l);

		l = new Label("mediumVioletRed");
		l.setBackground(JacquieColor.mediumVioletRed);
		p.add(l);

		l = new Label("midnightBlue");
		l.setBackground(JacquieColor.midnightBlue);
		p.add(l);

		l = new Label("mintCream");
		l.setBackground(JacquieColor.mintCream);
		p.add(l);

		l = new Label("mistyRose");
		l.setBackground(JacquieColor.mistyRose);
		p.add(l);

		l = new Label("moccasin");
		l.setBackground(JacquieColor.moccasin);
		p.add(l);

		l = new Label("navajoWhite");
		l.setBackground(JacquieColor.navajoWhite);
		p.add(l);

		l = new Label("navy");
		l.setBackground(JacquieColor.navy);
		p.add(l);

		l = new Label("oldLace");
		l.setBackground(JacquieColor.oldLace);
		p.add(l);

		l = new Label("oliveDrab");
		l.setBackground(JacquieColor.oliveDrab);
		p.add(l);

		l = new Label("orange *");
		l.setBackground(Color.orange);
		p.add(l);

		l = new Label("orangeRed");
		l.setBackground(JacquieColor.orangeRed);
		p.add(l);

		l = new Label("orchid");
		l.setBackground(JacquieColor.orchid);
		p.add(l);

		l = new Label("paleGoldenrod");
		l.setBackground(JacquieColor.paleGoldenrod);
		p.add(l);

		l = new Label("paleGreen");
		l.setBackground(JacquieColor.paleGreen);
		p.add(l);

		l = new Label("paleTurquoise");
		l.setBackground(JacquieColor.paleTurquoise);
		p.add(l);

		l = new Label("paleVioletRed");
		l.setBackground(JacquieColor.paleVioletRed);
		p.add(l);

		l = new Label("papayaWhip");
		l.setBackground(JacquieColor.papayaWhip);
		p.add(l);

		l = new Label("peachPuff");
		l.setBackground(JacquieColor.peachPuff);
		p.add(l);

		l = new Label("peru");
		l.setBackground(JacquieColor.peru);
		p.add(l);

		l = new Label("pink *");
		l.setBackground(Color.pink);
		p.add(l);

		l = new Label("plum");
		l.setBackground(JacquieColor.plum);
		p.add(l);

		l = new Label("powderBlue");
		l.setBackground(JacquieColor.powderBlue);
		p.add(l);

		l = new Label("purple");
		l.setBackground(JacquieColor.purple);
		p.add(l);

		l = new Label("red *");
		l.setBackground(Color.red);
		p.add(l);

		l = new Label("rosyBrown");
		l.setBackground(JacquieColor.rosyBrown);
		p.add(l);

		l = new Label("royalBlue");
		l.setBackground(JacquieColor.royalBlue);
		p.add(l);

		l = new Label("saddleBrown");
		l.setBackground(JacquieColor.saddleBrown);
		p.add(l);

		l = new Label("salmon");
		l.setBackground(JacquieColor.salmon);
		p.add(l);

		l = new Label("sandyBrown");
		l.setBackground(JacquieColor.sandyBrown);
		p.add(l);

		l = new Label("seaGreen");
		l.setBackground(JacquieColor.seaGreen);
		p.add(l);

		l = new Label("seashell");
		l.setBackground(JacquieColor.seashell);
		p.add(l);

		l = new Label("sienna");
		l.setBackground(JacquieColor.sienna);
		p.add(l);

		l = new Label("skyBlue");
		l.setBackground(JacquieColor.skyBlue);
		p.add(l);

		l = new Label("slateBlue");
		l.setBackground(JacquieColor.slateBlue);
		p.add(l);

		l = new Label("snow");
		l.setBackground(JacquieColor.snow);
		p.add(l);

		l = new Label("springGreen");
		l.setBackground(JacquieColor.springGreen);
		p.add(l);

		l = new Label("steelBlue");
		l.setBackground(JacquieColor.steelBlue);
		p.add(l);

		l = new Label("tan");
		l.setBackground(JacquieColor.tan);
		p.add(l);

		l = new Label("thistle");
		l.setBackground(JacquieColor.thistle);
		p.add(l);

		l = new Label("tomato");
		l.setBackground(JacquieColor.tomato);
		p.add(l);

		l = new Label("turquoise");
		l.setBackground(JacquieColor.turquoise);
		p.add(l);

		l = new Label("violet");
		l.setBackground(JacquieColor.violet);
		p.add(l);

		l = new Label("violetRed");
		l.setBackground(JacquieColor.violetRed);
		p.add(l);

		l = new Label("wheat");
		l.setBackground(JacquieColor.wheat);
		p.add(l);

		l = new Label("whiteSmoke");
		l.setBackground(JacquieColor.whiteSmoke);
		p.add(l);

		l = new Label("yellow *");
		l.setBackground(Color.yellow);
		p.add(l);

		l = new Label("yellowGreen");
		l.setBackground(JacquieColor.yellowGreen);
		p.add(l);

		WindowAdapter listener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(listener);

		this.setSize(300, 500);
		this.setLocation(100, 100); 
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ColorViewer();
	}
}
