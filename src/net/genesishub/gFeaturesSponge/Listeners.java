package net.genesishub.gFeaturesSponge;

import net.genesishub.gFeaturesSponge.commands.Broadcast;
import net.genesishub.gFeaturesSponge.commands.Speed;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;
import org.spongepowered.common.Sponge;

import com.google.inject.Inject;

@Plugin(id = "gFeaturesSponge", name = "gFeatures-Sponge", version = "1.0.0")
public class Listeners {
	static String pluginversion = "1.0.0";
	@Inject
	static Game game;
    @Inject
	Logger logger;
	@Subscribe
	public void onServerStart(ServerStartingEvent event) {
	    logger.info("\n______________________________________________________________________");
	    logger.info("\n[gFeatures]Starting gFeatures-Sponge...");
	    logger.info("\n[gFeatures]You are running gFeatures-Sponge version " + pluginversion);
	    logger.info("\n[gFeatures]Remember! This plugin is still in Beta! Take backups!");
	    logger.info("\n______________________________________________________________________");
	    CommandSpec myCommandSpec = CommandSpec.builder()
	    .setDescription(Texts.of("Sets your speed."))
	    .setPermission("gfeatures.commands.speed")
	    .setExecutor(new Speed())
	    .build();
	}
	@Subscribe
	public void onServerStop(ServerStoppingEvent event) {
	    logger.info("\n______________________________________________________________________");
	    logger.info("\n[gFeatures]Stopping gFeatures-Sponge...");
	    logger.info("\n[gFeatures]You are running gFeatures-Sponge version " + pluginversion);
	    logger.info("\n[gFeatures]Remember! This plugin is still in Beta! Take backups!");
	    logger.info("\n______________________________________________________________________");
	}
	@Subscribe
	public void Initalization(InitializationEvent event) {
		CommandService cmdService = game.getCommandDispatcher();
		CommandSpec speed = CommandSpec.builder()
			    .setDescription(Texts.of("Sets your speed."))
			    .setPermission("gfeatures.commands.speed")
			    .setExecutor(new Speed()).build();
				try{
			    cmdService.register(this, speed, "speed");
			    }
				catch(Exception e){}
	}
}
