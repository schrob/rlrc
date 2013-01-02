/**
 * This file is part of RLRC.
 * 
 * RLRC is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RLRC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with RLRC.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.hs.pforzheim.ti.rlrc;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.OpenNI.Point3D;
import org.hs.pforzheim.ti.ni.NICollector;



/**
 * @author schrob
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger.getLogger("rlrc").log(Level.INFO, "rlrc starting...");
		
		new NICollector();
		
		NICollector.agents.add(new Agent(new Point3D(0, 0, 700), 100, "kwrite /etc/issue"));
		NICollector.agents.add(new Agent(new Point3D(50, 100, 1500), 100, "kwrite /etc/issue"));
		
		
		NICollector.ni.startCollectingRealPoints();
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					Logger.getLogger("rlrc").log(Level.INFO, "Starting main window");
					MainPanel window = new MainPanel();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
