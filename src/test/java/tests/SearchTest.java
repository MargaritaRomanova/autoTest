package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "searchDataProvider")
    public void openGoogleComTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Пишем автотест с использованием")
                .verifyThatTopResultContainsProperAttributeText("LC20lb DKV0");
    }
    @Test
    public void verifySearchByKeyboardTooltipOnGoogle() {
        steps.OpenTooltip()
                .verityThatTooltipContainsProperText("Экранная клавиатура");
    }
}
