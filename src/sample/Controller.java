package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

enum Operation {
    ADDITION, MULTIPLICATION, SUBTRACTION, DIVISION
}

public class Controller implements Initializable {

    public Operation op;
    double data;
    List<Button> buttonList = new ArrayList<Button>();
    @FXML
    private TextField display;
    @FXML
    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    @FXML
    private Button clear, equal, plus, minus, multiply, divide;

    @FXML
    private void handleNumberAction(javafx.event.ActionEvent event) {
        if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        }
    }

    @FXML
    private void handleOperationAction(javafx.event.ActionEvent event) {
        if (event.getSource() == clear) {
            display.setText("");
        } else if (event.getSource() == plus) {
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.ADDITION;
        } else if (event.getSource() == minus) {
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.SUBTRACTION;
        } else if (event.getSource() == multiply) {
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.MULTIPLICATION;
        } else if (event.getSource() == divide) {
            data = Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.DIVISION;
        } else if (event.getSource() == equal) {
            double secondNumber = Double.parseDouble(display.getText());
            if (op == Operation.ADDITION) {
                double result = data + secondNumber;
                display.setText(String.valueOf(result));
            } else if (op == Operation.SUBTRACTION) {
                double result = data - secondNumber;
                display.setText(String.valueOf(result));
            } else if (op == Operation.MULTIPLICATION) {
                double result = data * secondNumber;
                display.setText(String.valueOf(result));
            } else if (op == Operation.DIVISION) {
                try {
                    double result = data / secondNumber;
                    display.setText(String.valueOf(result));
                } catch (Exception e) {
                    display.setText("Error !");
                }
            }
        }
    }

    @FXML
    private void enableClear(javafx.event.ActionEvent event) {
        clear.setDisable(false);
    }

    @FXML
    private void disableClear(javafx.event.ActionEvent event) {
        clear.setDisable(true);
    }

    @FXML
    private void applyDarkStyle(javafx.event.ActionEvent event) {
        for (Button button : buttonList) {
            button.setStyle("-fx-background-color: black;" + "-fx-text-fill: white;" + "-fx-border-width: 2;"
                    + "-fx-border-color: white;");
        }
    }

    @FXML
    private void applyLightStyle(javafx.event.ActionEvent event) {
        for (Button button : buttonList) {
            button.setStyle("-fx-background-color: white;" + "-fx-text-fill: black;" + "-fx-border-width: 2;"
                    + "-fx-border-color: black;");
        }
    }

    @FXML
    private void closeAction(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        display.setEditable(false);

        buttonList.add(zero);
        buttonList.add(one);
        buttonList.add(two);
        buttonList.add(three);
        buttonList.add(four);
        buttonList.add(five);
        buttonList.add(six);
        buttonList.add(seven);
        buttonList.add(eight);
        buttonList.add(nine);
        buttonList.add(equal);
        buttonList.add(clear);
        buttonList.add(plus);
        buttonList.add(minus);
        buttonList.add(multiply);
        buttonList.add(divide);
    }
}