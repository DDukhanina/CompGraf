module com.example.comgrtask2_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.vsu.cs.gr12_2.dda to javafx.fxml;
    exports ru.vsu.cs.gr12_2.dda;
}