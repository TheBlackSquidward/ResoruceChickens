package io.github.TheBlackSquidward.resourcechickens.init;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.commands.AbstractCommand;
import io.github.TheBlackSquidward.resourcechickens.commands.GiveChickenCommand;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

import java.util.function.Supplier;

import static net.minecraft.command.Commands.literal;

public class ModCommands {

    public static GiveChickenCommand GIVE_CHICKEN_COMMAND;

    public static void registerCommands(CommandDispatcher<CommandSource> dispatcher, Commands.EnvironmentType env) {
        GIVE_CHICKEN_COMMAND = registerCommand(GiveChickenCommand::new, dispatcher, env);
    }

    public static <T extends AbstractCommand> T registerCommand(Supplier<T> supplier, CommandDispatcher<CommandSource> dispatcher, Commands.EnvironmentType env) {
        T command = supplier.get();
        if (!command.isDedicatedServerOnly() || env == Commands.EnvironmentType.DEDICATED || env == Commands.EnvironmentType.ALL) {
            LiteralArgumentBuilder<CommandSource> builder = literal(command.getName());
            builder.requires((sender) -> sender.hasPermission(command.getRequiredPermissionLevel()));
            command.build(builder);
            dispatcher.register(literal(ResourceChickens.MODID).then(builder));
        }

        return command;
    }

}
