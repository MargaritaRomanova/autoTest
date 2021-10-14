package steps;

import pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();

    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.pasteToSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchSteps OpenTooltip() {
        searchPage.moveToKeyboardSearchButton();
        return this;
    }

    public SearchSteps verityThatTooltipContainsProperText(String text) {
        searchPage.checkKeyboardTooltipContainsText(text);
        return this;
    }

}
