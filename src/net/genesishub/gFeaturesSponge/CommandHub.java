package net.genesishub.gFeaturesSponge;

import net.genesishub.gFeaturesSponge.commands.Broadcast;
import net.genesishub.gFeaturesSponge.commands.Speed;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.service.command.CommandService;

public class CommandHub {
	public void Initialize(CommandService cmdService, Logger logger, Game game, Listeners listeners){
		cmdService.register(listeners, new Broadcast(logger, game), "broadcast");
		cmdService.register(listeners, new Speed(logger, game), "tp");
		cmdService.register(listeners, new Speed(logger, game), "gm");
		cmdService.register(listeners, new Speed(logger, game), "tphere");
		cmdService.register(listeners, new Speed(logger, game), "tpa");
		cmdService.register(listeners, new Speed(logger, game), "tpahere");
		cmdService.register(listeners, new Speed(logger, game), "spawn");
		cmdService.register(listeners, new Speed(logger, game), "tpo");
		cmdService.register(listeners, new Speed(logger, game), "tpohere");
		cmdService.register(listeners, new Speed(logger, game), "warp");
		cmdService.register(listeners, new Speed(logger, game), "home");
	}
}	
