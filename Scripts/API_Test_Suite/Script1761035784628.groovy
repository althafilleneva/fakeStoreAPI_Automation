import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS 
import com.kms.katalon.core.testobject.ObjectRepository

// Create Product (POST)
def postResponse = WS.sendRequest(ObjectRepository.findTestObject('createProduct')) 
WS.verifyResponseStatusCode(postResponse, 201) 
def postJSON = new groovy.json.JsonSlurper().parseText(postResponse.getResponseBodyContent())
assert postJSON.title == 'New Product' 
assert postJSON.price == 29.99

// Get Product (GET)
def getResponse = WS.sendRequest(ObjectRepository.findTestObject('getProduct'))
WS.verifyResponseStatusCode(getResponse, 200)
def getJSON = new groovy.json.JsonSlurper().parseText(getResponse.getResponseBodyContent())

// Update Product (PUT)
def putResponse = WS.sendRequest(ObjectRepository.findTestObject('updateProduct'))
WS.verifyResponseStatusCode(putResponse, 200)
def putJSON = new groovy.json.JsonSlurper().parseText(putResponse.getResponseBodyContent())
assert putJSON.title == 'Updated Product'
assert putJSON.price == 39.99