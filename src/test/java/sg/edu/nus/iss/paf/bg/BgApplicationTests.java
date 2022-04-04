package sg.edu.nus.iss.paf.bg;

import static org.junit.jupiter.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.nus.iss.paf.bg.Repository.GameRespository;
import sg.edu.nus.iss.paf.bg.model.Comment;
import sg.edu.nus.iss.paf.bg.model.Game;

@SpringBootTest
class BgApplicationTests {

	@Autowired
	private GameRespository gameRepo;

	@Test
	void shouldReturnAGame() {
		Optional<Game> opt = gameRepo.getGameByGid(10);
		assertTrue(opt.isPresent(), "gid = 10");
	}

	@Test
	void shouldReturnEmpty() {
		Optional<Game> opt = gameRepo.getGameByGid(10000);
		assertFalse(opt.isPresent(), "gid = 10000");
	}

	@Test
	void shouldReturnAComment() {
		List<Comment> comment  = gameRepo.getCommentsByGid(10);
		assertEquals(comment.size(), 42, "number of comments for gid = 10 is 42");
	}

	@Test
	void shouldReturnEmptyList() {
		List<Comment> comment  = gameRepo.getCommentsByGid(10000, 10, 5);
		assertTrue(comment.isEmpty(), "List of comments should be empty for gid = 10000");
	}

}
