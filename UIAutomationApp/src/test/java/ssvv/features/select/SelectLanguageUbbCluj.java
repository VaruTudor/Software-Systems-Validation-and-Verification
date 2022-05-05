package ssvv.features.select;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ssvv.steps.serenity.EndUserStepsUbbCluj;

@RunWith(SerenityRunner.class)
public class SelectLanguageUbbCluj {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserStepsUbbCluj anna;

    // Valid
    @Test
    public void select_change_language__should_display_the_corresponding_title_in_en() {
        anna.is_the_home_page();
        anna.changeLanguage();
        anna.shouldSeeMainPageTitle("Mathematics and Computer Science – between Eternity and Effervescence");
    }

    // Invalid
    @Test
    public void select_change_language__should_display_the_corresponding_title_in_ro() {
        anna.is_the_home_page();
        anna.changeLanguage();
        anna.shouldSeeMainPageTitle("Matematică și Informatică – între Eternitate și Efervescență");
    }

    @Pending
    @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
}
