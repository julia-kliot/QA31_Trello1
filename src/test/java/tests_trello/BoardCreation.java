package tests_trello;

import manager.MyDataProvider;
import models.Board;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreation extends TestBase {

    @DataProvider
    public static Object[][] boardDataModel() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Board.builder().title("test1.1").build()});
        list.add(new Object[]{Board.builder().title("test2.2").build()});
        return new Object[][]{};
    }

    @Test(dataProvider = "boardDataModel")
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

    @Test(groups = {"logs"},invocationCount = 1)
    public void boardCreationTestNew(Board board) throws InterruptedException {
        Board boards = Board.builder().title("testQa31").build();

        logger.info("Board creation : --->"+ board.toString());

        int boardCountBeforeCreation= app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        //app.getBoard().fillBoardCreationForm("testQa31");
        app.getBoard().fillBoardCreationForm(boards);
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


        //List<Object[]> list = new ArrayList<>();

        //list.add(new Object[]{Board.builder().title("test1.1").build()});
        //list.add(new Object[]{Board.builder().title("test2.2").build()});
        //list.add(new Object[]{Board.builder().title("test3.3").build()});

        //return list.iterator();

}
