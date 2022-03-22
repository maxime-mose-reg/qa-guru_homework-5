package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    // открыть страницу проекта selenide в GitHub
    // перейти в раздел Wiki проекта
    // проверить, что в спике страниц есть SoftAssertions и открыть страницу SoftAssertions
    // проверить, что на странице есть пример кода для JUnit 5
    @Test
    void githubWikiPageTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link button").click();
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        $(withTagAndText("h4", "JUnit5")).sibling(0).$("pre").shouldHave(text("@Test"));
    }

    // открыть страницу https://the-internet.herokuapp.com/drag_and_drop
    // перенести прямоугольник А на место прямоугольника В
    // проверить, что прямоугольники действительно поменялись местами
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A")).dragAndDropTo($("#column-b").shouldHave(text("B")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
