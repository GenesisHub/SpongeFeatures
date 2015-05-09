package net.genesishub.gFeaturesSponge;

import net.genesishub.gFeaturesSponge.commands.Speed;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.format.TextColors;

import com.google.inject.Inject;

@Plugin(id = "gFeaturesSponge", name = "gFeatures-Sponge", version = "1.0.0")
public class Listeners {
	static String pluginversion = "1.0.0";
	@Inject
	static Game game;
    @Inject
	Logger logger;
	@Subscribe
	public void onServerStart(PreInitializationEvent event) {
	    logger.info(TextColors.DARK_AQUA + "\n______________________________________________________________________");
	    logger.info(TextColors.DARK_AQUA + "\n[gFeatures]Starting gFeatures-Sponge...");
	    logger.info(TextColors.DARK_AQUA + "\n[gFeatures]You are running gFeatures-Sponge version " + pluginversion);
	    logger.info(TextColors.DARK_AQUA + "\n[gFeatures]Remember! This plugin is still in Beta! Take backups!");
	    logger.info(TextColors.DARK_AQUA + "\n______________________________________________________________________");
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
	public void Initialization(InitializationEvent event) {
		try{
		game.getCommandDispatcher().register(this, new Speed(logger, game), "speed");
		}
		catch(Exception e){
		}
	}
}
