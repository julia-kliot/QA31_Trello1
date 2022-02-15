package tests_trello;

import manager.MyDataProvider;
import models.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase{


    @Test(dataProvider = "dataCardCSV",dataProviderClass = MyDataProvider.class)
    public void cardCreation(Card card){
       // Card card = Card.builder().cardName("Test1/1").color("green").build();
        app.getBoard().clickOnFirstBoard();
        app.getList().createList("Test_QA31.1");
        app.getCard().initCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }
}
