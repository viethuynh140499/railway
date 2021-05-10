package page_objects;

import common.element.Link;
import common.element.Table;
import common.helpers.BrowserHelper;
import org.openqa.selenium.By;

public class TrainTimetablePage extends GeneralPage {
  String dynamicTableCell = "//td[count(//th[text()='Depart Station']" +
          "/preceding-sibling::th)+1][text()=" +
          "'%s']//parent::tr//td[count(//th[text()='Arrive Station']" +
          "/preceding-sibling::th)+1][text()='%s']//parent::tr//a[text()='book ticket']";

  private Link lnkBookTicket;

 public void clickBookTicket(String departStation, String arriveAt){
  lnkBookTicket = new Link(By.xpath(String.format(dynamicTableCell,departStation,arriveAt)));
  lnkBookTicket.scrollToView();
  lnkBookTicket.click();
 }
}
