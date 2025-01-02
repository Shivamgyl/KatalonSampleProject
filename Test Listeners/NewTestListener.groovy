import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


class NewTestListener {
	@BeforeTestCase
	def execBeforeTestCase() {
		openBrowserLaunchApplication()
		}
	
		
	
		@AfterTestCase
		def execAfterTestCase () {
		
		//WebUI.closeBrowser()
		}

		def openBrowserLaunchApplication() {
		WebUI.openBrowser (null)
		WebUI.deleteAllCookies()
		WebUI.navigateToUrl("${GlobalVariable.appUrl}", FailureHandling.STOP_ON_FAILURE)
		WebUI.maximizeWindow()
		}
	
}