package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class ContributorTest {

    @Test
    void SolntsevShouldBeFirstContributor(){
        //open repository page
        Configuration.browserSize="800x400";
        Selenide.open("https://github.com/selenide/selenide");
        //bring mouse over the first avatar in contributor tab
        // ".Layout-sidebar" - точка указывает на класс. Вся строка - "вниз по дереву"
        $(".Layout-sidebar").$$("h2").filterBy(Condition.text("Contributors")).
                first().sibling(0).$$("ul li").first().hover();
        $$(".Popover-message").findBy(Condition.visible).shouldHave(Condition.text("Andrei Solntsev"));

        sleep(5000);

        //check: popup is showing Andrew Solntsev
    }
}
