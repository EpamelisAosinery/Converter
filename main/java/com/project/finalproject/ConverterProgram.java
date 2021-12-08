package com.project.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;

//import static com.project.finalproject.LoadEnum.*;

public class ConverterProgram extends Application {
    private final String style_css = getSourcePath("css/style.css");
    private static final ComboBox<String> cmb_Measurement = new ComboBox<>();
    private static final ComboBox<String> cmb_UnitInput = new ComboBox<>();
    private static final ComboBox<String> cmb_UnitOutput = new ComboBox<>();
    private TextField txtFld_Input;
    private TextField txtFld_Output;
    private static String measurementSelected;
    private static String inputSelected;
    private static String outputSelected;

    private final Measurements[] measurementTypes = Measurements.values();
    private final Length[] lengths = Length.values();
    private final Temperature[] temperature = Temperature.values();
//    private final LoadEnum.Length[] length = Length.values();
//    private final Measurements.Length[] lengths = Measurements.Length;
//    private final LoadEnum.Temperature[] temperatures = Temperature.values();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Measurement"); tab1.setClosable(false);
        Tab tab2 = new Tab("Currency"); tab2.setClosable(false);

        tabPane.getTabs().addAll(tab1, tab2);

        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(tabPane, 15.0);
        AnchorPane.setRightAnchor(tabPane, 15.0);
        AnchorPane.setBottomAnchor(tabPane, 15.0);
        AnchorPane.setLeftAnchor(tabPane, 15.0);
        pane.getChildren().addAll(tabPane);

        Scene scene = new Scene(pane,420,275);
        scene.getStylesheets().add(style_css);

        measurementTab(tab1);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
        primaryStage.show();


    }
    //#################### Measurement Tab ####################
    public void measurementTab(Tab tab1) {
        GridPane tab1_grid = new GridPane(); tab1_grid.setId("default_format");
        tab1_grid.setAlignment(Pos.TOP_LEFT);
        tab1_grid.setHgap(10);
        tab1_grid.setVgap(10);
        tab1_grid.setPadding(new Insets(18, 25, 25, 25));

        System.out.println(Arrays.toString(measurementTypes));
        System.out.println(Arrays.toString(lengths));
        System.out.println(Arrays.toString(temperature));
        /*ComboBox<String> cmb_Measurement = new ComboBox<>();*/
        //cmb_Measurement.getItems().addAll("Length","Temperature"); cmb_Measurement.setId("cmb_format");
//        for(LoadEnum.Measurements type : measurementTypes) {
//            cmb_Measurement.getItems().add(String.valueOf(type));
//        }

        txtFld_Input = new TextField();
        txtFld_Output = new TextField();

//        /*ComboBox<String> cmb_UnitInput = new ComboBox<>();
//        ComboBox<String> cmb_UnitOutput = new ComboBox<>();*/

sssssss
        tab1_grid.add(cmb_Measurement,0,1);
        tab1_grid.add(txtFld_Input, 0,2);
        tab1_grid.add(txtFld_Output,2,2);
        tab1_grid.add(cmb_UnitInput,0,3);
        tab1_grid.add(cmb_UnitOutput,2,3);

        tab1.setContent(tab1_grid);

        measurementOnChange(cmb_Measurement);
    }

    //#################### Currency Tab ####################


    //#################### Get Measurement Type On Change ####################
    private void measurementOnChange(ComboBox<String> cmbB) {
        cmbB.valueProperty().addListener((observableValue, old_Value, new_Value) -> {
            measurementSelected = new_Value;
            System.out.println("Measurement select on change " + measurementSelected);
        });
    }
    //#################### Get URL Source ####################
    private String getSourcePath(String path) {
        URL url = this.getClass().getResource(path);
        if (url == null) {
            System.out.println("Resource not found. Aborting.");
            System.exit(-1);
        }
        return url.toExternalForm();
    }
    //#################### Validation ####################
    private boolean isValidate() {
        return false;
    }
}
