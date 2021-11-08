'use strict'

let classSyntax

if (typeof require == "function") {
  // Support for execution via Node.js
  classSyntax = require("../src/ClassSyntax.js")
} else {
  // Support for exectuion via Web Browser (e.g. via Jasmine 'SpecRunner.html' )
  classSyntax = {
    Employee: Employee,
    Manager: Manager
  }
}


describe("Explore JavaScript class syntax (JS does not really have classes, just constructor functions)", function() {

    it("Employee.raiseSalary()", function() {
        // Given: instances of Employee
        let john = new classSyntax.Employee("John Smith", 60000);
        let sally = new classSyntax.Employee("Sally Jones", 50000);

        // When: class method invoked
        john.raiseSalary(10)
        sally.raiseSalary(50)

        // Then: class variables as expected
        expect(john instanceof classSyntax.Employee).toBe(true)
        expect(typeof(john)).toBe('object')
        expect(john.name).toBe("John Smith");
        expect(john.salary).toBe(66000);
        expect(sally.name).toBe("Sally Jones");
        expect(sally.salary).toBe(75000);

        // And: if salary accessed directly
        john.salary = 200000

        // Then: salary can be set directly (i.e. NOT private!)
        expect(john.salary).toBe(200000)
    })

    it("Manager.raiseSalary() with specified bonus", function() {
        // Given: instances of Manager
        let mary = new classSyntax.Manager("Mary Lee", 120000, 5000);

        // When: class method invoked
        mary.raiseSalary(10)

        // Then: class variables as expected (with salary also reflecting bonus payment)
        expect(mary.name).toBe("Mary Lee");
        expect(mary.salary).toBe(137000);

        // And: instanceof determines class type as expected
        expect(mary instanceof classSyntax.Employee).toBe(true)
        expect(mary instanceof classSyntax.Manager).toBe(true)
        expect(typeof(mary)).toBe('object')
    })

    it("Manager.raiseSalary() with default bonus", function() {
        // Given: instances of Manager
        let david = new classSyntax.Manager("David Walker", 120000);

        // When: class method invoked
        david.raiseSalary(10)

        // Then: class variables as expected (with salary also reflecting bonus payment)
        expect(david.name).toBe("David Walker");
        expect(david.salary).toBe(134000);

        // And: check bonus (via static field)
        expect(classSyntax.Manager.DEFAULT_BONUS).toBe(2000)
    })

})