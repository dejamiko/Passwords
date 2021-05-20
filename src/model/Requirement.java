package model;

/**
 * This enum hold different possible requirements.
 *
 * @author mikolajdeja
 * @version 2021.05.17
 */
public enum Requirement {
    SMALL_LETTER("abcdefghijklmnopqrstuvxyz"),
    NUMBER("0123456789"),
    CAPITAL_LETTER("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    SPECIAL_CHARACTER(",.-=?:!@#$%^&*_+");

    private final String possible;

    /**
     * A constructor with a string of possible characters.
     *
     * @param possible The string of possible characters.
     */
    Requirement(String possible) {
        this.possible = possible;
    }

    /**
     * Get the possible characters.
     *
     * @return The possible characters.
     */
    public String getPossible() {
        return possible;
    }
}
