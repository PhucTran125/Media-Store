package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.global.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	private float finalCost = 0;
//	private Store store;
	
	@FXML
    void btnAddBook(ActionEvent event) {
		new AddBookToStoreScreen();
    }

    @FXML
    void btnAddCD(ActionEvent event) {
    	new AddCompactDiscToStoreScreen();
    }

    @FXML
    void btnAddDVD(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen();
    }
    
    @FXML
    void btnViewCart(ActionEvent event) {
    	new CartScreen(cart);
    }
	
	 @FXML
    void btnViewStore(ActionEvent event) {
		 new StoreScreen(StoreScreen.store);
    }
	
	@FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterTitle;


    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Label lbCost;
    
    @FXML
	void btnPlayPressed(ActionEvent event) {
		Media item = tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable)item).play();
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	this.cart.removeMedia(media);
    	tblMedia.refresh();
    	String string = this.cart.totalCost() + " $";
		lbCost.setText(string);
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	float cost;
    	if (finalCost != 0) cost = finalCost;
    	else cost = cart.totalCost();
    	String message = "Total cost of your order is : " + cost + " $\nThanks for buying!";
		JOptionPane.showMessageDialog(null,
		message,"Ordered Successfully",JOptionPane.INFORMATION_MESSAGE);
		cart = new Cart();
		tblMedia.setItems(cart.getItemOrdered());
		tblMedia.refresh();
    }
    
    @FXML
    void btnGetLuckyItemPressed(ActionEvent event) {
    	if (cart.totalCost() > 50) {
    		float cost = 1000;
    		Media iteMedia = null;
    		while (cost > (cart.totalCost()/3)) {
    			iteMedia  = cart.getALuckyItem();
    			cost = iteMedia.getCost();
			}
    		finalCost = cart.totalCost() - cost;
        	String message = "Your lucky item is : " + iteMedia.getTitle() + ": " + iteMedia.getCost() + " &.";
    		JOptionPane.showMessageDialog(null,
    		message,"Lucky Item",JOptionPane.INFORMATION_MESSAGE);
    	}
    	else {
    		String message = "Cannot get lucky number. Total cost is not greater than 50$ for having lucky item.";
    		JOptionPane.showMessageDialog(null,
    		message,"Error",JOptionPane.INFORMATION_MESSAGE);
    	}
    }
    
    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemOrdered());
    	
    	String string = this.cart.totalCost() + " $";
		lbCost.setText(string);
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> arg0, Media oldMedia, Media newMedia) {
				if (newMedia != null) {
					updateButtonBar(newMedia);
				}
			}
    		
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
    	});
    }
    
    void showFilteredMedia(String value) {
    	ObservableList<Media> list = FXCollections.observableArrayList();
//    	list = this.cart.getItemOrdered();
//
//		if (radioBtnFilterId.isSelected()) {
//			list = cart.getMediaById(value);
//		}
//		if (radioBtnFilterTitle.isSelected()) {
//			list = cart.getMedia(value);
//		}
//		tblMedia.setItems(list);
//		tblMedia.refresh();
		
		if (radioBtnFilterTitle.isSelected()){
			for (Media item : cart.getItemOrdered()) {
				if (item.getTitle().toLowerCase().contains(value.toLowerCase())) {
					list.add(item);
				}
			}
			tblMedia.setItems(list);
		}
		else {
				for (Media item : cart.getItemOrdered()) {
				if ((String.valueOf(item.getId())).toString().toLowerCase().contains(value.toLowerCase())) {
					list.add(item);
				}
			}
			tblMedia.setItems(list);
		}
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
		}
    }
}
