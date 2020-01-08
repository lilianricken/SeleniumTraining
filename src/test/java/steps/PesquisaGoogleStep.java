package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import util.Hook;

public class PesquisaGoogleStep {
    @Given("que estou na HomePage do Google")
    public void queEstouNaHomePageDoGoogle() {
        Assert.assertEquals("Google",
                Hook.getDriver().getTitle());
    }

    @When("pesquiso por {string}")
    public void pesquisoPor(String text) {
        Hook.getDriver().findElement(By.name("q")).sendKeys(text);
        Hook.getDriver().findElement(By.name("q")).submit();
    }

    @And("eu seleciono o idioma {string}")
    public void euSelecionoOIdioma(String idioma) {
        Hook.getDriver().findElement(By.id("hdtb-tls")).click();
        Hook.getDriver().findElement(By.xpath("//*[@id=\"hdtbMenus\"]/div/div[2]/div")).click();
        Hook.getDriver().findElement(By.linkText("https://www.google.com/search?q=Teste&sxsrf=ACYBGNRS-CMqNXJLNeoOY6pr47563vh8aA:1578499822736&source=lnt&tbs=lr:lang_1pt&lr=lang_pt&sa=X&ved=2ahUKEwj99tiJsvTmAhVKXSsKHRiiC6oQpwV6BAgMEBo")).click();
        System.out.println("UHUL");
    }

    @Then("eu espero ver o resultado em {string}")
    public void euEsperoVerOResultadoEm(String arg0) {
    }

    @And("seleciono intervalo {string}")
    public void selecionoIntervalo(String intervalo) {
        Hook.getDriver().findElement(By.id("hdtb-tls")).click();
        Hook.getDriver().findElement(By.xpath("//*[@id=\"hdtbMenus\"]/div/div[@aria-label=\"Em qualquer data\"]")).click();

        if(intervalo.equals("Na última semana")){
            Hook.getDriver().findElement(By.xpath("//*[@id='qdr_w']/a")).click();
        }else{
            Hook.getDriver().findElement(By.id("cdrlnk")).click();
            //1/01/2020 – 8/01/2020
            System.out.println(intervalo);
        }
    }

    @Then("vejo o resultado com o intervalo {string}")
    public void vejoOResultadoComOIntervalo(String intervalo) {
        String actual = Hook.getDriver().findElement(By.xpath("//*[@id=\"hdtbMenus\"]/div/div[@class=\"hdtb-mn-hd hdtb-tsel\"]/div")).getText();
        Assert.assertEquals(intervalo, actual);
    }
}
