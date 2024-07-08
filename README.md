
# Kennel Management System

![Kennel Logo](link-to-logo-image)

## Project Overview

The Kennel Management System is a Java-based application designed to manage and organize pets within a kennel. This project demonstrates a robust use of object-oriented programming principles, including inheritance, encapsulation, and polymorphism. The system handles various operations such as adding, removing, and listing pets, ensuring efficient management and operation of a kennel.

## Features

- **Animal Class Hierarchy**: Utilizes inheritance to create a base `Animal` class and extends it to `Cat` and `Dog` classes.
- **ArrayList Management**: Efficient storage and retrieval of pets using `ArrayList`.
- **Custom Methods**: Implementation of specialized methods such as `save`, `load`, and `toString` for data persistence and representation.
- **Exception Handling**: Robust error handling using `InputMismatchException` to manage user inputs.
- **Testing and Validation**: Extensive testing to ensure all functionalities work as expected, covering a variety of test cases.

## Project Structure

```plaintext
├── src
│   ├── Animal.java
│   ├── Cat.java
│   ├── Dog.java
│   ├── Kennel.java
│   ├── KennelDemo.java
│   └── Owner.java
└── README.md
```

### Animal.java
Defines the base class for all animals, incorporating common attributes and methods.

### Cat.java
Extends the `Animal` class, adding attributes and methods specific to cats.

### Dog.java
Extends the `Animal` class, adding attributes and methods specific to dogs.

### Kennel.java
Manages the collection of animals, providing methods to add, remove, and list pets.

### KennelDemo.java
Demonstrates the functionality of the Kennel Management System through various test cases.

### Owner.java
Represents the owner of the pets, linking them to their respective animals.

## Key Highlights

### Object-Oriented Design
- **Inheritance**: Abstract class `Animal` is inherited by `Cat` and `Dog`, demonstrating code reuse and polymorphism.
- **Encapsulation**: Private variables with public getter and setter methods ensure data hiding and encapsulation.

### Data Structures
- **ArrayList Usage**: Efficient management of pet records using dynamic arrays.

### Exception Handling
- **Robust Input Validation**: Ensures that the application handles incorrect inputs gracefully, maintaining the integrity of the program.

## Installation

To run this project, you need to have Java installed on your system. Clone the repository and compile the Java files:

\`\`\`bash
git clone https://github.com/yourusername/kennel-management-system.git
cd kennel-management-system/src
javac *.java
\`\`\`

Run the demo:

\`\`\`bash
java KennelDemo
\`\`\`

## Usage

The Kennel Management System allows you to:

- **Add a Pet**: Add new pets to the kennel with specific attributes.
- **Remove a Pet**: Remove pets from the kennel based on their unique ID.
- **List Pets**: Display a list of all pets currently in the kennel.

## Testing

Extensive testing was conducted to ensure the reliability and accuracy of the system. Key test cases include:

- Adding multiple pets and ensuring they are correctly stored.
- Removing pets and verifying the integrity of the remaining list.
- Handling erroneous inputs gracefully and maintaining program stability.

## Contributions

Contributions are welcome! Please fork the repository and submit pull requests with your improvements.

## Author

Nikola Nikolov [nin6]  
Email: [Nin6@aber.ac.uk](mailto:Nin6@aber.ac.uk)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
