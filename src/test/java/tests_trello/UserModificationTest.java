package tests_trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserModificationTest extends TestBase{

    @Test
    public void  testNewTab() throws InterruptedException {
        app.getUser().openTabAndSwitch();
    }

    @Test
    public void testChangeAvatar() throws InterruptedException {
        app.getUser().clickOnAvatar();
        app.getUser().openUserProfile();
        app.getUser().goToAtlassianAccount();
        Thread.sleep(7000);

        String url=  app.getURL();
        Assert.assertEquals(url, "https://id.atlassian.com/manage-profile/profile-and-visibility", " New Url"+ app.getURL());
        app.getAtlassian().initChangePhoto();
        app.getAtlassian().uploadPhoto();
        app.getUser().returnToTrelloFromAtlassian();
        String currUrl = app.getURL();
        Assert.assertEquals(currUrl, "https://trello.com/", "Current Url is"+ app.getURL());
    }
}
