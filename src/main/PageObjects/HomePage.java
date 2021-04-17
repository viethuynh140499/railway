import constant.Constant;

public class HomePage extends Genneral{
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
