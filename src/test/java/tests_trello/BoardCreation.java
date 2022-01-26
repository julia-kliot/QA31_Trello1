package tests_trello;

import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test
    public void boardCreationTest() throws InterruptedException {
 Board board = Board.builder().title("testQa31").build();
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
}
