package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private final ILabel timerLabel = getElementFactory().getLabel(By.xpath("//span[@id='timer-counter']"), "Timer");
    private final ITextBox emailTextBox = getElementFactory().getTextBox(By.xpath("//input[@type='email']"), "Email Text Box");
    private final ITextBox passwordTextBox = getElementFactory().getTextBox(By.xpath("//input[@type='password']"), "Password Text Box");
    private final IButton loginButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Login Button");


    public HomePage() {
        super(By.xpath("//p[@class='form_auth_block_head_text']"), "Authorization Page");
    }

    public String getMinutesAndSeconds(){
        return timerLabel.getText();
    }

    public void sentEmail(String email){
        emailTextBox.sendKeys(email);
    }

    public void sentPassword(String password){
         passwordTextBox.sendKeys(password);
    }

    public void clickLogin(String email, String password){
        sentEmail(email);
        sentPassword(password);
        loginButton.click();
    }
}
