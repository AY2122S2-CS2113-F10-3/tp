package seedu.duke.command;

import java.time.LocalDate;

import seedu.duke.Packages;
import seedu.duke.TravelPackage;

//creates a TravelPackage and adds to packages
public class AddCommand extends Command {
    private final TravelPackage newPackage;

    public AddCommand(String name, int id, LocalDate date1, LocalDate date2, String hotel, double price,
            String country,
            int maxVacancies) {
        this.newPackage = new TravelPackage(name, id, date1, date2, hotel, price, country,
                maxVacancies);
    }

    public TravelPackage getPackage() {
        return this.newPackage;
    }

    public void execute(Packages packages) {
        // handle existing ID
        if (packages.idExists(newPackage.getID())) {
            System.out.println("Package with this ID already exists! Please try again.");
        } else {
            packages.addPackage(newPackage);
            System.out.println("Package successfully added!");
        }
    }
}
