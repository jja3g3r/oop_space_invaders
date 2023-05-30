package invaderlib;

public class Score {
    private int score;
    Score(int newScore){this.SetScore(newScore);}
    public void AddPoints(){}
    private Score SetScore(int newScore){this.score = newScore; return this;}
}
