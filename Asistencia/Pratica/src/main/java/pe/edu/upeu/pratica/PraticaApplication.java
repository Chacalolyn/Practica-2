package pe.edu.upeu.pratica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import static com.sun.javafx.application.ParametersImpl.getParameters;
import static javafx.application.Application.launch;

@SpringBootApplication
public class PraticaApplication extends Application {

    private ConfigurableApplicationContext configurableApplicationContext;
    private Parent parent;

    public static void main(String[] args) {
       // SpringApplication.run(PraticaApplication.class, args);
     launch(args);
    }

    @Override
    public void init() throws Exception {
        //configurableApplicationContext=
        SpringApplication.run(PraticaApplication.class);
        SpringApplicationBuilder builder = new
                SpringApplicationBuilder(PraticaApplication.class);
        builder.application().setWebApplicationType(WebApplicationType.NONE);
        configurableApplicationContext =
                builder.run(getParameters().getRaw().toArray(new String[0]));
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("/fxml/main_asistencia.fxml"));
        fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
        parent = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getBounds();
        stage.setScene(new Scene(parent, bounds.getWidth(), bounds.getHeight() -
                80));
        stage.show();
        stage.setTitle("Spring Java-FX");
        stage.show();
    }

}



