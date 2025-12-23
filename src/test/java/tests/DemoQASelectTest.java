package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.DemoQAButtonsPage;
import pages.demoqa.DemoQADroppablePage;
import pages.demoqa.DemoQASelectPage;
import tests.base.BaseTest;


public class DemoQASelectTest extends BaseTest {


    @Test
    public void navigateBetweenSelectAndButtonsPages() {
        DemoQASelectPage selectPage = new DemoQASelectPage();
        selectPage.open();
        String selectPageTitle = selectPage.getTitle();

        DemoQAButtonsPage buttonsPage = new DemoQAButtonsPage();
        buttonsPage.open();
        String buttonsPageTitle = buttonsPage.getTitle();

        buttonsPage.goBack();
        Assert.assertEquals(selectPage.getTitle(), selectPageTitle,
                "Should return to Select page after going back"
        );

        selectPage.goForward();
        Assert.assertEquals(buttonsPage.getTitle(), buttonsPageTitle,
                "Should return to Buttons page after going forward"
        );

        buttonsPage.reload();
        Assert.assertEquals(buttonsPage.getTitle(), buttonsPageTitle,
                "Title after reload should remain the same"
        );
    }

    @Test
    public void singleSelectTest() {
        // Arrange
        DemoQASelectPage selectPage = new DemoQASelectPage();

        // Act
        selectPage.open();
        selectPage.selectSingleOption("Red");

        // Assert
        Assert.assertEquals(
                selectPage.getSingleValue(),
                "red",
                "Single select value should be 'red'"
        );
    }
    @Test
    public void multiSelectTest() {
        // Arrange
        DemoQASelectPage selectPage = new DemoQASelectPage();

        // Act
        selectPage.open();
        selectPage.selectMultipleOptions("volvo", "saab");

        // Assert
        Assert.assertEqualsNoOrder(
                selectPage.getMultipleValues(),
                new String[]{"Volvo", "Saab"},
                "Selected values should match expected"
        );
    }

    @Test
    public void doubleClickTest() {
        // Arrange
        DemoQAButtonsPage buttonsPage = new DemoQAButtonsPage();

        // Act
        buttonsPage.open();
        buttonsPage.doubleClickButton();

        // Assert
        Assert.assertTrue(
                buttonsPage.isDoubleClickMessageVisible(),
                "Message should appear after double click"
        );
    }

    @Test
    public void dragAndDropTest() {
        DemoQADroppablePage droppablePage = new DemoQADroppablePage();
        droppablePage.open();
        droppablePage.dragToDrop();

        String text = droppablePage.getDropText();
        Assert.assertTrue(text.contains("Dropped!"), "Target text should be 'Dropped!'");
    }
}
