package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {


    @BeforeAll
    static void beforeAllBase() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com";
    }


    @AfterEach
    void afterEach() {
        Selenide.closeWindow();
    }

}
