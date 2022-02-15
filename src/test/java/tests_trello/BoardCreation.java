package tests_trello;

import manager.MyDataProvider;
import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test(dataProvider = "boardDataModel",dataProviderClass = MyDataProvider.class)
    public void boardCreationTest(Board board) throws InterruptedException {
 //Board board = Board.builder().title("testQa31").build();

        logger.info("Board creation : --->"+ board.toString());

        int boardCountBeforeCreation= app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        //app.getBoard().fillBoardCreationForm("testQa31");
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation= app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation + 1 );
    }
    @Test(dataProvider = "boardData", dataProviderClass = MyDataProvider.class)
    public void boardCreationTest2(String boardName) throws InterruptedException {

        int boardCountBeforeCreation= app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(boardName);
       // app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation= app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation + 1 );
    }
}
