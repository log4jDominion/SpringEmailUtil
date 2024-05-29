package com.message.messenger.enums;

public enum SlackEnums {
    SECTION("section"), TEXT_MARKDOWN("mrkdwn"), BOLD("*"), ITALIC("_"), BREAK("\n"), CODE("`"), CODE_SNIPPET("```");

    public final String label;
    private SlackEnums(String label) {
        this.label = label;
    }
}
