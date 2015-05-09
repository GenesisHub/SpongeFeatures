package net.genesishub.gFeaturesSponge.commands;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.source.CommandBlockSource;
import org.spongepowered.api.util.command.source.ConsoleSource;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class Speed implements CommandExecutor{

	@Override
	public CommandResult execute(CommandSource src, CommandContext con) throws CommandException {
		if(con.getAll(key)){
			
		}
	     if(src instanceof Player) {
	    	    Player player = (Player) src;
	    	    player.sendMessage(Texts.of("S"));
	    	}
	    	else if(src instanceof ConsoleSource) {
	    	    src.sendMessage(Texts.of(""));
	    	    // The Cake Is a Lie
	    	}
	    	else if(src instanceof CommandBlockSource) {
	    	    src.sendMessage(Texts.of("Hello Companion Cube!"));
	    	}
	     return CommandResult.success();
	}

}
