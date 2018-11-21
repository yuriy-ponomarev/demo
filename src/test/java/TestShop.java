import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShop extends TestBase {

    @Test
    public void testShopOpenIndexPage() {
        String expectedTitle = "Интернет магазин Opencart \"Русская сборка\"";
        PageShop pageShop = PageShop.open( driver );
        Assert.assertEquals( expectedTitle, pageShop.getTitle() );
    }

    @Test
    public void testShopOpenRegisterPage() {
        String expectedTitle = "Регистрация";
        PageShopRegister pageShopRegister = PageShopRegister.open( driver );
        Assert.assertEquals( expectedTitle, pageShopRegister.getTitle() );
    }

}
