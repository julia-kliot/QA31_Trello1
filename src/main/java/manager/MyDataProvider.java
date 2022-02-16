package manager;

import models.Board;
import models.Card;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public static Iterator<Object[]> boardData(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"test1"});
        list.add(new Object[]{"test2"});
        list.add(new Object[]{"test3"});

        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> dataCardCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/julia/Documents/QA/QA_Automation/QA/QA31_Trello1/src/test/resources/datacard.cvs")));
        reader.readLine();
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Card.builder()
                    .cardName(split[0])
                    .color(split[1]).build()});
            line = reader.readLine();

        }
        return list.iterator();

    }
}
