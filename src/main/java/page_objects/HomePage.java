package page_objects;

import common.constant.Constant;

public class HomePage extends Genneral{
    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}
