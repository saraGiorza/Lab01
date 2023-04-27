package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button cancellaButton;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea esecuzionetxt;
    
    @FXML
    void cancellaParola(ActionEvent event) {
    	long tGetText;
    	long tCancella;
    	long tRiordino;
    	long tRestituisciRisultato;    	
    	
    	long t0 = System.nanoTime();
    	String daCancellare = this.txtResult.getSelectedText();
    	long t1 = System.nanoTime();
    	tGetText = t1-t0;
    	
    	long t2 = System.nanoTime();
    	elenco.cancella(daCancellare);
    	long t3 = System.nanoTime();
    	tCancella = t3-t2;
    	
        String risultato = "";
    	
        long t4 = System.nanoTime();
    	ArrayList<String> paroleOrdinate = (ArrayList<String>) elenco.getElenco();
    	for(String s: paroleOrdinate) {
    		risultato+= s+"\n"; 
    	}
    	long t5 = System.nanoTime();
    	tRiordino = t5-t4;
    	
    	long t6 = System.nanoTime();
    	this.txtResult.setText(risultato);
    	long t7 = System.nanoTime();
    	tRestituisciRisultato = t5-t4;
    	
    	this.esecuzionetxt.setText("opGetText: "+tGetText+"\n"+
                                   "opDelete: "+tCancella+"\n"+
                                   "opSort: "+tRiordino+"\n"+
                                   "opResult: "+tRestituisciRisultato);

    }

    @FXML
    void doInsert(ActionEvent event) {
    	long tGetText;
    	long tAggiuntaParola;
    	long tRiordino;
    	long tRestituisciRisultato;
    	long tPulisciCampoParola;
    	
    	long t0 = System.nanoTime();
    	String p = this.txtParola.getText();
    	long t1 = System.nanoTime();
    	tGetText = t1-t0;
    	
    	long t2 = System.nanoTime();
    	if(p.compareTo("") != 0) {
    	   elenco.addParola(p);
    	}
    	long t3 = System.nanoTime();
    	tAggiuntaParola = t3-t2;
    	
    	String risultato = "";
    	
    	long t4 = System.nanoTime();
    	ArrayList<String> paroleOrdinate = (ArrayList<String>) elenco.getElenco();
    	for(String s: paroleOrdinate) {
    		risultato+= s+"\n"; 
    	}
    	long t5 = System.nanoTime();
    	tRiordino = t5-t4;
    	
    	long t6 = System.nanoTime();
    	this.txtResult.setText(risultato);
    	long t7 = System.nanoTime();
    	tRestituisciRisultato = t7-t6;
    	
    	long t8 = System.nanoTime();
    	this.txtParola.clear();
    	long t9 = System.nanoTime();
    	tPulisciCampoParola = t9-t8;
    	
    	this.esecuzionetxt.setText("opGetText: "+tGetText+"\n"+
    	                           "opAdd: "+tAggiuntaParola+"\n"+
    			                   "opSort: "+tRiordino+"\n"+
    	                           "opResult: "+tRestituisciRisultato+"\n"+
    			                   "opClearInput: "+tPulisciCampoParola);
    }

    @FXML
    void doReset(ActionEvent event) {
    	long tPulisciCampoParola;
    	long tPulisciCampoRis;
    	long tResetDati;
    	
    	long t0 = System.nanoTime();
    	this.txtParola.clear();
    	long t1 = System.nanoTime();
    	tPulisciCampoParola = t1-t0;
    	
    	long t2 = System.nanoTime();
    	this.txtResult.clear();
    	long t3 = System.nanoTime();
    	tPulisciCampoRis = t3-t2;
    	
    	long t4 = System.nanoTime();
    	elenco.reset();
    	long t5 = System.nanoTime();
    	tResetDati = t5-t4;
    	
    	this.esecuzionetxt.setText("opClearInput: "+tPulisciCampoParola+"\n"+
                                   "opClearResult: "+tPulisciCampoRis+"\n"+
                                   "opReset: "+tResetDati);
               

    }

    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cancellaButton != null : "fx:id=\"cancellaButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert esecuzionetxt != null : "fx:id=\"esecuzionetxt\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
