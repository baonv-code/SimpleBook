import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper


public static String generateRandomEmail() {
    // Define strings for generating the email address parts
    String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String uppercaseLetters = lowercaseLetters.toUpperCase();
    String numbers = "0123456789";
    String domain = "@example.com"; // Change this to your desired domain

    // Generate random string for username
    String username = "";
    int usernameLength = 5 + (int) (Math.random() * 5); // Random length between 5 and 10 characters
    for (int i = 0; i < usernameLength; i++) {
        int randomIndex = (int) (Math.random() * (lowercaseLetters.length() + uppercaseLetters.length()));
        if (randomIndex < lowercaseLetters.length()) {
            username += lowercaseLetters.charAt(randomIndex);
        } else {
            username += uppercaseLetters.charAt(randomIndex - lowercaseLetters.length());
        }
    }

    // Generate random number for email address
    String randomNum = String.valueOf((int) (Math.random() * 100000)); // Random 5-digit number

    // Combine username, random number and domain to create the email address
    String emailAddress = username + randomNum + domain;

    return emailAddress;
}
String email = generateRandomEmail(); // Generate a random email address
GlobalVariable.email = email
GlobalVariable.name = 'GROUP 3'
resp = WS.sendRequest(findTestObject('SimpleBook/Authentication'))
JsonSlurper parser = new JsonSlurper()
def responseAfterParsing = parser.parseText(resp.getResponseBodyContent())
println responseAfterParsing
def token = responseAfterParsing.accessToken 
//def token="c4f87495b6be2505501283806658984d167a03f84f6112c40a43e236d915a9ae"
GlobalVariable.acceptToken = token




