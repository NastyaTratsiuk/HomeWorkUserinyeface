package forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.JsonParse;

import java.util.List;
import java.util.Random;

public class SecondCardForm extends Form {

    private final ICheckBox cmbUnselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for = 'interest_unselectall']"), "Unselect All");
    private final IButton btnUploadImage = getElementFactory().getButton(By.xpath("//a[@class = 'avatar-and-interests__upload-button']"), "Upload Image");
    private final IButton btnNextSecondCard = getElementFactory().getButton(By.xpath("//button[@class ='button button--stroked button--white button--fluid']"), "Next second card");

    public List<ICheckBox> interestsList() {
        return getElementFactory().findElements(By.xpath("//span[@class='checkbox__box']"), ElementType.CHECKBOX,
                ElementsCount.MORE_THEN_ZERO, ElementState.DISPLAYED);
    }

    public SecondCardForm() {
        super(By.xpath("//div[@class = 'avatar-and-interests__form']"), "Second card");
    }

    public void checkUnselectAll() {
        cmbUnselectAll.check();
    }

    public void checkOfInterestsList() {
        for (int i = 0; i < Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/numberOfInterests")); i++) {
            int index = new Random().nextInt(interestsList().size());
            ICheckBox interest = interestsList().get(index);
            if (index!= (Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/indexSelectedAll")))
                    && index != (Integer.parseInt(JsonParse.getParseElementFromJson("testing.json", "/indexUnSelectedAll")))) {
                interest.getMouseActions().moveMouseToElement();
                interest.getJsActions().click();
            } else {
                i--;
            }
        }
    }

    public void ckickUploadImage() {
        btnUploadImage.click();
    }

    public void ckickNextSecondCard() {
        btnNextSecondCard.click();
    }
}
