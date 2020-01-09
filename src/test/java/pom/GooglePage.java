package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.Hook;

import static util.Tools.waitBy;

public class GooglePage {
    //constructor
    //Elements
    //Methods

    public GooglePage() {
        PageFactory.initElements(Hook.getDriver(), this);
    }

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchInput;

    @FindBy(how = How.ID, using = "hbtb-tls")
    private WebElement ferramentas;

    @FindBy(how = How.XPATH, using = "hbtb-tls")
    private WebElement menuDate;

    @FindBy(how = How.XPATH, using = "hbtb-tls")
    private WebElement lastWeek;

    public void inputSearch(String text) {
        waitBy(searchInput).sendKeys(text);
        return searchInput;
    }
    public WebElement
}
