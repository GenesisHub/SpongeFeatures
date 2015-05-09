package net.genesishub.gFeaturesSponge;

import net.genesishub.gFeaturesSponge.commands.Speed;

import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

public class CommandHub {
	public void test(){
		CommandSpec myCommandSpec = CommandSpec.builder()
		.setDescription(Texts.of("Sets your speed."))
		.setPermission("gfeatures.commands.speed")
		.setExecutor(new Speed())
		.build();

		Listeners.game.getCommandDispatcher().register(this, myCommandSpec, "helloworld", "hello", "test");
	}
}	
