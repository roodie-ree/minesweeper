package de.vr.mineweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighScoreService {
    @RequestMapping("/highscore")
    public HighScore highScore() {
        return new HighScore(9001, "Over Ninethousand");
    }
}
