package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.security.Key;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Controller {

    Interpolator animationTime = Interpolator.EASE_BOTH;
    DropShadow shadow = new DropShadow();
    @FXML
    Button myButton;

    @FXML
    public void test() throws Exception
    {

        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(0.3),new KeyValue(myButton.translateYProperty(),-10,animationTime)));

       // animation.getKeyFrames().addAll(),
        //));
        animation.play();

    }

    @FXML
    public void exit()
    {

//
//        TranslateTransition hoverup = new TranslateTransition(Duration.seconds(0.3),myButton);
//        hoverup.setToY(0);
//
//        hoverup.play();
        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(0.3),new KeyValue(myButton.translateYProperty(),0,animationTime)),
                new KeyFrame(Duration.seconds(0.3),new KeyValue(myButton.styleProperty(), "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.09), 10, 0, 0, 8);" ,animationTime)));
        // animation.getKeyFrames().addAll(),
        //));
        animation.play();

    }
}
