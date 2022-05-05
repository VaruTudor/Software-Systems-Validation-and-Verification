package ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ssvv.steps.serenity.EndUserStepsUbbCluj;

@RunWith(SerenityRunner.class)
public class SearchByKeywordUbbCluj {

    private final String invalidInputTooLong = new String(new char[500]).replace('\0', 'a');

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserStepsUbbCluj anna;

    // Valid
    @Test
    public void searching_by_keyword__a__should_display_the_corresponding_title() {
        anna.is_the_home_page();
        anna.looks_for("a");
        anna.shouldSeeFirstTitleAfterSearch("Link spre Selecţie pentru proiecte de cercetare destinate studenților FMI în colaborare cu Grab Chronos SRL");

    }

    // Valid
    @Test
    public void searching_by_keyword__orar__should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("Orarul programului");
        anna.shouldSeeFirstTitleAfterSearch("Link spre Orarul programului postuniversitar de pregatire si formare profesionala in Informatica, modulul 2, sem. 2, an univ. 2021-2022");
    }

    // Invalid
    @Test
    public void searching_by_keyword__invalidInputTooLong__should_fail() {
        anna.is_the_home_page();
        anna.looks_for(invalidInputTooLong);
        anna.shouldSeeFirstTitleAfterSearch("Something");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }

}
