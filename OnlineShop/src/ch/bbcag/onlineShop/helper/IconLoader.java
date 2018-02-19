package ch.bbcag.onlineShop.helper;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconLoader {

	/**
	 * Loads an icon from the resource folder images.
	 * 
	 * @param iconName
	 *            Name of the icon to load
	 * @return The icon.
	 */
	public static Icon loadIcon(String iconName) {
		final URL resource = IconLoader.class.getResource("/images/" + iconName);
		System.out.println("Requested file: " + "/OnlineShop/resources/images/" + iconName);

		if (resource == null) {
			System.err.println("Error in " + IconLoader.class.getName() + ": Icon OnlineShop/resources/images/"
					+ iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}
}
