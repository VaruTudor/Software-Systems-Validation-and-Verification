package ssvv.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://www.cs.ubbcluj.ro/")
public class UbbClujPage extends PageObject {

    @FindBy(name="s")
    private WebElementFacade searchInput;

    @FindBy(className="lang-item-en")
    private WebElementFacade changeLanguageElement;

    public void enterKeywordsAndSearch(String keyword) {
        searchInput.typeAndEnter(keyword);
    }

    public void changeLanguage() {
        changeLanguageElement.click();
    }

    public List<String> getFirstTitleAfterSearch() {
        WebElementFacade titles = find(By.className("title"));
        return titles.findElements(By.tagName("a")).stream()
                .map( element -> element.getAttribute("title"))
                .collect(Collectors.toList());
    }

    public String getTitlesAfterLanguageChange() {
        return find(By.cssSelector("h2.title")).getText();
    }
}
