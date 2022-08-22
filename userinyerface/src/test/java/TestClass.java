import aquality.selenium.browser.AqualityServices;
import forms.FirstCardForm;
import forms.SecondCardForm;
import forms.ThirdCardForm;
import forms.pages.GamePage;
import forms.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.*;

public class TestClass extends BaseTest {

    @Test
    public void testCase1CheckCardsOpen() {
        AqualityServices.getBrowser().goTo(JsonParse.getParseElementFromJson("config.json", "/url"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't open.");
        mainPage.clickHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page isn't open.");
        FirstCardForm firstCardForm = new FirstCardForm();
        Assert.assertTrue(firstCardForm.state().waitForDisplayed(), "First card isn't open.");
        RandomClass randomClass = new RandomClass();
        firstCardForm.inputPassword(randomClass.randomPassword(Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/sizePassword")),
                Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/sizeEmail"))));
        firstCardForm.inputEmail(randomClass.randomEmail(Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/sizeEmail"))));
        firstCardForm.inputDomain(randomClass.randomDomain(Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/sizeDomain"))));
        firstCardForm.clickOtherDomain();
        firstCardForm.clickDomain();
        firstCardForm.checkbox();
        firstCardForm.clickNext();
        SecondCardForm secondCardForm = new SecondCardForm();
        Assert.assertTrue(secondCardForm.state().waitForDisplayed(), "Second card isn't open.");
        secondCardForm.checkUnselectAll();
        secondCardForm.checkOfInterestsList();
        System.out.println(secondCardForm.interestsList());
        secondCardForm.ckickUploadImage();
        UploadFileUtils.fileUpload(JsonParse.getParseElementFromJson("testing.json", "/pathImage"));
        secondCardForm.ckickNextSecondCard();
        ThirdCardForm thirdCardForm = new ThirdCardForm();
        Assert.assertTrue(thirdCardForm.state().waitForDisplayed(), "Third card isn't open.");
    }

    @Test
    public void testCase2HiddenHelpForm() {
        AqualityServices.getBrowser().goTo(JsonParse.getParseElementFromJson("config.json", "/url"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't open.");
        mainPage.clickHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page isn't open.");
        gamePage.clickSendToButton();
        Assert.assertTrue(gamePage.isHiddenHelpFormClose(), "Form help content isn't hidden.");
    }

    @Test
    public void testCase3CloseFormCookies() {
        AqualityServices.getBrowser().goTo(JsonParse.getParseElementFromJson("config.json", "/url"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't open.");
        mainPage.clickHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(), "Game Page isn't open.");
        gamePage.acceptCookies();
        Assert.assertFalse(gamePage.isBtnAcceptCookiesClose(), "Cookies form didn't close.");
    }

    @Test
    public void testCase4CheckStartTimer() {
        AqualityServices.getBrowser().goTo(JsonParse.getParseElementFromJson("config.json", "/url"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't open.");
        mainPage.clickHereLink();
        GamePage gamePage = new GamePage();
        Assert.assertEquals(gamePage.getStartTimerValue(), JsonParse.getParseElementFromJson("testing.json", "/startTimerValue"),
                "Invalid timer value");
    }
}
