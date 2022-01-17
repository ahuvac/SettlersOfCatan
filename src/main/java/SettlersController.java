import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class SettlersController {
    @FXML
    ImageView h0_2;
    @FXML
    ImageView h0_4;
    @FXML
    ImageView h0_6;
    @FXML
    ImageView h1_1;
    @FXML
    ImageView h1_3;
    @FXML
    ImageView h1_5;
    @FXML
    ImageView h1_7;
    @FXML
    ImageView h2_0;
    @FXML
    ImageView h2_2;
    @FXML
    ImageView h2_4;
    @FXML
    ImageView h2_6;
    @FXML
    ImageView h2_8;
    @FXML
    ImageView h3_1;
    @FXML
    ImageView h3_3;
    @FXML
    ImageView h3_5;
    @FXML
    ImageView h3_7;
    @FXML
    ImageView h4_2;
    @FXML
    ImageView h4_4;
    @FXML
    ImageView h4_6;
    @FXML
    Label h0_2Num;
    @FXML
    Label h0_4Num;
    @FXML
    Label h0_6Num;
    @FXML
    Label h1_1Num;
    @FXML
    Label h1_3Num;
    @FXML
    Label h1_5Num;
    @FXML
    Label h1_7Num;
    @FXML
    Label h2_0Num;
    @FXML
    Label h2_2Num;
    @FXML
    Label h2_4Num;
    @FXML
    Label h2_6Num;
    @FXML
    Label h2_8Num;
    @FXML
    Label h3_1Num;
    @FXML
    Label h3_3Num;
    @FXML
    Label h3_5Num;
    @FXML
    Label h3_7Num;
    @FXML
    Label h4_2Num;
    @FXML
    Label h4_4Num;
    @FXML
    Label h4_6Num;
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
    @FXML
    ImageView die1;
    @FXML
    ImageView die2;
    Game game;
    Location roadLocation;
    Location settlementLocation;
    Location cityLocation;
    boolean inBuildRoad;
    boolean inBuildSettlement;
    boolean inBuildCity;
    List<ImageView> hexes;
    ImageView[] dice = new ImageView[2];
    Location hexLocation;
    boolean rolledSeven = false;

    public SettlersController() {
        hexes = new ArrayList<>();
        game = new Game();
        roadLocation = null;
        settlementLocation = null;
    }

    @FXML
    public void initialize() {
        dice[0] = die1;
        dice[1] = die2;
        hexes.add(h0_2);
        hexes.add(h0_4);
        hexes.add(h0_6);
        hexes.add(h1_1);
        hexes.add(h1_3);
        hexes.add(h1_5);
        hexes.add(h1_7);
        hexes.add(h2_0);
        hexes.add(h2_2);
        hexes.add(h2_4);
        hexes.add(h2_6);
        hexes.add(h2_8);
        hexes.add(h3_1);
        hexes.add(h3_3);
        hexes.add(h3_5);
        hexes.add(h3_7);
        hexes.add(h4_2);
        hexes.add(h4_4);
        hexes.add(h4_6);
        List<Label> numbers = new ArrayList<>();
        numbers.add(h0_2Num);
        numbers.add(h0_4Num);
        numbers.add(h0_6Num);
        numbers.add(h1_1Num);
        numbers.add(h1_3Num);
        numbers.add(h1_5Num);
        numbers.add(h1_7Num);
        numbers.add(h2_0Num);
        numbers.add(h2_2Num);
        numbers.add(h2_4Num);
        numbers.add(h2_6Num);
        numbers.add(h2_8Num);
        numbers.add(h3_1Num);
        numbers.add(h3_3Num);
        numbers.add(h3_5Num);
        numbers.add(h3_7Num);
        numbers.add(h4_2Num);
        numbers.add(h4_4Num);
        numbers.add(h4_6Num);
        List<Hex> hexList = game.getHexes();
        for (int i = 0; i < hexList.size(); i++) {
            Hex currentHex = hexList.get(i);
            if (currentHex.type == ResourceType.DESERT) {
                hexes.get(i).setImage(new Image("imgs/hexes/desert.png"));
            }
            else if (currentHex.type == ResourceType.BRICK)
            {
                hexes.get(i).setImage(new Image("imgs/hexes/hill.png"));
            } else if (currentHex.type == ResourceType.ORE) {
                hexes.get(i).setImage(new Image("imgs/hexes/mountain.png"));
            } else if (currentHex.type == ResourceType.WOOL) {
                hexes.get(i).setImage(new Image("imgs/hexes/pasture.png"));
            } else if (currentHex.type == ResourceType.GRAIN) {
                hexes.get(i).setImage(new Image("imgs/hexes/field.png"));
            } else if (currentHex.type == ResourceType.LUMBER) {
                hexes.get(i).setImage(new Image("imgs/hexes/forest.png"));
            }
            if (currentHex.type != ResourceType.DESERT) {
                numbers.get(i).setText(String.valueOf(currentHex.number));
            }
        }
        currentPlayer.setText("CURRENT PLAYER: \n" + game.getCurrentPlayer().toString());
        updateCards();
    }

    public void updateCards() {
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
        if (mouseEvent.getSource() instanceof Button) {
            createDialogBox("Select Road", "Please click on the location where you would like to build a road");
            inBuildRoad = true;
        } else if (mouseEvent.getSource() instanceof ImageView) {
            if (roadLocation != null) {
                boolean bought = game.buyRoad(roadLocation);
                if (bought) {
                    updateCards();
                    ImageView road = (ImageView) mouseEvent.getSource();
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        road.setImage(new Image("imgs/roads/RoadBlue.png"));
                    } else {
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
        if (mouseEvent.getSource() instanceof Button) {
            inBuildSettlement = true;
            createDialogBox("Select Location", "Please click on the location where you would like to build a settlement");
        } else if (mouseEvent.getSource() instanceof Circle) {
            if (settlementLocation != null) {
                boolean bought = game.buySettlement(settlementLocation);
                if (bought) {
                    updateCards();
                    ImageView vertex = (ImageView) mouseEvent.getSource();
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        vertex.setImage(new Image("/resources/imgs/roads/SettlementBlue.png"));
                        //TODO: add onclick for settlement
                    } else {
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
        if (mouseEvent.getSource() instanceof Button) {
            inBuildCity = true;
            createDialogBox("Select Location", "Please click on the settlement where you would like to build a city");
        } else if (mouseEvent.getSource() instanceof ImageView) {
            if (cityLocation != null) {
                boolean bought = game.buyCity(cityLocation);
                if (bought) {
                    updateCards();
                    ImageView vertex = (ImageView) mouseEvent.getSource();
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        vertex.setImage(new Image("/resources/imgs/roads/CityBlue.png"));
                    } else {
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

    public void vertexOnClick(MouseEvent mouseEvent) {
        Circle vertex = (Circle) mouseEvent.getSource();
        String vertexId = vertex.getId();
        settlementLocation = new Location(getRow(vertexId), getColumn(vertexId));
        if (inBuildSettlement) {
            BuildSettlementOnClick(mouseEvent);
        }

    }

    public void settlementOnClick(MouseEvent mouseEvent) {
        ImageView settlement = (ImageView) mouseEvent.getSource();
        String vertexId = settlement.getId();
        cityLocation = new Location(getRow(vertexId), getColumn(vertexId));
        if (inBuildCity) {
            BuildCityOnClick(mouseEvent);
        }
    }

    public int getRow(String id) {
        int underScore = id.indexOf("_");
        String rowString = id.substring(1, underScore);
        return Integer.parseInt(rowString);
    }

    public int getColumn(String id) {
        int underScore = id.indexOf("_");
        String columnString = id.substring(++underScore);
        return Integer.parseInt(columnString);
    }

    public void createDialogBox(String title, String message) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle(title);
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    public void diceOnClick(MouseEvent mouseEvent) {
        int[] roll = game.rollDice();
        for (int i = 0; i < 2; i++) {
            switch (roll[i]) {
                case 1:
                    dice[i].setImage(new Image("imgs/dice/dice/dice-1.png"));
                case 2:
                    dice[i].setImage(new Image("imgs/dice/dice/dice-2.png"));
                case 3:
                    dice[i].setImage(new Image("imgs/dice/dice/dice-3.png"));
                case 4:
                    dice[i].setImage(new Image("imgs/dice/dice/dice-4.png"));
                case 5:
                    dice[i].setImage(new Image("imgs/dice/dice/dice-5.png"));
                case 6:
                    dice[i].setImage(new Image("imgs/dice/dice/dice-6.png"));
            }
        }
        int rolledNum = roll[0] + roll[1];
        if (rolledNum != 7) {
            game.distributeCards(rolledNum);
        } else {
            rolledSeven = true;
            createDialogBox("Choose Location", "Click on the hex where you want to put the robber");
        }
    }

    public void hexClick(MouseEvent event) {
        ImageView hex = (ImageView) event.getSource();
        String id = hex.getId();
        hexLocation = new Location(getRow(id), getColumn(id));
        if(rolledSeven){
            game.playRobber(hexLocation);
            // TODO put the robber into that hexLocation on the gui
        }
         rolledSeven = false;
    }

    public void setUpBeginning(){
        //game
        createDialogBox("Choose location", "Please choose the location for your first settlement.");

    }
}
