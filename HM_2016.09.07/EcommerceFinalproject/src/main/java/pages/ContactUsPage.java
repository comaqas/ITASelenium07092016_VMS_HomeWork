package pages;

import com.codeborne.selenide.SelenideElement;
import data.ContactUsData;
import helpers.Locators;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import java.io.File;


public class ContactUsPage {

    private static final By SUBJECT_DROP_DOWN_LIST = Locators.get("subjectDropDownList");
    private static final By EMAIL_ADDRESS_INPUT = Locators.get("emailAddressInput");
    private static final By ORDER_REFERENCE = Locators.get("orderReference");
    private static final By UPLOAD_FILE_BUTTON = Locators.get("uploadFileButton");
    private static final By TEXT_MESSAGE_WINDOW = Locators.get("textMessageWindow");
    private static final By SUBMIT_BUTTON = Locators.get("sendSubmitButton");
    private static final By WARNING_ALERT = Locators.get("warningAlert");
    private static final By SUCCESS_ALERT = Locators.get("successAlert");


    public static void completeMessageFormWith(ContactUsData data){
        $(SUBJECT_DROP_DOWN_LIST).selectOptionByValue(data.subject);
        $(EMAIL_ADDRESS_INPUT).setValue(data.email);
        $(ORDER_REFERENCE).sendKeys(data.order);
        $(UPLOAD_FILE_BUTTON).uploadFile(new File(data.pathToFile));
        $(TEXT_MESSAGE_WINDOW).setValue(data.message);
        $(SUBMIT_BUTTON).click();
    }


    public static SelenideElement isSuccessAlertDisplayedWith(String successText){
        return $(SUCCESS_ALERT).shouldHave(exactText(successText));
    }


    public static SelenideElement isWarningAlertDisplayedWith(String errorText){
        return $(WARNING_ALERT).shouldHave(exactText(errorText));
    }
}
