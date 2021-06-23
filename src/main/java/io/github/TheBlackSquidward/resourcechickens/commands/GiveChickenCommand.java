package io.github.TheBlackSquidward.resourcechickens.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;

public class GiveChickenCommand extends AbstractCommand{

    @Override
    public String getName() {
        return "give_chicken";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        //TODO
    }

    @Override
    public boolean isDedicatedServerOnly() {
        return false;
    }
}
