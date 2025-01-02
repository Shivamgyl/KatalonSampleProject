import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//setting up wrong username to check if it is accepting wrong username
WebUI.setText(findTestObject('Object Repository/Page_SauceLabsDashboard/inputBox_Username'), wrongUsername)

WebUI.click(findTestObject('Object Repository/Page_SauceLabsDashboard/button_Login'))

//verifying error message is present
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_SauceLabsDashboard/webElement_ErrorMessage'), midDelay)

WebUI.clearText(findTestObject('Object Repository/Page_SauceLabsDashboard/inputBox_Username'))

WebUI.setText(findTestObject('Object Repository/Page_SauceLabsDashboard/inputBox_Username'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Page_SauceLabsDashboard/inputBox_Password'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Page_SauceLabsDashboard/button_Login'))

//now adding products in the cart
WebUI.click(findTestObject('Object Repository/Page_Products/webElement_Products', [('productName') : product1]))

WebUI.click(findTestObject('Object Repository/Page_Products/webElement_Products', [('productName') : product2]))

//traversing to the cart
WebUI.scrollToElement(findTestObject('Object Repository/Page_Products/icon_cart'), GlobalVariable.waitForTimeOut)

WebUI.click(findTestObject('Object Repository/Page_Products/icon_cart'))

WebUI.click(findTestObject('Object Repository/Page_YourCart/button_ContinueShopping'))

WebUI.click(findTestObject('Object Repository/Page_Products/webElement_Products', [('productName') : product3]))

//traversing to the cart
WebUI.scrollToElement(findTestObject('Object Repository/Page_Products/icon_cart'), GlobalVariable.waitForTimeOut)

WebUI.click(findTestObject('Object Repository/Page_Products/icon_cart'))

//removing one product from the cart
WebUI.click(findTestObject('Object Repository/Page_YourCart/button_Remove', [('productName') : product2]))

//checking out
WebUI.click(findTestObject('Object Repository/Page_YourCart/button_Checkout'))

//without entering name checking if error message is there or not
WebUI.click(findTestObject('Object Repository/Page_CheckoutInformation/button_Continue'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CheckoutInformation/webElement_ErrorMessage'), midDelay)

WebUI.setText(findTestObject('Object Repository/Page_CheckoutInformation/inputBox_FirstName'), firstName)

WebUI.setText(findTestObject('Object Repository/Page_CheckoutInformation/inputBox_LastName'), lastName)

WebUI.setText(findTestObject('Object Repository/Page_CheckoutInformation/inputBox_PostalCode'), postalCode)

WebUI.click(findTestObject('Object Repository/Page_CheckoutInformation/button_Continue'))

//clicking cart to go back on the cart page
WebUI.click(findTestObject('Object Repository/Page_Products/icon_cart'))

WebUI.click(findTestObject('Object Repository/Page_YourCart/button_Checkout'))

//Again entering details
WebUI.setText(findTestObject('Object Repository/Page_CheckoutInformation/inputBox_FirstName'), firstName)

WebUI.setText(findTestObject('Object Repository/Page_CheckoutInformation/inputBox_LastName'), lastName)

WebUI.setText(findTestObject('Object Repository/Page_CheckoutInformation/inputBox_PostalCode'), postalCode)

WebUI.click(findTestObject('Object Repository/Page_CheckoutInformation/button_Continue'))

WebUI.click(findTestObject('Object Repository/Page_CheckoutOverview/button_Finish'))

WebUI.click(findTestObject('Object Repository/Page_CheckoutComplete/button_BackHome'))

//logging out
WebUI.click(findTestObject('Object Repository/Page_Products/icon_HamburgerMenu'))

WebUI.click(findTestObject('Object Repository/Page_Products/webElement_Logout'))