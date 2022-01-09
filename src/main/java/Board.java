import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board {
    List<Hex> board = new ArrayList<>();

    public Board(){
        for (int i = 0 ; i < 3; i++){
            board.add( new Hex(ResourceType.ORE));
        }

        for (int i = 0 ; i < 3; i++){
            board.add( new Hex(ResourceType.BRICK));
        }

        for (int i = 0 ; i < 3; i++){
            board.add( new Hex(ResourceType.DESERT));
        }

        for (int i = 0 ; i < 4; i++){
            board.add( new Hex(ResourceType.GRAIN));
        }

        for (int i = 0 ; i < 4; i++){
            board.add( new Hex(ResourceType.LUMBER));
        }

        for (int i = 0 ; i < 4; i++){
            board.add( new Hex(ResourceType.WOOL));
        }

        board.add( new Hex(ResourceType.ROBBER));

        Collections.shuffle(board);

        //give numbers to the tiles
    }


    private void assignNumbers()
    {
        int[] numbers = new int[18];
        numbers[0] = 5;
        numbers[1] = 2;
        numbers[2] = 6;
        numbers[3] = 3;
        numbers[4] = 8;
        numbers[6] = 10;
        numbers[7] = 9;
        numbers[8] = 12;
        numbers[9] = 11;
        numbers[10] = 4;
        numbers[11] = 8;
        numbers[12] = 10;
        numbers[13] = 9;
        numbers[14] = 4;
        numbers[15] = 5;
        numbers[16] = 6;
        numbers[17] = 3;
        numbers[18] = 11;

        int index = 0;
        for (Hex hex : board) {
            if (hex.type == ResourceType.DESERT)
            {
                continue;
            }
            hex.setNumber(numbers[index]);
            index++;
        }

    }

}
