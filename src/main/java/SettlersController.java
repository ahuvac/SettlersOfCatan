import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SettlersController {
    @FXML
    ImageView hex1;
    @FXML
    ImageView hex2;
    @FXML
    ImageView hex3;
    @FXML
    ImageView hex4;
    @FXML
    ImageView hex5;
    @FXML
    ImageView hex6;
    @FXML
    ImageView hex7;
    @FXML
    ImageView hex8;
    @FXML
    ImageView hex9;
    @FXML
    ImageView hex10;
    @FXML
    ImageView hex11;
    @FXML
    ImageView hex12;
    @FXML
    ImageView hex13;
    @FXML
    ImageView hex14;
    @FXML
    ImageView hex15;
    @FXML
    ImageView hex16;
    @FXML
    ImageView hex17;
    @FXML
    ImageView hex18;
    @FXML
    ImageView hex19;
    Game game;
    Location roadLocation;
    Location vertexLocation;

    public SettlersController()
    {
        game = new Game();
        roadLocation = new Location(1,4);
        vertexLocation = null;
        initializeBoard();
    }

    public void initializeBoard()
    {
        List<ImageView> hexes = new ArrayList<>();
        hexes.add(hex1);

    }

    public void Player1GrainCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player1LumberCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player1WoolCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player1OreCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player1BrickCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player2GrainCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player2LumberCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player2WoolCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player2OreCardOnClick(MouseEvent mouseEvent) {
    }

    public void Player2BrickCardOnClick(MouseEvent mouseEvent) {
    }

    public void BuildRoadOnClick(MouseEvent mouseEvent) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        //dialog.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("Please click on the location that you would like to build your road"));

        Button button = new Button("Ok");
        dialogVbox.getChildren().add(new Button("Ok"));
        button.setOnAction((e) -> {
            dialog.close();
        });
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
//        while(roadLocation == null)
//        {
//
//        }
//        boolean bought = game.buyRoad(roadLocation);
//        if (!bought)
//        {
//            roadLocation = null;
//            BuildRoadOnClick(mouseEvent);
//        }
//        roadLocation = null;
    }

    public void BuildSettlementOnClick(MouseEvent mouseEvent) {
    }

    public void BuildCityOnClick(MouseEvent mouseEvent) {
    }

    public void BuyDevCardOnClick(MouseEvent mouseEvent) {
    }

    public void UseDevCardOnClick(MouseEvent mouseEvent) {
    }

    public void FinishTurnOnClick(MouseEvent mouseEvent) {
        game.switchPlayer();
        //TODO: add gui stuff
    }



    public void RoadOnClick(MouseEvent mouseEvent) {
       Control road = (Control) mouseEvent.getSource();
       String roadId = road.getId();
       roadLocation = new Location(getRow(roadId), getColumn(roadId));
    }

    public void VertexOnClick(MouseEvent mouseEvent)
    {
        Control vertex = (Control) mouseEvent.getSource();
        String vertexId = vertex.getId();
        vertexLocation = new Location(getRow(vertexId), getColumn(vertexId));
    }

    public int getRow(String id)
    {
        int underScore = id.indexOf("_");
        String rowString = id.substring(1, underScore);
        return Integer.parseInt(rowString);
    }

    public int getColumn(String id)
    {
        int underScore = id.indexOf("_");
        String columnString = id.substring(++underScore);
        return Integer.parseInt(columnString);
    }

    public void vertexOnClick(MouseEvent mouseEvent) {
    }
}
