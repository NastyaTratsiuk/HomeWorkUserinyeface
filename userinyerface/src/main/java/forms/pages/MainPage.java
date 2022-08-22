package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final IButton btnLinkHere = getElementFactory().getButton(By.className("start__link"), "Link Here");

    public MainPage() {
        super(By.className("start__button"), "Main Page open");
    }

    public void clickHereLink() {
        btnLinkHere.click();
    }
}
