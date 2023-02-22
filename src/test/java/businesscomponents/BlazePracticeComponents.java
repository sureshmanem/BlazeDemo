/*
 *  © [2020] Cognizant. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package businesscomponents;

import com.cognizant.core.DriverScript;
import com.cognizant.core.ReusableLibrary;
import com.cognizant.core.ScriptHelper;
import com.cognizant.framework.Status;

import pages.BlazePracticePage;

public class BlazePracticeComponents extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 *                     {@link DriverScript}
	 */
	public BlazePracticeComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public void launchSeleniumUrl() {

		driver.get("https://www.demoblaze.com/");
		report.updateTestLog("Launch URL", "Application launched Successfully", Status.DONE);
	}

	public void verifyHome() {

		driverUtil.waitUntilElementLocated(BlazePracticePage.homeHeader, 30);
		report.updateTestLog("Home Page", "Navigated to Home Page", Status.PASS);
	}

	public void enterDetails() {
		
		driver.findElement(BlazePracticePage.lnkSignUp).click();
		
		String firstName = dataTable.getData("General_Data", "FirstName");
		String lastName = dataTable.getData("General_Data", "LastName");
		
		driver.findElement(BlazePracticePage.txtSignUser).sendKeys(firstName);
		report.updateTestLog("Details", "username " + firstName, Status.PASS);
		driver.findElement(BlazePracticePage.txtSignPass).sendKeys(lastName);
		report.updateTestLog("Details", "pass " + lastName, Status.PASS);
		
		
		driver.findElement(BlazePracticePage.btnClose).click();
		report.updateTestLog("Details", "Close", Status.PASS);
		
		
	}

	public void submitDetails() {
		
driver.findElement(BlazePracticePage.lnkNext).click();
		
		report.updateTestLog("Details", "Next", Status.PASS);
		
		driver.findElement(BlazePracticePage.lnkPrevious).click();
		
		report.updateTestLog("Submit", "Previous", Status.PASS);
	}
}
