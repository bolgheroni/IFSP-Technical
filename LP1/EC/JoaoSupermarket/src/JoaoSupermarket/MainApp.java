package JoaoSupermarket;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import JoaoSupermarket.Model.*;
import JoaoSupermarket.View.*;
import JoaoSupermarket.Data.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ObservableList<Produto> produtosDados = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;

    // Standard Constructor
    public MainApp() {
        // Produtos
        produtosDados.add(new Produto("Banana", 50, 30, LocalDate.now().plusDays(1), "Fruits"));
        produtosDados.add(new Produto("Apple", 80, 50, LocalDate.now().plusDays(2), "Fruits"));
        produtosDados.add(new Produto("Pear", 35, 15, LocalDate.now().plusDays(3), "Fruits"));
        produtosDados.add(new Produto("Cellphone", 12, 5, LocalDate.now().plusYears(5), "Electronics"));
    }

    public ObservableList<Produto> getProdutosDados() {
        return produtosDados;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JoaoSupermarket");

        try {
        // Configuring an icon the Scene (window to be displayed)
        this.primaryStage.getIcons().add(new Image("file:extraResources/Hiper-Supermercados.png"));
        }
        catch (Exception exc) {
           // Nothing to be done
        }

        initRootLayout();

        showWelcomeOverview();
    }

    // Initializes the root layout.
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the RootLayoutController access to the MainApp (class)
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Try to load last opened person file.
        File file = ManageFile.getProdutoFilePath();
        if (file != null) {
            ManageFile.loadProdutoDataFromFile(file, this);;
        }
    }

    // Shows the Produto overview inside the root layout.
    public void showWelcomeOverview() {
        try {
            // Load welcome overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/ProdutoOverview.fxml"));
            AnchorPane produtoOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(produtoOverview);

            // Give the Controller access to the Main App
            ProdutoOverviewController controller = loader.getController();
            controller.setMainApp(this);

            //primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     *	Method to edit Produto details and if the user clicks OK and everything
     *	goes fine, it returns true, false otherwise.
     */
    public boolean showProdutoEditDialog(Produto produto) {
        try {
            // Load the FXML file and create a new stage to show edit dialog
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/ProdutoEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog stage ("scene")
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar Produto");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the Produto into the "ProductEditDialogController" (Controller)
            ProductEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduto(produto);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.clicouOK();
        }
        catch (Exception exc) {
            exc.printStackTrace();
            return false;
        }
    }

    // Returns the main stage
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
