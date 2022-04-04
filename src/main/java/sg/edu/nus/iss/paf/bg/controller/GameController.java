package sg.edu.nus.iss.paf.bg.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sg.edu.nus.iss.paf.bg.Repository.GameRespository;
import sg.edu.nus.iss.paf.bg.model.Comment;
import sg.edu.nus.iss.paf.bg.model.Game;

@Controller
public class GameController {
    private Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameRespository gameRepo;

    // @GetMapping
    // public String showGameWelcome() {

    //     return "index";
    // }
    @GetMapping("/game/{gid}")
    public String showGame(@PathVariable(name="gid") String gid, Model model){
        Optional<Game> opt = gameRepo.getGameByGid(Integer.parseInt(gid));
        Game game = new Game();
        if (!opt.isEmpty()){
            game = opt.get();
        }
        List<Comment> commentList = gameRepo.getCommentsByGid(Integer.parseInt(gid),5);

        model.addAttribute("game", game);
        model.addAttribute("commentList", commentList);
        
        return "gameInfo";
    }

}
