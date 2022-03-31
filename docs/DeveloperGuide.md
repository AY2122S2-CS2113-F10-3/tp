# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
### Basic Class Diagram 
![image](https://user-images.githubusercontent.com/53790951/160271319-4a351f51-afd7-4e04-9451-f04143146551.png)


## Product scope
### Target user profile

- Studies in a non-IT field
- Usually works alone
- Working in a small travel agency that offers affordable budget travel packages to only some countries
- Handles many customers a day
- Is unfamiliar with using CLI apps

### Value proposition

- Travel agencies often have to manage multiple customers and their respective bookings or plans.
- For employees of the travel agencies to track and record customers’ booking of travel packages. 


## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|Add reservation for a customer with basic information such as name, country etc. |Make a reservation|
|v1.0|new user|Print a list of all current and available travel packages |View all current travel packages and tell customers about our travel packages with one look|
|v1.0|new user|Remove an existing reservation|Remove information that we do not need anymore|
|v1.0|User ready to start using the app| Find out which travel packages are available for the specific location and duration|Make a recommendation of travel package to customers based on their desired location|
|v1.0|new user|Search for a specific travel package|Make recommendations to a customer based on their desired travel package requirements|
|v2.0|User ready to start using the app|Upload existing reservation data|Get started quickly|
|v2.0|User ready to start using the app|Make reservations based on custom input and edit them where necessary|Get familiar with inputting|
|v2.0|User ready to start using the app|See the changes I made from the previous day|Continue working|
|v2.1|Expert user|Create and use shortcuts|Quickly enter the details needed for a reservation and query any details I might need for an existing reservation|
|v2.1|Expert user|Update ratings of travel packages based on customer feedback|Provide a better recommendations for future customers|
|v2.1|Expert user|Ascertain the error in my input based on the error messages from the application|Quickly troubleshoot any mistakes that would slow down my work|
|v2.1|Expert user|View all reservations currently under a specific travel package|Optimize that travel package according to user’s feedback|
|v2.1|Expert user|I can build a customized travel package based on what the customer wants|It appeals to customers who do not want our existing tour packages|
|v2.1|Expert user|Add in hotels to the list of available hotel options|Update the itinerary |
|v2.1|Expert user|Add in countries to the list of available countries|Update the itinerary|
|v2.1|Expert user|Sort all reservations according to month|Analyze trends throughout the year|
|v2.1|Expert user|Mark a reservation as ‘completed’|Access both completed and ongoing reservations|
|v2.1|Expert user|Compute the price of custom travel packages|Get a rough estimate for what to charge the customer|

## Non-Functional Requirements

### Performance Requirements
- Should work on any mainstream OS as long as it has Java 11 or above installed.

### Usability
- A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
- Prompts and instructions must be in proper and concise sentences for ease of understanding.

## Glossary

* *glossary item* - Definition
* Packages - Travel Package within the agency's database
* Reservations - Reservation of travel package made by one customer through the app 

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

### Summary of User Commands

| Command | Format Examples |
| ------- | --------------- |
|packages|packages <br/> (prints details of all packages)|
|info|info {num} (num < number of available packages) <br/> e.g. info 2 |
|add|add {package_name},{ID},{startDate},{endDate},{hotel},{price},{country},{vacancies} <br/>  e.g. add Skiing Trip,1,23/2/2022,24/2/2022,hotelName,90.99,Singapore,20 <br/> adds a TravelPackage|
|delete|delete {num} (num < number of available packages) <br/> e.g. delete 2 <br/> delete a TravelPackage|
|reserve|reserve {package_id},{contact_name},{contact_number},{number_pax} <br/> e.g reserve 3,John,91234567,3|
|remove|remove {package_id},{contact_number} <br/> e.g remove 1,8888888 <br/> remove an existing reservation|
|reservations|reservations {package_number} <br/> eg. reservations 2 <br/> print all reservations for a given travelPackageID|

## Feature - Help Command 
Aim: Displays a list of all available commands that the user can refer to as a guide

## Feature - Storage
#### Initialisation (Loading Data)
The sequence diagram that shows how `Storage` is created and the data is loaded from the saved files when the program is initialised is shown below: </br>
![](LoadFileSeqDiag.png)

1. `TARBS` creates a Storage object with the relevant file name (`filePath`).
2. `TARBS` then calls the `createPackages()` method of the Storage class
3. `storage` will call the `parseSavedFile()` method, which initiates a while loop that iterates through the text file and processes the string data using the respective `parse` methods.
4. A new `TravelPackage` object is constructed with the relevant data.
5. A new `Packages` object is created using the `TravelPackage` object and returned back to `TARBS`.

#### Saving data
The sequence diagram that shows how `Storage` is used to save the current list of travel packages and reservations is shown below: </br>

![](SaveFilesSeqDiag.png)

1. `TARBS` calls the `savePackageToFile()` method of `storage`, passing in the `packages` object.
2. `storage` will then use a loop to iteratively retrieve the data in string format from the individual `TravelPackage` objects.
3. `storage` will create a new `FileWriter` object to write the string data into a text file.

## Feature - Parser
The sequence diagram shows an example of how a user input is parsed and returns a new `Command`.

For simplicity, `ByeCommand` is shown here:

![image](https://user-images.githubusercontent.com/53790951/160289728-5a17b2ea-0599-48f4-a18b-cadfbbcbfb11.png)

