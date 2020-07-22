package ro.jademy.millionaire.model;

public class Level {

    private int number;
    private int difficultyLevel;
    private int reward;
    private int rewardWalkAway;

    public Level(int number, int difficultyLevel, int reward, int rewardWalkAway) {
        this.number = number;
        this.difficultyLevel = difficultyLevel;
        this.reward = reward;
        this.rewardWalkAway = rewardWalkAway;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getRewardWalkAway() {
        return rewardWalkAway;
    }

    public void setRewardWalkAway(int rewardWalkAway) {
        this.rewardWalkAway = rewardWalkAway;
    }
}
