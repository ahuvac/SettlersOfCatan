import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.io.File;
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
    @FXML
    Label hex1Num;
    @FXML
    Label hex2Num;
    @FXML
    Label hex3Num;
    @FXML
    Label hex4Num;
    @FXML
    Label hex5Num;
    @FXML
    Label hex6Num;
    @FXML
    Label hex7Num;
    @FXML
    Label hex8Num;
    @FXML
    Label hex9Num;
    @FXML
    Label hex10Num;
    @FXML
    Label hex11Num;
    @FXML
    Label hex12Num;
    @FXML
    Label hex13Num;
    @FXML
    Label hex14Num;
    @FXML
    Label hex15Num;
    @FXML
    Label hex16Num;
    @FXML
    Label hex17Num;
    @FXML
    Label hex18Num;
    @FXML
    Label hex19Num;
    @FXML
    Label currentPlayer;
    @FXML
    Label Player2GrainAmnt;
    @FXML
    Label Player2WoolAmnt;
    @FXML
    Label Player2LumberAmnt;
    @FXML
    Label Player2OreAmnt;
    @FXML
    Label Player2BrickAmnt;
    @FXML
    Label Player2DevCardAmnt;
    Game game;
    Location roadLocation;
    Location settlementLocation;
    Location cityLocation;
    boolean inBuildRoad;
    boolean inBuildSettlement;
    boolean inBuildCity;
    List<ImageView> hexes;

    public SettlersController()
    {
        hexes = new ArrayList<>();
        game = new Game();
        roadLocation = null;
        settlementLocation = null;
    }

    @FXML
    public void initialize()
    {
        hexes.add(hex1);
        hexes.add(hex2);
        hexes.add(hex3);
        hexes.add(hex4);
        hexes.add(hex5);
        hexes.add(hex6);
        hexes.add(hex7);
        hexes.add(hex8);
        hexes.add(hex9);
        hexes.add(hex10);
        hexes.add(hex11);
        hexes.add(hex12);
        hexes.add(hex13);
        hexes.add(hex14);
        hexes.add(hex15);
        hexes.add(hex16);
        hexes.add(hex17);
        hexes.add(hex18);
        hexes.add(hex19);
        List<Label> numbers = new ArrayList<>();
        numbers.add(hex1Num);
        numbers.add(hex2Num);
        numbers.add(hex3Num);
        numbers.add(hex4Num);
        numbers.add(hex5Num);
        numbers.add(hex6Num);
        numbers.add(hex7Num);
        numbers.add(hex8Num);
        numbers.add(hex9Num);
        numbers.add(hex10Num);
        numbers.add(hex11Num);
        numbers.add(hex12Num);
        numbers.add(hex13Num);
        numbers.add(hex14Num);
        numbers.add(hex15Num);
        numbers.add(hex16Num);
        numbers.add(hex17Num);
        numbers.add(hex18Num);
        numbers.add(hex19Num);
        List<Hex> hexList = game.getHexes();
        for (int i = 0; i < hexList.size(); i++) {
            Hex currentHex = hexList.get(i);
            if (currentHex.type == ResourceType.DESERT)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/desert.png"));
                //TODO: put robber
            }
            else if (currentHex.type == ResourceType.BRICK)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/hill.png"));
            }
            else if (currentHex.type == ResourceType.ORE)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/mountain.png"));
            }
            else if (currentHex.type == ResourceType.WOOL)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/pasture.png"));
            }
            else if (currentHex.type == ResourceType.GRAIN)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/field.png"));
            }
            else if (currentHex.type == ResourceType.LUMBER)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/forest.png"));
            }
            if (currentHex.type != ResourceType.DESERT) {
                numbers.get(i).setText(String.valueOf(currentHex.number));
            }
        }
        currentPlayer.setText("CURRENT PLAYER: \n" + game.getCurrentPlayer().toString());
        updateCards();
    }

    public void updateCards()
    {
        Player2BrickAmnt.setText(String.valueOf(game.getCurrentPlayer().getCardAmount(ResourceType.BRICK)));
        Player2WoolAmnt.setText(String.valueOf(game.getCurrentPlayer().getCardAmount(ResourceType.WOOL)));
        Player2LumberAmnt.setText(String.valueOf(game.getCurrentPlayer().getCardAmount(ResourceType.LUMBER)));
        Player2GrainAmnt.setText(String.valueOf(game.getCurrentPlayer().getCardAmount(ResourceType.GRAIN)));
        Player2OreAmnt.setText(String.valueOf(game.getCurrentPlayer().getCardAmount(ResourceType.ORE)));
        Player2DevCardAmnt.setText(String.valueOf(game.getCurrentPlayer().getDevCardAmount()));
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
        if (mouseEvent.getSource() instanceof Button)
        {
            createDialogBox("Select Road","Please click on the location where you would like to build a road");
            inBuildRoad = true;
        }
        else if (mouseEvent.getSource() instanceof ImageView)
        {
            if (roadLocation != null) {
                boolean bought = game.buyRoad(roadLocation);
                if (bought) {
                    updateCards();
                    ImageView road = (ImageView) mouseEvent.getSource();
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        road.setImage(new Image("imgs/roads/RoadBlue.png"));
                    }
                    else
                    {
                        road.setImage(new Image("imgs/roads/RoadRed.png"));
                    }
                }
                if (!bought) {
                    createDialogBox("Invalid Move", "That move was not valid. Either you do not have enough \n" +
                            "resources, or the location was not legal. Try another move or \nselect 'Finish Turn'");
                }
            }

            inBuildRoad = false;
        }
        roadLocation = null;
    }

    public void BuildSettlementOnClick(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button)
        {
            inBuildSettlement = true;
            createDialogBox("Select Location","Please click on the location where you would like to build a settlement");
        }
        else if (mouseEvent.getSource() instanceof Circle)
        {
            if (settlementLocation != null) {
                boolean bought = game.buySettlement(settlementLocation);
                if (bought) {
                    updateCards();
                    ImageView vertex = (ImageView) mouseEvent.getSource();
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        vertex.setImage(new Image("/resources/imgs/roads/SettlementBlue.png"));
                        //TODO: add onclick for settlement
                    }
                    else
                    {
                        vertex.setImage(new Image("/resources/imgs/roads/SettlementRed.png"));
                        //TODO: add onclick for settlement
                    }
                }
                if (!bought) {
                    createDialogBox("Invalid Move", "That move was not valid. Either you do not have enough \n" +
                            "resources, or the location was not legal. Try another move \n or select 'Finish Turn'");
                }
            }

            inBuildSettlement = false;
        }
        settlementLocation = null;
    }

    public void BuildCityOnClick(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button)
        {
            inBuildCity = true;
            createDialogBox("Select Location","Please click on the settlement where you would like to build a city");
        }
        else if (mouseEvent.getSource() instanceof ImageView)
        {
            if (cityLocation != null) {
                boolean bought = game.buyCity(cityLocation);
                if (bought) {
                    updateCards();
                    ImageView vertex = (ImageView) mouseEvent.getSource();
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        vertex.setImage(new Image("/resources/imgs/roads/CityBlue.png"));
                    }
                    else
                    {
                        vertex.setImage(new Image("/resources/imgs/roads/CityRed.png"));
                    }
                }
                if (!bought) {
                    createDialogBox("Invalid Move", "That move was not valid. Either you do not have enough \n" +
                            "resources, or the location was not legal. Try another move\n or select 'Finish Turn'");
                }
            }

            inBuildCity = false;
        }
        cityLocation = null;
    }

    public void BuyDevCardOnClick(MouseEvent mouseEvent) {
    }

    public void UseDevCardOnClick(MouseEvent mouseEvent) {
    }

    public void FinishTurnOnClick(MouseEvent mouseEvent) {
        String message = "The players are now being switched. " + game.getCurrentPlayer().toString() + " Player should" +
                " step \naway from the screen and the next player should come to \nthe screen.";
        createDialogBox("Switch Turn", message);
        game.switchPlayer();
        updateCards();
        currentPlayer.setText("CURRENT PLAYER: \n" + game.getCurrentPlayer().toString());
    }



    public void RoadOnClick(MouseEvent mouseEvent) {
       ImageView road = (ImageView) mouseEvent.getSource();
       String roadId = road.getId();
       roadLocation = new Location(getRow(roadId), getColumn(roadId));
       if (inBuildRoad) {
           BuildRoadOnClick(mouseEvent);
       }
    }

    public void vertexOnClick(MouseEvent mouseEvent)
    {
        Circle vertex = (Circle) mouseEvent.getSource();
        String vertexId = vertex.getId();
        settlementLocation = new Location(getRow(vertexId), getColumn(vertexId));
        if (inBuildSettlement) {
            BuildSettlementOnClick(mouseEvent);
        }

    }

    public void settlementOnClick(MouseEvent mouseEvent)
    {
        ImageView settlement = (ImageView) mouseEvent.getSource();
        String vertexId = settlement.getId();
        cityLocation = new Location(getRow(vertexId), getColumn(vertexId));
        if (inBuildCity) {
            BuildCityOnClick(mouseEvent);
        }
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

    public void createDialogBox(String title, String message)
    {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle(title);
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    public void diceOnClick(MouseEvent mouseEvent) {
    }
}
