package forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class FirstCardForm extends Form {

    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//input[@placeholder = 'Choose Password']"), "Password");
    private final ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder = 'Your email']"), "Email");
    private final ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder = 'Domain']"), "Domain");
    private final IButton btnOther = getElementFactory().getButton(By.xpath("//div[@class = 'dropdown__opener']"), "Other");
    private final ICheckBox cmbAccept = getElementFactory().getCheckBox(By.className("checkbox__box"), "Privacy", ElementState.EXISTS_IN_ANY_STATE);
    private final IButton btnNext = getElementFactory().getButton(By.className("button--secondary"), "Next");

    private List<ILabel> domainList() {
        return getElementFactory().findElements(By.xpath("//div[@class='dropdown__list-item']"), ElementType.LABEL,
                ElementsCount.MORE_THEN_ZERO, ElementState.DISPLAYED);
    }

    public FirstCardForm() {
        super(By.className("login-form__container-copy-1"), "Game Page");
    }

    public void inputPassword(String text) {
        txbPassword.clearAndType(text);
    }

    public void inputEmail(String text) {
        txbEmail.clearAndType(text);
    }

    public void inputDomain(String text) {
        txbDomain.clearAndType(text);
    }

    public void clickOtherDomain() {
        btnOther.click();
    }

    public void checkbox() {
        cmbAccept.check();
    }

    public void clickNext() {
        btnNext.click();
    }

    public void clickDomain() {
        domainList().get(new Random().nextInt(domainList().size())).click();
    }
}
