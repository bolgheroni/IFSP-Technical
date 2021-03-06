package JoaoSupermarket.Data;

import java.io.File;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import JoaoSupermarket.MainApp;
import JoaoSupermarket.Model.ProdutoListaWrapper;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ManageFile {
	 // Methods to save user's preferences
    public static File getProdutoFilePath() {
    	Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
    	String filePath = prefs.get("filePath", null);
    	if (filePath != null) {
    		return new File(filePath);
    	}
    	else {
    		return null;
    	}
    }

    /*
     *	Sets the file path of the currently loaded file, the path
     *	might change depending on the OS specific registry
     */
    public static void setProdutoFilePath(File file, MainApp mainApp) {
    	Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
    	if (file != null) {
    		prefs.put("filePath", file.getPath());

    		// Update the stage title
    		mainApp.getPrimaryStage().setTitle("Vendinha do Seu Jo�o - " + file.getName());
    	}
    	else {
    		prefs.remove("filePath");

    		// Update the stage title
    		mainApp.getPrimaryStage().setTitle("Vendinha do Seu Jo�o");
    	}
    }

 // Methods responsible to READ and WRITE data with JAXB (Java Architecture XML Binding)

    // Method to load Produto data from file
    public static void loadProdutoDataFromFile(File file, MainApp mainApp) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ProdutoListaWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling
            ProdutoListaWrapper wrapper = (ProdutoListaWrapper) um.unmarshal(file);

            mainApp.getProdutosDados().clear();
            mainApp.getProdutosDados().addAll(wrapper.getProdutos());

            // Save the file path to the registry.
            setProdutoFilePath(file, mainApp);

        }
        catch (Exception e) { // catches ANY exception
        	System.out.println(e.getMessage());

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("N�o foi poss�vel carregar os dados!");
            alert.setContentText("N�o foi poss�vel carregar os dados do arquivo:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    // Method to save Produto data to the file
    public static void saveProdutoDataToFile(File file, MainApp mainApp) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ProdutoListaWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping (embrulhando) our Produto data.
            ProdutoListaWrapper wrapper = new ProdutoListaWrapper();
            wrapper.setProdutos(mainApp.getProdutosDados());

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setProdutoFilePath(file, mainApp);
        } catch (Exception e) { // catches ANY exception
        	System.out.println(e.getMessage());

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("N�o foi poss�vel salvar os dados!");
            alert.setContentText("N�o foi poss�vel salvar os dados no arquivo:\n" + file.getPath());

            alert.showAndWait();
        }
    }
}
