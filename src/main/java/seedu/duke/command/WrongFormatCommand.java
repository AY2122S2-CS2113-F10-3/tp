package seedu.duke.command;

import seedu.duke.Packages;

public class WrongFormatCommand extends Command{

    private String input;

    public WrongFormatCommand(String input) {
        this.input = input;
    }

    public void execute(Packages packages) {
        System.out.println("Input in wrong format: " + this.input);
        System.out.println("Use the help command to find out the valid commands.");

    }

}