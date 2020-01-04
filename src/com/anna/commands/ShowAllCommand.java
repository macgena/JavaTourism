package com.anna.commands;

public class ShowAllCommand extends BaseCommand {
    @Override
    public CommandType getType() {
        return CommandType.SHOW_ALL;
    }
}
