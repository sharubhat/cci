package com.sfdc.test;

import java.io.InputStream;
import java.util.*;

/**
 * Created by sharath on 4/7/15.
 *
 * @author Sharath Bhat
 * @email sharath_bhat@icloud.com
 *
 */
public class Command {

    private Set<String> installed;
    private Map<String, List<String>> dependencies;

    public Command() {
        installed = new HashSet<>();
        dependencies = new HashMap<>();
    }

    /**
     * Main method for starting up the program.
     * Accepts standard keyboard input.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Command command = new Command();
        while(sc.hasNextLine()) {
            command.parseLine(sc.nextLine());
        }
    }

    /**
     * Each line read will be parsed to find out the command,
     * and corresponding method is invoked.
     * @param line
     */
    private void parseLine(String line) {
        if(line == null || line.isEmpty())
            throw new IllegalArgumentException("Empty Line");
        String[] words = line.split("\\s+");
        String command = words[0];
        switch (command) {
            case "DEPEND" : {
                depend(words);
                break;
            }
            case "INSTALL" : {
                install(words[1]);
                break;
            }
            case "REMOVE" : {
                remove(words[1]);
                break;
            }
            case "LIST" : {
                list();
                break;
            }
            case "END" : {
                System.exit(0);
            }

            default : throw new IllegalArgumentException("Invalid input");
        }
    }

    /**
     * Honors DEPEND command and adds dependencies to in memory hashmap.
     * @param words
     */
    private void depend(String[] words) {
        if(words.length < 3)
            throw new IllegalArgumentException("Insufficient dependencies");
        if(dependencies.containsKey(words[1]))
            throw new IllegalArgumentException("Failed to redefine dependencies");
        String[] dependsOn = Arrays.copyOfRange(words, 2, words.length);
        dependencies.put(words[1], Arrays.asList(dependsOn));
    }

    /**
     * Installs the given programs/packages and also adds the name to
     * an in memory store - a hashset for quick access
     * @param program
     */
    private void install(String program) {
        if(installed.contains(program)) {
            System.out.printf("\t%s is already installed.\n", program);
            return;
        } else {
            installProgram(program);
        }
    }

    /**
     * Helper recursive method to install dependencies when needed
     * @param program
     */
    private void installProgram(String program) {
        if(installed.contains(program)) {
            return;
        } else {
            List<String> currDependencies = dependencies.get(program);
            if(currDependencies != null) {
                for(String dependency : currDependencies) {
                    installProgram(dependency);
                }
            }
            installed.add(program);
            System.out.printf("\tInstalling %s\n", program);
        }
    }

    /**
     * Honors the REMOVE command and removes the package if it has been previously installed.
     * @param program
     */
    private void remove(String program) {
        if(!installed.contains(program)) {
            System.out.printf("\t%s is not installed\n", program);
        } else {
            removeProgram(program, program);
        }
    }

    /**
     * Helper recursive method for removing dependencies
     * @param program
     * @param mainProgram
     */
    private void removeProgram(String program, String mainProgram) {
        if(checkDependency(program)) {
            if(program.equals(mainProgram))
                System.out.printf("\t%s is still needed\n", program);
            return;
        } else {
            installed.remove(program);
            System.out.printf("\tRemoving %s\n", program);
            List<String> currDependencies = dependencies.get(program);
            List<String> mainDependencies = dependencies.get(mainProgram);
            if(currDependencies != null) {
                for(String dependency : currDependencies) {
                    if(mainDependencies.contains(dependency))
                        removeProgram(dependency, mainProgram);
                }
            }

        }
    }

    /**
     * Checks if there are any dependencies that prevent uninstalling of a package.
     * @param program
     * @return boolean
     */
    private boolean checkDependency(String program) {
        for(Map.Entry entry : dependencies.entrySet()) {
            if(((List<String>)entry.getValue()).contains(program)
                    && installed.contains(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lists the installed packages in no particular order.
     */
    private void list() {
        Iterator<String> it = installed.iterator();

        while(it.hasNext()) {
            System.out.printf("\t%s\n", it.next());
        }

    }
}
