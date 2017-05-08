import java.util.List;

/**
 * Created by Sergiu on 5/9/2017.
 */
public class NimSolver {
    public static MoveSpecification nextStep(List<Integer> spaces,Integer currentXORValue){
        MoveSpecification moveSpecification = new MoveSpecification();
        for(Integer i=0;i<spaces.size();i++){
            for(Integer j=1;j<=spaces.get(i);j++){
                if(new Integer(currentXORValue ^ spaces.get(i) ^ j).equals( 0)){
                    moveSpecification.setLine(i).setSteps(j);
                    return moveSpecification;
                }
            }
        }
        for (Integer i=0;i<spaces.size();i++){
            if(spaces.get(i).compareTo(0) != 0) {
                moveSpecification.setLine(i).setSteps(1);
                return moveSpecification;
            }
        }
        return null;
    }
}
