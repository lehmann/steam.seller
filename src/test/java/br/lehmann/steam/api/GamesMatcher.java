package br.lehmann.steam.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GamesMatcher {

	public static void main(String[] args) throws IOException {
		final List<String> profile = Files.readAllLines(Paths.get("C:/Users/uuario/git/steam.seller/src/test/resources/trader.html"));
		Files.lines(Paths.get("C:/Users/uuario/git/steam.seller/src/test/resources/games.txt")).forEach((game) -> {
			String gameContained = profile.parallelStream().filter((line) -> {
				return line.contains(game);
			}).findFirst().orElse(null);
			if(gameContained == null) {
				System.out.println("Not contained game: " + game);
			}
		});
	}
}
