package page_objects;

import common.constant.Constant;

public class HomePage extends Genneral{
    public void open(){
        Constant.WEB_DRIVER.navigate().to(Constant.RAILWAY_URL);
    }

}
