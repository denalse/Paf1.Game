package sg.edu.nus.iss.paf.bg.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf.bg.model.Comment;
import sg.edu.nus.iss.paf.bg.model.Game;

import static sg.edu.nus.iss.paf.bg.Repository.Queries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRespository {

@Autowired
private JdbcTemplate template;

    public List<Comment>getCommentsByGid(Integer gid) {
        return getCommentsByGid(gid, Integer.MAX_VALUE, 0);
    }

    public List<Comment>getCommentsByGid(Integer gid, Integer limit){
        return getCommentsByGid(gid, limit, 0);
    }

    public List<Comment>getCommentsByGid(Integer gid, Integer limit, Integer offset) {
    
    final SqlRowSet result = template.queryForRowSet(
         SQL_SELECT_COMMENT_BY_GID, gid, limit, offset
    );
            
    List<Comment> commentList = new ArrayList<>();

    while (result.next()) {

        Comment c = Comment.create(result);
        commentList.add(c);

    }

    return commentList;
    }

    // public void getGameByGid(Integer gid) {
        public Optional<Game> getGameByGid(Integer query_gid) {

            final SqlRowSet result = template.queryForRowSet(
            // select * from game where gid = <gid>
            SQL_SELECT_GAME_BY_GID, query_gid
        );

        if (!result.next())
            return Optional.empty();

        Game g = Game.create(result);

        return Optional.of(g);

    }
    
}
