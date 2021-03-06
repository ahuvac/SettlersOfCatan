import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class SettlersController {
    @FXML
    GridPane StartPane;
    @FXML
    Label startLabel;
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
    @FXML
    ImageView h0_2Robber;
    @FXML
    ImageView h0_4Robber;
    @FXML
    ImageView h0_6Robber;
    @FXML
    ImageView h1_1Robber;
    @FXML
    ImageView h1_3Robber;
    @FXML
    ImageView h1_5Robber;
    @FXML
    ImageView h1_7Robber;
    @FXML
    ImageView h2_0Robber;
    @FXML
    ImageView h2_2Robber;
    @FXML
    ImageView h2_4Robber;
    @FXML
    ImageView h2_6Robber;
    @FXML
    ImageView h2_8Robber;
    @FXML
    ImageView h3_1Robber;
    @FXML
    ImageView h3_3Robber;
    @FXML
    ImageView h3_5Robber;
    @FXML
    ImageView h3_7Robber;
    @FXML
    ImageView h4_2Robber;
    @FXML
    ImageView h4_4Robber;
    @FXML
    ImageView h4_6Robber;
    @FXML
    GridPane devCardPane;
    @FXML
    Label Player2DevCardAmnt1;
    @FXML
    Label Player2DevCardAmnt11;
    @FXML
    Label Player2DevCardAmnt111;
    @FXML
    Label Player2DevCardAmnt1111;
    @FXML
    Label Player2DevCardAmnt11111;
    @FXML
    GridPane fireworksPane;
    @FXML
    Label gameOverLabel;
    ImageView road1;
    Game game;
    Location roadLocation;
    Location settlementLocation;
    Location cityLocation;
    boolean inBuildRoad;
    boolean inBuildSettlement;
    boolean inBuildCity;
    List<ImageView> hexes;
    List<ImageView> robbers;
    ImageView[] dice = new ImageView[2];
    Location hexLocation;
    boolean rolledSeven = false;
    boolean preGame = true;
    boolean preGameSettlement = true;
    boolean preGameSwitch = false;
    ResourceType resourceType = null;
    boolean inMonopoly = false;
    boolean inYearOfPlenty = false;
    boolean inKnight = false;
    boolean inRoadBuilding = false;

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
        robbers = new ArrayList<>();
        robbers.add(h0_2Robber);
        robbers.add(h0_4Robber);
        robbers.add(h0_6Robber);
        robbers.add(h1_1Robber);
        robbers.add(h1_3Robber);
        robbers.add(h1_5Robber);
        robbers.add(h1_7Robber);
        robbers.add(h2_0Robber);
        robbers.add(h2_2Robber);
        robbers.add(h2_4Robber);
        robbers.add(h2_6Robber);
        robbers.add(h2_8Robber);
        robbers.add(h3_1Robber);
        robbers.add(h3_3Robber);
        robbers.add(h3_5Robber);
        robbers.add(h3_7Robber);
        robbers.add(h4_2Robber);
        robbers.add(h4_4Robber);
        robbers.add(h4_6Robber);

        List<Hex> hexList = game.getHexes();
        for (int i = 0; i < hexList.size(); i++) {
            Hex currentHex = hexList.get(i);
            if (currentHex.type == ResourceType.DESERT) {
                hexes.get(i).setImage(new Image("imgs/hexes/desert.png"));
                robbers.get(i).setVisible(true);
            } else if (currentHex.type == ResourceType.BRICK) {
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
        String labelText = "ARE YOU READY?\n\nRED VS. BLUE\n\nSTARTING PLAYER IS " + game.getCurrentPlayer().toString();
        startLabel.setText(labelText);
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

    public void determineDevCard(ResourceType type)
    {
        if(inMonopoly)
        {
            game.playMonopoly(type);
            inMonopoly = false;
        }
        else if(inYearOfPlenty && resourceType != null)
        {
            game.playYearOfPlenty(resourceType, type);
            inYearOfPlenty = false;
            resourceType = null;
        }
        else if(inYearOfPlenty && resourceType == null)
        {
            resourceType = type;
            chooseResourceType();
        }
        updateCards();
    }

    public void Player2GrainCardOnClick(MouseEvent mouseEvent) {
        determineDevCard(ResourceType.GRAIN);
    }

    public void Player2LumberCardOnClick(MouseEvent mouseEvent) {
        determineDevCard(ResourceType.LUMBER);
    }

    public void Player2WoolCardOnClick(MouseEvent mouseEvent) {
        determineDevCard(ResourceType.WOOL);
    }

    public void Player2OreCardOnClick(MouseEvent mouseEvent) {
        determineDevCard(ResourceType.ORE);
    }

    public void Player2BrickCardOnClick(MouseEvent mouseEvent) {
        determineDevCard(ResourceType.BRICK);
    }

    public void BuildRoadOnClick(MouseEvent mouseEvent) {
        if (!game.isRolled() && !preGame) {
            createDialogBox("Error", "You must roll the dice first");
        } else {
            if (mouseEvent.getSource() instanceof Button && !preGame) {
                createDialogBox("Select Road", "Please click on the location where you would like to build a road");
                if (!inRoadBuilding) {
                    inBuildRoad = true;
                }
            } else if (mouseEvent.getSource() instanceof ImageView && !inRoadBuilding) {
                if (roadLocation != null) {
                    boolean bought;
                    if (preGame && !game.connected(roadLocation, settlementLocation)) {
                        bought = false;
                    } else {
                        bought = game.buyRoad(roadLocation);
                    }
                    if (bought) {
                        updateCards();
                        ImageView road = (ImageView) mouseEvent.getSource();
                        if (game.getCurrentPlayer().color == Color.BLUE) {
                            road.setImage(new Image("imgs/roads/RoadBlue.png"));
                        } else {
                            road.setImage(new Image("imgs/roads/RoadRed.png"));
                        }
                        if (preGame) {
                            nextPlayerSetUp();
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
    }

    private void nextPlayerSetUp() {
        if (game.getOtherPlayer().getRoads() == 15) {
            preGameSwitch = true;
            FinishTurnOnClick(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
                    MouseButton.PRIMARY, 1, true, true, true, true,
                    true, true, true, true, true,
                    true, null));
            preGameSwitch = false;
            setUpBeginning();
        } else if (game.getCurrentPlayer().getRoads() == 14) {
            setUpBeginning();
        } else if (game.getCurrentPlayer().getRoads() == 13) {
            preGameSwitch = true;
            FinishTurnOnClick(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
                    MouseButton.PRIMARY, 1, true, true, true, true,
                    true, true, true, true, true,
                    true, null));
            if (game.getCurrentPlayer().getRoads() == 13) {
                preGame = false;
            } else {
                setUpBeginning();
            }
            preGameSwitch = false;
        }
    }

    public void BuildSettlementOnClick(MouseEvent mouseEvent) {
        if (!game.isRolled() && !preGame) {
            createDialogBox("Error", "You must roll the dice first");
        } else {
            if (mouseEvent.getSource() instanceof Button && !preGame) {
                inBuildSettlement = true;
                createDialogBox("Select Location", "Please click on the location where you would like to build a settlement");
            } else if (mouseEvent.getSource() instanceof Circle) {
                if (settlementLocation != null) {
                    boolean bought = game.buySettlement(settlementLocation, preGame);
                    if (bought) {
                        updateCards();
                        Circle vertex = (Circle) mouseEvent.getSource();
                        if (game.getCurrentPlayer().color == Color.BLUE) {
                            vertex.setFill(Paint.valueOf("BLUE"));
                        } else {
                            vertex.setFill(Paint.valueOf("RED"));
                        }
                        if (preGame) {
                            preGameSettlement = false;
                            createDialogBox("Build road", "Please choose the location for your road.");
                        }
                    }
                    if (!bought) {
                        createDialogBox("Invalid Move", "That move was not valid. Either you do not have enough \n" +
                                "resources, or the location was not legal. Try another move \n or select 'Finish Turn'");
                    }
                }

                inBuildSettlement = false;
            }
            if (!preGame) {
                settlementLocation = null;
            }
        }
    }

    public void BuildCityOnClick(MouseEvent mouseEvent) {
        if (!game.isRolled() && !preGame) {
            createDialogBox("Error", "You must roll the dice first");
        } else if (!preGame) {
            if (mouseEvent.getSource() instanceof Button) {
                inBuildCity = true;
                createDialogBox("Select Location", "Please click on the settlement where you would like to build a city");
            } else if (mouseEvent.getSource() instanceof Circle) {
                if (cityLocation != null) {
                    boolean bought = game.buyCity(cityLocation);
                    if (bought) {
                        updateCards();
                        Circle vertex = (Circle) mouseEvent.getSource();
                        vertex.setRadius(10);
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
    }

    public void BuyDevCardOnClick(MouseEvent mouseEvent) {
        if (!game.isRolled() && !preGame) {
            createDialogBox("Error", "You must roll the dice first");
        } else if (!preGame) {
            DevelopmentCard card = game.buyDevelopmentCard();
            if (card != null)
            {
                String message = "You have successfully purchased a development card. \n" + card.toString() + " was added to your cards.";
                createDialogBox("Development Card", message);
            }
            else
            {
                createDialogBox("Error", "You do not have enough resources to buy a development card");
            }
        }
        updateCards();
    }

    public void UseDevCardOnClick(MouseEvent mouseEvent) {
        if (!game.isRolled() && !preGame) {
            createDialogBox("Error", "You must roll the dice first");
        } else if (!preGame) {
            if(game.getCurrentPlayer().hasDevelopmentCard())
            {
                List<DevelopmentCard> cards = game.getCurrentPlayer().getDevelopmentCards();
                int yearOfPlenty = 0;
                int monopoly = 0;
                int knight = 0;
                int roadBuilding = 0;
                int victoryPoint = 0;
                for(DevelopmentCard card : cards)
                {
                    switch(card){
                        case KNIGHT:
                            knight++;
                            break;
                        case MONOPOLY:
                            monopoly++;
                            break;
                        case ROAD_BUILDING:
                            roadBuilding++;
                            break;
                        case YEAR_OF_PLENTY:
                            yearOfPlenty++;
                            break;
                        case VICTORY_POINTS:
                            victoryPoint++;
                            break;
                    }
                }
                devCardPane.setVisible(true);
                Player2DevCardAmnt1.setText(String.valueOf(yearOfPlenty));
                Player2DevCardAmnt11.setText(String.valueOf(knight));
                Player2DevCardAmnt111.setText(String.valueOf(monopoly));
                Player2DevCardAmnt1111.setText(String.valueOf(victoryPoint));
                Player2DevCardAmnt11111.setText(String.valueOf(roadBuilding));
            }
            else
            {
                createDialogBox("Error", "You do not have any development cards.");
            }
        }
    }

    public void yearOfPlentyOnClick(MouseEvent mouseEvent) {
        devCardPane.setVisible(false);
        inYearOfPlenty = true;
        chooseResourceType();
        updateCards();
    }

    public void knightOnClick(MouseEvent mouseEvent) {
        devCardPane.setVisible(false);
        inKnight = true;
        createDialogBox("Choose Location", "Click on the hex where you want to put the robber");
        updateCards();
    }

    public void monopolyOnClick(MouseEvent mouseEvent) {
        devCardPane.setVisible(false);
        inMonopoly = true;
        chooseResourceType();
        updateCards();
    }

    public void victoryPointOnClick(MouseEvent mouseEvent) {
        devCardPane.setVisible(false);
        createDialogBox("Error", "That card is not playable, but it was added to your score");
    }

    public void roadBuildingOnClick(MouseEvent mouseEvent) {
        devCardPane.setVisible(false);
        inRoadBuilding = true;
        BuildRoadOnClick(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
                MouseButton.PRIMARY, 1, true, true, true, true,
                true, true, true, true, true,
                true, null));

    }

    public void chooseResourceType()
    {
        createDialogBox("Choose Resource Type", "Please select the resource type that you would like by \n" +
                "clicking on the card of that type");
    }

    public void FinishTurnOnClick(MouseEvent mouseEvent) {
        boolean gameOver = gameOver();
        if(!gameOver) {
            if (!game.isRolled() && !preGame) {
                createDialogBox("Error", "You must roll the dice first");
            } else if (!preGame || preGameSwitch) {
                String message = "The players are now being switched. " + game.getCurrentPlayer().toString() + " Player should" +
                        " step \naway from the screen and the next player should come to \nthe screen.";
                createDialogBox("Switch Turn", message);
                game.switchPlayer();
                updateCards();
                currentPlayer.setText("CURRENT PLAYER: \n" + game.getCurrentPlayer().toString());
            }
        }
    }


    public void RoadOnClick(MouseEvent mouseEvent) {
        ImageView road = (ImageView) mouseEvent.getSource();
        String roadId = road.getId();
        Location thisLocation = new Location(getRow(roadId), getColumn(roadId));
        if (inBuildRoad || preGame) {
            roadLocation = thisLocation;
            BuildRoadOnClick(mouseEvent);
        }
        else if (inRoadBuilding)
        {
            if (roadLocation == null)
            {
                roadLocation = thisLocation;
                BuildRoadOnClick(new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
                        MouseButton.PRIMARY, 1, true, true, true, true,
                        true, true, true, true, true,
                        true, null));
            }
            else
            {
                boolean success = game.playRoadBuilding(roadLocation, thisLocation);
                if (success)
                {
                    if (game.getCurrentPlayer().color == Color.BLUE) {
                        road.setImage(new Image("imgs/roads/RoadBlue.png"));
                        road1.setImage(new Image("imgs/roads/RoadBlue.png"));
                    } else {
                        road.setImage(new Image("imgs/roads/RoadRed.png"));
                        road1.setImage(new Image("imgs/roads/RoadRed.png"));
                    }
                }
                inRoadBuilding = false;
            }
        }
    }

    public void vertexOnClick(MouseEvent mouseEvent) {
        Circle vertex = (Circle) mouseEvent.getSource();
        String vertexId = vertex.getId();
        if (inBuildSettlement || preGameSettlement) {
            settlementLocation = new Location(getRow(vertexId), getColumn(vertexId));
            BuildSettlementOnClick(mouseEvent);
        }
        if (inBuildCity) {
            cityLocation = new Location(getRow(vertexId), getColumn(vertexId));
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
        if (game.isRolled()) {
            createDialogBox("Error", "The dice were already rolled this turn");
        } else if (!preGame) {
            game.setRolled(true);
            int[] roll = game.rollDice();
            for (int i = 0; i < 2; i++) {
                switch (roll[i]) {
                    case 1:
                        dice[i].setImage(new Image("imgs/dice/dice/dice-1.png"));
                        break;
                    case 2:
                        dice[i].setImage(new Image("imgs/dice/dice/dice-2.png"));
                        break;
                    case 3:
                        dice[i].setImage(new Image("imgs/dice/dice/dice-3.png"));
                        break;
                    case 4:
                        dice[i].setImage(new Image("imgs/dice/dice/dice-4.png"));
                        break;
                    case 5:
                        dice[i].setImage(new Image("imgs/dice/dice/dice-5.png"));
                        break;
                    case 6:
                        dice[i].setImage(new Image("imgs/dice/dice/dice-6.png"));
                        break;
                }
            }
            int rolledNum = roll[0] + roll[1];
            if (rolledNum != 7) {
                game.distributeCards(rolledNum);
                updateCards();
            } else {
                rolledSeven = true;
                game.halfCards();
                updateCards();
                createDialogBox("Choose Location", "Click on the hex where you want to put the robber");
            }
        }
    }

    public void hexClick(MouseEvent event) {
        ImageView hex = (ImageView) event.getSource();
        String id = hex.getId();
        hexLocation = new Location(getRow(id), getColumn(id));
        if (rolledSeven || inKnight) {
            for (ImageView robber : robbers) {
                robber.setVisible(false);
            }
            if (rolledSeven) {
                game.playRobber(hexLocation);
            }
            else if(inKnight)
            {
                game.playKnight(hexLocation);
            }
            int index = hexes.indexOf(hex);
            robbers.get(index).setVisible(true);
        }
        rolledSeven = false;
        inKnight = false;
    }

    public void setUpBeginning() {
        preGameSettlement = true;
        createDialogBox("Choose location", "Please choose the location for your settlement.");

    }

    public void startGameOnClick(MouseEvent mouseEvent) {
        StartPane.setVisible(false);
        setUpBeginning();
    }

    public boolean gameOver()
    {
        if (game.gameOver())
        {
            Player winner = game.getWinner();
            String message = "GAME OVER! \nTHE WINNER IS " + winner.toString() + "!";
            fireworksPane.setVisible(true);
            gameOverLabel.setText(message);
            return true;
        }
        else{
            return false;
    }
    }

}
