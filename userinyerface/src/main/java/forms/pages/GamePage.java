package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import javax.swing.*;

public class GamePage extends Form {

    private final IButton btnAcceptCookies = getElementFactory().getButton(By.xpath("//button[contains(@class,'transparent')]"),
            "Accept cookies");
    private final IButton btnSend = getElementFactory().getButton(By.xpath("//button [@class = 'button button--solid button--blue help-form__send-to-bottom-button']"), "Send to button");
    private final ILabel lblHiddenHelpForm = getElementFactory().getLabel(By.xpath("//div[@class = 'help-form is-hidden']"), "Help form hidden");
    private final ILabel lblTimer = getElementFactory().getLabel(By.xpath("//div[@class = 'timer timer--white timer--center']"),
            "Timer start");

    public GamePage() {
        super(By.className("login-form__container-copy-1"), "Game Page");
    }

    public String getStartTimerValue() {
        return lblTimer.getText();
    }

    public void acceptCookies() {
        btnAcceptCookies.click();
    }

    public boolean isBtnAcceptCookiesClose() {
        return btnAcceptCookies.state().isDisplayed();
    }

    public void clickSendToButton() {
        btnSend.click();
    }

    public boolean isHiddenHelpFormClose() {
        return lblHiddenHelpForm.state().isDisplayed();
    }

}
