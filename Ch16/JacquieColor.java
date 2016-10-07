// JacquieColor.java

// Copyright 2005 by Jacquie Barker -- all rights reserved.

// This utility class is used to expand the list of color names that come
// standard in Java.  The problem with the Color class is that there are 
// only a handful of predefined color names, as follows:  black, 
// blue, cyan, darkGray, gray, green, lightGray, magenta, orange, 
// pink, red, white, and yellow.  JacquieColor, in contrast,
// provides almost 90 different named colors -- floralWhite, papayaWhip,
// and so forth -- based on the "standard" colors defined as part of the
// X Windows/Motif library.
//
// This class may be used in one of several ways:
//
// 1.  You can use this class in the same way that you would use the 
//     Color class; e.g.,
//
//     myPanel.setBackground(JacquieColor.snow);
//
// 2.  You can create a class specific to your application, and 
//     invent colors that are named by function - e.g., 
//     warningMessageRed, exitButtonBlue, etc. 

import java.awt.Color;

public class JacquieColor{
	// Define selected of the "standard" color names ...
	public static final Color aliceBlue = new Color(240, 248, 255);
	public static final Color antiqueWhite = new Color(250, 235, 215);
	public static final Color aquamarine = new Color(127, 255, 212);
	public static final Color azure = new Color(240, 255, 255);
	public static final Color beige = new Color(245, 245, 220);
	public static final Color bisque = new Color(255, 228, 196);
	public static final Color blanchedAlmond = new Color(255, 235, 205);
	public static final Color blueViolet = new Color(138, 43, 226);
	public static final Color brown = new Color(165, 42, 42);
	public static final Color burylwood = new Color(222, 184, 135);
	public static final Color chartreuse = new Color(127, 255, 0);
	public static final Color chocolate = new Color(210, 105, 30);
	public static final Color coral = new Color(255, 127, 80);
	public static final Color cornflowerBlue = new Color(100, 149, 237);
	public static final Color cornsilk = new Color(255, 248, 220);
	public static final Color darkGreen = new Color(0, 100, 0);
	public static final Color darkTurquoise = new Color(0, 206, 209);
	public static final Color deepPink = new Color(255, 20, 147);
	public static final Color dodgerBlue = new Color(30, 144, 255);
	public static final Color firebrick = new Color(178, 34, 34);
	public static final Color floralWhite = new Color(255, 250, 240);
	public static final Color forestGreen = new Color(34, 139, 34);
	public static final Color ghostWhite = new Color(248, 248, 255);
	public static final Color gold = new Color(255, 215, 0);
	public static final Color goldenrod = new Color(218, 165, 32);
	public static final Color greenYellow = new Color(173, 255, 47);
	public static final Color honeydew = new Color(240, 255, 240);
	public static final Color hotPink = new Color(255, 105, 180);
	public static final Color indianRed = new Color(205, 92, 92);
	public static final Color ivory = new Color(255, 255, 240);
	public static final Color khaki = new Color(240, 230, 140);
	public static final Color lavender = new Color(230, 230, 250);
	public static final Color lavenderBlush = new Color(255, 240, 245);
	public static final Color lawnGreen = new Color(124, 252, 0);
	public static final Color lemonChiffon = new Color(255, 250, 205);	
	public static final Color lightPink = new Color(255, 182, 193);
	public static final Color lightSkyBlue = new Color(135, 206, 250);
	public static final Color lightYellow = new Color(255, 255, 224);
	public static final Color limeGreen = new Color(50, 205, 50);
	public static final Color linen = new Color(250, 240, 230);
	public static final Color maroon = new Color(176, 48, 96);
	public static final Color mediumBlue = new Color(0, 0, 205);
	public static final Color mediumTurquoise = new Color(72, 209, 204);
	public static final Color mediumVioletRed = new Color(199, 21, 133);
	public static final Color midnightBlue = new Color(25, 25, 112);
	public static final Color mintCream = new Color(245, 255, 250);
	public static final Color mistyRose = new Color(255, 228, 225);
	public static final Color moccasin = new Color(255, 228, 181);
	public static final Color navajoWhite = new Color(255, 222, 173);
	public static final Color navy = new Color(0, 0, 128);
	public static final Color oldLace = new Color(253, 245, 230);
	public static final Color oliveDrab = new Color(107, 142, 35);
	public static final Color orangeRed = new Color(255, 69, 0);
	public static final Color orchid = new Color(218, 112, 214);
	public static final Color paleGoldenrod = new Color(238, 232, 170);
	public static final Color paleGreen = new Color(152, 251, 152);
	public static final Color paleTurquoise = new Color(175, 238, 238);
	public static final Color paleVioletRed = new Color(219, 112, 147);
	public static final Color papayaWhip = new Color(255, 239, 213);
	public static final Color peachPuff = new Color(255, 218, 185);
	public static final Color peru = new Color(205, 133, 63);
	public static final Color plum = new Color(221, 160, 221);
	public static final Color powderBlue = new Color(176, 224, 230);
	public static final Color purple = new Color(160, 32, 240);
	public static final Color rosyBrown = new Color(188, 143, 143);
	public static final Color royalBlue = new Color(65, 105, 225);
	public static final Color saddleBrown = new Color(139, 69, 19);
	public static final Color salmon = new Color(250, 128, 114);
	public static final Color sandyBrown = new Color(244, 164, 96);
	public static final Color seaGreen = new Color(46, 139, 87);
	public static final Color seashell = new Color(255, 245, 238);
	public static final Color sienna = new Color(160, 82, 45);
	public static final Color skyBlue = new Color(135, 206, 235);
	public static final Color slateBlue = new Color(106, 90, 205);
	public static final Color snow = new Color(255, 250, 250);
	public static final Color springGreen = new Color(0, 255, 127);
	public static final Color steelBlue = new Color(70, 130, 180);
	public static final Color tan = new Color(210, 180, 140);
	public static final Color thistle = new Color(216, 191, 216);
	public static final Color tomato = new Color(255, 99, 71);
	public static final Color turquoise = new Color(64, 224, 208);
	public static final Color violet = new Color(238, 130, 238);
	public static final Color violetRed = new Color(208, 32, 144);
	public static final Color wheat = new Color(245, 222, 179);
	public static final Color whiteSmoke = new Color(245, 245, 245);
	public static final Color yellowGreen = new Color(154, 205, 50);
}  
