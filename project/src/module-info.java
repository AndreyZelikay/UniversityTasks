module javafx {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;

    opens Main;
    opens Main.Pages.Controllers;
}