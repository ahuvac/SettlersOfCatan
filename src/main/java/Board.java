import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board {
    //Hex[] board = new Hex[16];
    List<Hex> board = new ArrayList<>();

    public Board(){
        for (int i = 0 ; i < 3; i++){
            board.add( new Hex(ResourceType.ORE));
        }

        for (int i = 4 ; i < 7; i++){
            board.add( new Hex(ResourceType.BRICK));
        }

        for (int i = 7 ; i < 10; i++){
            board.add( new Hex(ResourceType.DESERT));
        }

        for (int i = 10 ; i < 14; i++){
            board.add( new Hex(ResourceType.GRAIN));
        }

        for (int i = 14 ; i < 18; i++){
            board.add( new Hex(ResourceType.LUMBER));
        }

        for (int i = 18 ; i < 22; i++){
            board.add( new Hex(ResourceType.WOOL));
        }

        board.add( new Hex(ResourceType.ROBBER));

        Collections.shuffle(board);
    }


}
