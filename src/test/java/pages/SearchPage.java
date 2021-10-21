package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.Umvnrc")
    private WebElement searchByKeyboardButton;

    public SearchPage() {
        super();
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipboard(searchField, text);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnK"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            clickWithJavascript(searchButton);
        } else {
            pressEnter();
        }
    }

    public void moveToKeyboardSearchButton() {
        builder.moveToElement(searchByKeyboardButton).build().perform();
    }

    public void checkKeyboardTooltipContainsText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + "] was not found").isNotZero();
    }

}










