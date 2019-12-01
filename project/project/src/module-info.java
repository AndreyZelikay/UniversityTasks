module javafx {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    opens Main;
    opens Main.Pages.Controllers;
}