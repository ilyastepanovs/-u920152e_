package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AgePage extends Form {
    private final IButton firstValue = getElementFactory().getButton(By.xpath("//input[1]"), "First Radio-Button");
    private final IButton sumbitButton = getElementFactory().getButton(By.xpath("//input[@type='submit']"), "Submit button");

    public AgePage() {
        super(By.xpath("//p[text()='Сколько Вам лет?']"), "Age Page");
    }

    public void clickFirstValue(){
        firstValue.click();
        sumbitButton.click();
    }



}
