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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with RLRC. If not, see <http://www.gnu.org/licenses/>.
 */
package org.hs.pforzheim.ti.rlrc.agent;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author schrob
 *
 */
public class Agent {

	protected static final Logger LOGGER = Logger.getLogger(Agent.class.getName());
	
	protected String logInfo;
	protected String execString;
	protected String comment;
	protected int executions;
	
	public Agent(String execString) {
		this.execString = execString;
		this.executions = 0;
		this.logInfo = "";
	}
	
	public Agent(String execString, String comment) {
		this.execString = execString;
		this.executions = 0;
		this.logInfo = "";
		this.comment = comment;
	}

	public int getExecutions() {
		return executions;
	}
	
	public void exec() {
		executions++;
		try {
			if(comment == null)
				LOGGER.info(logInfo + execString + " (" + executions + ") starting... ");
			else {
				LOGGER.info(comment);
			}
			Runtime.getRuntime().exec(execString);
		}
		catch (IOException e) {
			LOGGER.warning("Program " + execString + " could not be started! " + e.getMessage());
		}
	}
	
	public String getCommand() {
		return execString;
	}
	
	public String getComment() {
		return comment;
	}
}
