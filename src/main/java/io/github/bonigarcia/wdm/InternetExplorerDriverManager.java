/*
 * (C) Copyright 2015 Boni Garcia (http://bonigarcia.github.io/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package io.github.bonigarcia.wdm;

import java.net.URL;
import java.util.List;

/**
 * Manager for Internet Explorer.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class InternetExplorerDriverManager extends BrowserManager {

	private static InternetExplorerDriverManager instance;

	protected InternetExplorerDriverManager() {
	}

	public static synchronized InternetExplorerDriverManager getInstance() {
		if (instance == null) {
			instance = new InternetExplorerDriverManager();
		}
		return instance;
	}


	@Override
	protected List<URL> getDrivers(Architecture arch, String version) throws Exception {
		String driverVersion = (version == null) ? WdmConfig.getString("wdm.internetExplorerVersion") : version;
		return getDriversFromXml(arch, WdmConfig.getUrl("wdm.internetExplorerDriverUrl"), "IEDriverServer",
				driverVersion);
	}

	@Override
	protected String getExportParameter() {
		return WdmConfig.getString("wdm.internetExplorerExport");
	}

}
