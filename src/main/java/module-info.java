module com.example.projectnomina {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.google.gson;

    opens com.example.projectnomina to javafx.fxml;
    exports com.example.projectnomina;
}