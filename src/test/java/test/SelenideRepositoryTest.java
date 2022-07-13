package test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest extends TestBase{

    @Test
    void selenideTest() {
        //Открыть страницу  GitHub
        Selenide.open("/selenide/selenide");
        //В "поисковой строке" вести текст и нажать поиск
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //Открывается страница с результатами поиска. Найти в нем селенид и перейти по ссылке
        $$("ul.repo-list li").first().$("a").click();
        //Проверить что это верная страница, содержащая текст
        $("#repository-container-header").shouldHave(Condition.text("sElinide / selenide"));

        sleep(5000);
    }


    String selenideRepoUrl = "/selenide/selenide";
    String pageName = "SoftAssertions";
    String checkResult = "JUnit5";

    @Test
    @DisplayName("В разделе SoftAssertions присутствует пример кода для JUnit 5")
    void selenideWiki(){

        Selenide.open(selenideRepoUrl);
        $("#wiki-tab").click();
        $(".wiki-pages-box").click();
        $(".wiki-more-pages-link button").click();
        $$("#wiki-pages-box .flex-1").findBy(text(pageName)).click();
        $(".markdown-body").shouldHave(text(checkResult));

    }
}
