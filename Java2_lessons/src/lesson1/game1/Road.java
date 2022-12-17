package lesson1.game1;

public class Road {
    private int roadLength;
    private int roadHeight;

    public Road(int roadLength, int roadHeight) {
        this.roadLength = roadLength;
        this.roadHeight = roadHeight;
    }

    public double getTimeToOvercomeRoad(CanRun runner) {
        return runner.run(roadLength, roadHeight);
    }
}
