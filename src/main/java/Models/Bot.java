package Models;

import Models.ENUMs.BOTDIFFICULTYLEVEL;

public class Bot extends Player {
    private BOTDIFFICULTYLEVEL difficulty;

    public Bot(BOTDIFFICULTYLEVEL difficulty) {
        this.difficulty = difficulty;
    }

    public BOTDIFFICULTYLEVEL getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BOTDIFFICULTYLEVEL difficulty) {
        this.difficulty = difficulty;
    }
}
