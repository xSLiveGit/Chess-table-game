import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sergiu on 5/9/2017.
 */
public class GameGenerator {
/*
1 - black
-1 - white
 */
    public static Game generate(Integer nLines, Integer nColumns,Random random){
        Integer pos1;
        Integer pos2;
        Game game = new Game();
        game.setCurrentXORValue(0);
        for(Integer i=0;i<nLines;i++){
            pos1 = random.nextInt(nColumns);
            do{
                pos2 = random.nextInt(nColumns);
            }while(pos1.equals(pos2));
            game.getBlackPositions().add(Math.min(pos1,pos2));
            game.getWhitePositions().add(Math.max(pos1,pos2));
            game.getSpaces().add(Math.abs(pos1 - pos2 )- 1);
            game.getTable().add(new ArrayList<>());
            for(Integer j=0;j<nColumns;j++){
                game.getTable().get(i).add(0);
            }
            game.getTable().get(i).set(Math.min(pos1,pos2),1);
            game.getTable().get(i).set(Math.max(pos1,pos2),-1);

            game.setCurrentXORValue(game.getCurrentXORValue() ^ game.getSpaces().get(i));
        }
        return game;
    }
}
