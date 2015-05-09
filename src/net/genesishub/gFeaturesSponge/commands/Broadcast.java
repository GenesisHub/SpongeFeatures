package net.genesishub.gFeaturesSponge.commands;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;

import com.google.common.base.Optional ;

public class Broadcast implements CommandCallable{
	
	Game game;
	Logger log;
	
	public Broadcast(Logger logger, Game games){
		log = logger;
		game = games;
	}

	@Override
	public Optional<Text> getHelp(CommandSource arg0) {
		Optional<Text> text = Optional.of(Texts.of(TextColors.GOLD + "/broadcast [message]"));
		return text;
	}

	@Override
	public Optional<Text> getShortDescription(CommandSource arg0) {
		Optional<Text> text = Optional.of(Texts.of("Broadcasts a message to the server."));
		return text;
	}

	@Override
	public List<String> getSuggestions(CommandSource arg0, String arg1) throws CommandException {
		return Collections.emptyList();
	}

	@Override
	public Text getUsage(CommandSource arg0) {
		Text text = Texts.of(TextColors.GOLD + "/broadcast [message]");
		return text;
	}

	@Override
	public Optional<CommandResult> process(CommandSource src, String arg1) throws CommandException {
		if(arg1.length() < 1){
			if(src instanceof Player){
			src.sendMessage(Texts.of(TextColors.GOLD + "Usage: /broadcast [message]"));
			}
			else{
				src.sendMessage(Texts.of("Usage: /broadcast [message]"));
			}
		} 
		else{
		if(arg1.length() >= 1){
			game.getServer().broadcastMessage(Texts.of(TextColors.DARK_AQUA + "[" +  TextColors.GOLD + "Broadcast" + TextColors.DARK_AQUA + "]" + arg1));
		}
		else{
			src.sendMessage(Texts.of(TextColors.GOLD + "Usage: /broadcast [message]"));
		}
		}
		return Optional.of(CommandResult.empty());
	}

	@Override
	public boolean testPermission(CommandSource arg0) {
		return arg0.hasPermission("gfeatures.commands.speed");
	}

}
