package model;

public class Tester {
    public static void main(String[] args) {
        String pass = Passwords.generate(13, Requirement.CAPITAL_LETTER, Requirement.SPECIAL_CHARACTER, Requirement.NUMBER);
        System.out.println(pass);
        System.out.println(Passwords.check(pass, Requirement.CAPITAL_LETTER, Requirement.SPECIAL_CHARACTER));
    }
}
