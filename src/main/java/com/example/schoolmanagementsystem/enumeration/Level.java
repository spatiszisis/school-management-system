package com.example.schoolmanagementsystem.enumeration;

public enum Level {
    C1("C1"),
    C2("C2"),
    B1("B1"),
    B2("B2");

    private final String level;

    Level(String level) { this.level = level; }

    public String getLevel() { return level; }
}
