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
import org.spongepowered.api.world.Location;
import com.google.common.base.Optional;

public class Teleport implements CommandCallable{
	
	Game game;
	Logger log;
	
	public Teleport(Logger logger, Game games){
		log = logger;
		game = games;
	}

	@Override
	public Optional<Text> getHelp(CommandSource arg0) {
		Optional<Text> text = Optional.of(Texts.of(TextColors.GOLD, "Usage: /tp [player] [to player (OPTIONAL)] or /tp [player] [x] [y] [z] or /tp [x] [y] [z]"));
		return text;
	}

	@Override
	public Optional<Text> getShortDescription(CommandSource arg0) {
		Optional<Text> text = Optional.of(Texts.of("Teleports a player to player or location."));
		return text;
	}

	@Override
	public List<String> getSuggestions(CommandSource arg0, String arg1) throws CommandException {
		return Collections.emptyList();
	}

	@Override
	public Text getUsage(CommandSource arg0) {
		Text text = Texts.of(TextColors.GOLD, "Usage: /tp [player] [to player (OPTIONAL)] or /tp [player] [x] [y] [z] or /tp [x] [y] [z]");
		return text;
	}

	@Override
	public Optional<CommandResult> process(CommandSource src, String arg1) throws CommandException {
		String[] strs = arg1.split("/s");
		if(arg1.length() < 1){
			if(src instanceof Player){
			src.sendMessage(Texts.of(TextColors.GOLD, "Usage: /tp [player] [to player (OPTIONAL)] or /tp [player] [x] [y] [z] or /tp [x] [y] [z]"));
			}
			else{
				src.sendMessage(Texts.of(TextColors.GOLD, "Usage: /tp [player] [to player (OPTIONAL)] or /tp [player] [x] [y] [z] or /tp [x] [y] [z]"));
			}
		} 
		if(src instanceof Player){
			if(strs.length == 1){			
				for(Player player : game.getServer().getOnlinePlayers()){
					if(arg1.equals(player.getName())){
						Text text = Texts.builder("[").color(TextColors.DARK_AQUA).append(Texts.builder("Teleport").color(TextColors.GOLD).append(Texts.builder("]").color(TextColors.DARK_AQUA).append(Texts.builder("Teleporting...").color(TextColors.GRAY).build()).build()).build()).build();
						Location playertp = player.getLocation();
						((Player) src).setLocation(playertp);
						src.sendMessage(text);
						return Optional.of(CommandResult.empty());
					}
				}
				src.sendMessage(Texts.of(TextColors.GOLD, "Error in your input. Try again!"));
			}
			else if(strs.length == 2){
				try{
				String[] str = arg1.split("/s");
				Player player = (Player) game.getServer().getPlayer(str[0]);
				Player playertp = (Player) game.getServer().getPlayer(str[1]);
				Location loc = playertp.getLocation();
				player.setLocation(loc);
				Text text = Texts.builder("[").color(TextColors.DARK_AQUA).append(Texts.builder("Teleport").color(TextColors.GOLD).append(Texts.builder("]").color(TextColors.DARK_AQUA).append(Texts.builder("Teleporting...").color(TextColors.GRAY).build()).build()).build()).build();
				src.sendMessage(text);
				}
				catch(Exception e){
					src.sendMessage(Texts.of(TextColors.GOLD, "Error in your input. Try again!"));
				}
			}
			else if(strs.length == 3){
					try{
					String[] str = arg1.split("/s");
					double x = Double.parseDouble(str[0]);
					double y = Double.parseDouble(str[1]);
					double z = Double.parseDouble(str[2]);
					Location playertp = new Location(((Player) src).getWorld(), x, y, z);
					((Player) src).setLocation(playertp);
					Text text = Texts.builder("[").color(TextColors.DARK_AQUA).append(Texts.builder("Teleport").color(TextColors.GOLD).append(Texts.builder("]").color(TextColors.DARK_AQUA).append(Texts.builder("Teleporting...").color(TextColors.GRAY).build()).build()).build()).build();
					src.sendMessage(text);
					}
					catch(Exception e){
						src.sendMessage(Texts.of(TextColors.GOLD, "Error in your input. Try again!"));
					}
				}
				else if(strs.length == 4){
					try{
						String[] str = arg1.split("/s");
						double x = Double.parseDouble(str[1]);
						double y = Double.parseDouble(str[2]);
						double z = Double.parseDouble(str[3]);
						String player = str[0];
						Optional<Player> servert = game.getServer().getPlayer(player);
						Location playertp = new Location(((Player) servert).getWorld(), x, y, z);
						((Player) servert).setLocation(playertp);
						Text text = Texts.builder("[").color(TextColors.DARK_AQUA).append(Texts.builder("Teleport").color(TextColors.GOLD).append(Texts.builder("]").color(TextColors.DARK_AQUA).append(Texts.builder("Teleporting...").color(TextColors.GRAY).build()).build()).build()).build();
						src.sendMessage(text);
						((Player)servert).sendMessage(text);
						}
						catch(Exception e){
							src.sendMessage(Texts.of(TextColors.GOLD, "Error in your input. Try again!"));
						}
				}
				else{
					src.sendMessage(Texts.of(TextColors.GOLD, "Usage: /tp [player] [to player (OPTIONAL)] or /tp [player] [x] [y] [z] or /tp [x] [y] [z]"));
				}
			}
			else{
				if(strs.length == 2){
					try{
					String[] str = arg1.split("/s");
					Player player = (Player) game.getServer().getPlayer(str[0]);
					Player playertp = (Player) game.getServer().getPlayer(str[1]);
					Location loc = playertp.getLocation();
					player.setLocation(loc);
					Text text = Texts.builder("[").color(TextColors.DARK_AQUA).append(Texts.builder("Teleport").color(TextColors.GOLD).append(Texts.builder("]").color(TextColors.DARK_AQUA).append(Texts.builder("Teleporting...").color(TextColors.GRAY).build()).build()).build()).build();
					src.sendMessage(text);
					}
					catch(Exception e){
						src.sendMessage(Texts.of(TextColors.GOLD, "Error in your input. Try again!"));
					}
				}
				else if(strs.length == 4){
					try{
						String[] str = arg1.split("/s");
						double x = Double.parseDouble(str[1]);
						double y = Double.parseDouble(str[2]);
						double z = Double.parseDouble(str[3]);
						String player = str[0];
						Optional<Player> servert = game.getServer().getPlayer(player);
						Location playertp = new Location(((Player) servert).getWorld(), x, y, z);
						((Player) servert).setLocation(playertp);
						Text text = Texts.builder("[").color(TextColors.DARK_AQUA).append(Texts.builder("Teleport").color(TextColors.GOLD).append(Texts.builder("]").color(TextColors.DARK_AQUA).append(Texts.builder("Teleporting...").color(TextColors.GRAY).build()).build()).build()).build();
						src.sendMessage(text);
						((Player)servert).sendMessage(text);
						}
						catch(Exception e){
							src.sendMessage(Texts.of(TextColors.GOLD, "Error in your input. Try again!"));
						}
				}
				else{
					src.sendMessage(Texts.of(TextColors.GOLD, "Usage: /tp [player] [to player (OPTIONAL)] or /tp [player] [x] [y] [z] or /tp [x] [y] [z]"));
				}
			}
		return Optional.of(CommandResult.empty());
	}

	@Override
	public boolean testPermission(CommandSource arg0) {
		return arg0.hasPermission("gfeatures.teleport");
	}
}
