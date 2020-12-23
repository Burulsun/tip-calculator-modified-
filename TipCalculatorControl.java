package TipCalculatorSimple;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;


public class TipCalculatorControl {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    @FXML
    private Label amountLabel;

    @FXML
    private Label percentageLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private Button calculateButton;

    @FXML
    private Label numberOfPeople;

    @FXML
    private TextField numberOfPeopletextField;

    @FXML
    private Label amountForEachLabel;

    @FXML
    private TextField forEachTextField;

//    @FXML
//    void calculateButtonMethod(ActionEvent event) {
////        try {
////            BigDecimal amount = new BigDecimal(amountTextField.getText());
////            BigDecimal tip = amount.multiply(tipPercentage);
////            BigDecimal total = amount.add(tip);
////            tipTextField.setText(currency.format(tip));
////            totalTextField.setText(currency.format(total));
////        }catch (NumberFormatException ex){
////            amountTextField.setText("Enter amount");
////            amountTextField.selectAll();
////            amountTextField.requestFocus();
////        }
//    }


    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                tipPercentage = BigDecimal.valueOf(t1.intValue()/100.0);
                percentageLabel.setText(percent.format(tipPercentage));
                calculate();
            }

        });


    }
    void calculate(){
        try {
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
        }catch (NumberFormatException ex){
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }




}
