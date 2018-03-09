package sample;



import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

// Från https://stackoverflow.com/questions/31658556/test fx-4-cant-use-simply-verifythat-have-to-use-the-whole-import-name
//import static org.loadui.testfx.Assertions.*;

//import org.junit.jupiter.api.Test;
// import org.testfx.framework.junit.ApplicationTest;

public class ClickApplicationTest extends ApplicationTest {


    @Override public void start(Stage stage) {
        Parent sceneRoot = new ClickApplication.ClickPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void should_contain_button() {
        // expect:
        verifyThat(".button", hasText("click me!"));
    }

    @Test
    public void should_click_on_button() {
        // when:
        clickOn(".button");

        // then:
        verifyThat(".button", hasText("clicked!"));
    }


}