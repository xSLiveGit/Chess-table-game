/**
 * Created by Sergiu on 5/9/2017.
 */
public class MoveSpecification {
    Integer line;
    Integer steps;


    public MoveSpecification() {
    }

    public Integer getSteps() {
        return steps;
    }

    public MoveSpecification setSteps(Integer steps) {
        this.steps = steps;
        return this;
    }

    public Integer getLine() {
        return line;
    }

    public MoveSpecification setLine(Integer line) {
        this.line = line;
        return this;
    }

    public MoveSpecification(Integer line, Integer column) {
        this.line = line;
        this.steps = column;
    }
}
