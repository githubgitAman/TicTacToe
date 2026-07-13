package Strategies;

import Models.ENUMs.BOTDIFFICULTYLEVEL;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BOTDIFFICULTYLEVEL botdifficultyLevel){
        if(botdifficultyLevel == BOTDIFFICULTYLEVEL.EASY){
            return new EasyBotPlayingStrategy();
        }
        else if(botdifficultyLevel == BOTDIFFICULTYLEVEL.MEDIUM){
            return new MediumBotPlayingStrategy();
        }
        else if(botdifficultyLevel == BOTDIFFICULTYLEVEL.HARD){
            return new HardBotPlayingStrategy();
        }

        return new EasyBotPlayingStrategy();
    }
}
