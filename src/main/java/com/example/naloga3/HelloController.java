package com.example.naloga3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public TextField znamka;
    public TextField oznaka;
    public Spinner prostornina;
    public ComboBox vrsta;
    public Spinner moc;
    public ComboBox gorivo;
    public Spinner sedezi;
    public TextField ime;
    public TextField naslov;
    public TextField postna;
    public TextField kraj;
    public TextField priimek;
    public DatePicker rojstvo;
    public CheckBox mladi;
    public CheckBox zavarovanje;
    public CheckBox zaStekla;
    public CheckBox naParkiscu;
    public CheckBox zaPotnike;
    public CheckBox protiToci;
    public CheckBox zaGume;
    public CheckBox zaTretjo;
    public CheckBox protiKraji;
    public TextField registrska;
    public TextField krajPrve;
    public DatePicker datume;
    public ComboBox kasko;
    public Button pobrisi;
    public TextField barva;
    public Label status;

    @FXML


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gorivo.getItems().addAll("Bencin", "Diezel", "Plin", "Elektrika");
        gorivo.setValue("Bencin");
        kasko.getItems().addAll("Polno", "Odbitna franšiza", "Brez");
        kasko.setValue("Polno");
        vrsta.getItems().addAll("Osebni avto", "Motor", "Tovornjak", "Traktor", "Avtobus");
        vrsta.setValue("Osebni avto");
        SpinnerValueFactory<Double> valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 600, 70);
        moc.setValueFactory(valueFactory);
        SpinnerValueFactory<Integer> valueFactory1 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, 4);
        sedezi.setValueFactory(valueFactory1);
        SpinnerValueFactory<Double> valueFactory3 =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, 1.0, 0.1);
        prostornina.setValueFactory(valueFactory3);


    }


    public void shraniCB(ActionEvent actionEvent) {
        if (znamka.getText().equals("") || oznaka.getText().equals("") || barva.getText().equals("") ||
                ime.getText().equals("") || priimek.getText().equals("") || naslov.getText().equals("") ||
                kraj.getText().equals("") || postna.getText().equals("") || registrska.getText().equals("") || krajPrve.getText().equals("")) {
            System.out.println(" prazna polja");
            status.setText("Prazna polja");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Opozorilo");
            alert.setHeaderText("Izpolnite vsa polja");
            alert.setContentText("Nekatera polja so prazna, prosim izpolnite vse!");
            alert.showAndWait();

        } else {

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("baza.txt", true));
                writer.write("Podatki o vozilu" + "\n");
                writer.write("Znamka: " + znamka.getText() + "\n");
                writer.write("Moc: " + moc.getValue() + "\n");
                writer.write("Oznaka: " + oznaka.getText() + "\n");
                writer.write("Prostornina: " + prostornina.getValue() + "\n");
                writer.write("Gorivo: " + gorivo.getValue() + "\n");
                writer.write("Barva: " + barva.getText() + "\n");
                writer.write("Število sedežev: " + sedezi.getValue() + "\n");

                writer.write("Zavarovanec" + "\n");
                writer.write("Ime: " + ime.getText() + "\n");
                writer.write("Priimek: " + priimek.getText() + "\n");
                writer.write("Naslov: " + naslov.getText() + "\n");
                writer.write("Kraj: " + kraj.getText() + "\n");
                writer.write("Poštna številka: " + postna.getText() + "\n");
                writer.write("Mladi voznik: " + mladi.isSelected() + "\n");
                writer.write("Rojstni datum: " + rojstvo.getValue() + "\n");

                writer.write("Zavarovanje" + "\n");
                writer.write("Zavarovanje AO+: " + zavarovanje.isSelected() + "\n");
                writer.write("Kasko: " + kasko.getValue() + "\n");
                writer.write("Dodatna zavarovanja: ");
                if (zaStekla.isSelected()) writer.write("Za stekla,");
                if (naParkiscu.isSelected()) writer.write("Na parkirišču,");
                if (zaPotnike.isSelected()) writer.write("Za potnike,");
                if (protiToci.isSelected()) writer.write("Proti toči,");
                if (protiKraji.isSelected()) writer.write("Proti kraji,");
                if (zaGume.isSelected()) writer.write("Za gume,");
                if (zaTretjo.isSelected()) writer.write("Za tretjo osebo,");

                writer.write("Registracija" + "\n");
                writer.write("Registrska označba: " + registrska.getText() + "\n");
                writer.write("Datum prve registracije: " + datume.getValue() + "\n");
                writer.write("Kraj prve registracije: " + krajPrve.getText() + "\n");

                writer.write("\n");


                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void pobrisiCB(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Brisanje obrazca");
        alert.setHeaderText("Ali ste prepričani, da želite ponastaviti obrazec?");
        alert.setContentText("Ta akcija je končna.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            status.setText("Status: Brisanje obrazca");
            znamka.setText("");
            oznaka.setText("");
            barva.setText("");
            ime.setText("");
            naslov.setText("");
            postna.setText("");
            priimek.setText("");
            kraj.setText("");
            registrska.setText("");
            krajPrve.setText("");
        }
    }
}