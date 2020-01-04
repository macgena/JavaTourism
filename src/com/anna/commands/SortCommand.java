package com.anna.commands;

public class SortCommand extends BaseCommand {
    private String sortBy;
    private String sortOrder;

    public SortCommand(String sortBy, String sortOrder) {
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public CommandType getType() {
        return CommandType.SORT;
    }
}
