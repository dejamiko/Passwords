package model;

import java.util.*;
import java.util.stream.Collector;

/**
 * This class is responsible for generating and checking passwords.
 *
 * @author mikolajdeja
 * @version 2021.05.17
 */
public class Passwords {
    /**
     * Generate a password with a given length and a list of requirements.
     *
     * @param length The length of the new password.
     * @param requirements The requirements for the password.
     * @return The new password.
     */
    public static String generate(int length, Requirement... requirements) {
        return generate(length, Arrays.asList(requirements));
    }

    /**
     * Generate a password with a given length and a list of requirements.
     *
     * @param length The length of the new password.
     * @param requirements The requirements for the password.
     * @return The new password.
     */
    public static String generate(int length, Collection<Requirement> requirements) {
        List<Character> pass = new ArrayList<>();
        if (length < requirements.size())
            return null;
        else {
            List<Requirement> list = new ArrayList<>(requirements);
            Random random = new Random();
            for (Requirement requirement : list) {
                pass.add(random.nextInt(pass.size() + 1), requirement.getPossible().charAt(random.nextInt(requirement.getPossible().length())));
            }
            list = Arrays.asList(Requirement.values());
            while (pass.size() < length) {
                int i = random.nextInt(list.size());
                pass.add(random.nextInt(pass.size() + 1), list.get(i).getPossible().charAt(random.nextInt(list.get(i).getPossible().length())));
            }
        }
        return pass.stream().collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }

    /**
     * Check if a given password satisfies a list of requirements.
     *
     * @param pass The given password.
     * @param requirements The given requirements.
     * @return True if the given password satisfies a list of requirements.
     */
    public static boolean check(String pass, Collection<Requirement> requirements) {
        if (pass == null || requirements.size() > pass.length())
            return false;
        for (Requirement requirement : requirements) {
            String possible = requirement.getPossible();
            boolean holds = false;
            for (int i = 0; i < possible.length(); i++) {
                if (pass.indexOf(possible.charAt(i)) >= 0) {
                    holds = true;
                    break;
                }
            }
            if (!holds)
                return false;
        }
        return true;
    }

    /**
     * Check if a given password satisfies a list of requirements.
     *
     * @param pass The given password.
     * @param requirements The given requirements.
     * @return True if the given password satisfies a list of requirements.
     */
    public static boolean check(String pass, Requirement... requirements) {
        return check(pass, Arrays.asList(requirements));
    }

}
