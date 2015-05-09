package net.genesishub.gFeaturesSponge.commands;

import org.spongepowered.api.Game;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;

public class Broadcast {
	private Game game;
	
	public CommandResult execute(CommandSource cs, CommandContext args) throws CommandException{
		game = Main.access.game;
		String cmdString = "";
		try{
			try{
			cmdString = args.getOne("all").get().toString();
			}catch(IllegalStateException e){}
		}catch(NullPointerException e){}
		String broadcaster = cmdString.split(" ")[0];
		String broadcastContent = cmdString.replace(broadcaster + " ", "");
		if(broadcaster.length() == 0){
			cS.sendMessage(Texts.of(TextColors.DARK_GREEN,"Format: ",TextColors.WHITE, "/broadcast <channel name> <broadcast content>"));
		}else if(StringUtils.countMatches(cmdString, " ") == 0){
			cS.sendMessage(Texts.of(TextColors.DARK_RED,"Error: ",TextColors.RED, "You need to type some broadcast content."));
		}else if(cS.hasPermission("spongy.chat.broadcast")){
			cS.sendMessage(Texts.of(TextColors.GOLD,"You Broadcasted \"",TextColors.RESET, broadcastContent, TextColors.GOLD,"\""));
			game.getServer().broadcastMessage(Texts.of("§4" + broadcaster + " §r" + broadcastContent));
			return CommandResult.success();
		}else{
			cS.sendMessage(Texts.of(TextColors.DARK_RED,"Error: ",TextColors.RED, "You do not have permission to use /broadcast"));
		}
		return CommandResult.empty();
	}
}
