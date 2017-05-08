import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiu on 5/9/2017.
 */
public class Game {
    /*
1 - black
-1 - white
 */
    private Integer currentXORValue;

    public Integer getCurrentXORValue() {
        return currentXORValue;
    }

    public Game setCurrentXORValue(Integer currentXORValue) {
        this.currentXORValue = currentXORValue;
        return this;
    }

    private List<List<Integer>> table;

    public List<List<Integer>> getTable() {
        return table;
    }

    public void setTable(List<List<Integer>> table) {
        this.table = table;
    }

    public void printTable(){
        for(Integer i=0;i<table.size();i++){
            for(Integer j=0;j<table.size();j++){
                System.out.print(table.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    private List<Integer> blackPositions;
    private List<Integer> whitePositions;
    private List<Integer> spaces;
    private Integer size;

    public Boolean isFinal(){
        return this.spaces.stream().mapToInt(Integer::intValue).sum() == 0;
    }

    public List<Integer> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Integer> spaces) {
        this.spaces = spaces;
    }

    public Game moveBlack(Integer line,Integer newColumn) throws Exception {
        if(line < 0 || line >= table.size() || newColumn<1 || newColumn >= table.get(0).size() - 1 || newColumn <= blackPositions.get(line)){
            throw new Exception("Invalid move");
        }
        if( newColumn >= whitePositions.get(line)){
            throw new Exception("Invalid move");
        }
        currentXORValue = currentXORValue ^ spaces.get(line);
        spaces.set(line,Math.abs(whitePositions.get(line) - newColumn) - 1);
        currentXORValue = currentXORValue ^ spaces.get(line);
        table.get(line).set(blackPositions.get(line),0);
        table.get(line).set(newColumn,1);
        blackPositions.set(line,newColumn);

        return this;
    }

    public Game moveWhite(Integer line,Integer newColumn) throws Exception {
        if(line < 0 || line >= table.size() || newColumn<1 || newColumn >= table.get(0).size() - 1 || newColumn >= whitePositions.get(line)){
            throw new Exception("Invalid move");
        }
        if(newColumn <= blackPositions.get(line)){
            throw new Exception("Invalid move");
        }
        currentXORValue = currentXORValue ^ spaces.get(line);
        spaces.set(line,Math.abs(blackPositions.get(line) - newColumn) - 1);
        currentXORValue = currentXORValue ^ spaces.get(line);
        table.get(line).set(whitePositions.get(line),0);
        table.get(line).set(newColumn,-1);
        whitePositions.set(line,newColumn);
        return this;
    }

    public Game() {
        blackPositions = new ArrayList<>();
        whitePositions = new ArrayList<>();
        spaces = new ArrayList<>();
        table = new ArrayList<>();
        size = 0;
    }


    public List<Integer> getBlackPositions() {
        return blackPositions;
    }

    public void setBlackPositions(List<Integer> blackPositions) {
        this.blackPositions = blackPositions;
    }

    public List<Integer> getWhitePositions() {
        return whitePositions;
    }

    public void setWhitePositions(List<Integer> whitePositions) {
        this.whitePositions = whitePositions;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
