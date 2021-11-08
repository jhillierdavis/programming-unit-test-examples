'use strict'

let classSyntax

if (typeof require == "function") {
  // Support for execution via Node.js
  classSyntax = require("../src/ClassSyntax.js")
} else {
  // Support for exectuion via Web Browser (e.g. via Jasmine 'SpecRunner.html' )
  classSyntax = {
    Employee: Employee
  }
}


describe("Explore JavaScript class syntax (JS does not really have classes, just constructor functions)", function() {

    it("Employee.raiseSalary()", function() {
        // Given: instances of Employee
        let john = new classSyntax.Employee("John Smith", 60000);
        let sally = new classSyntax.Employee("Sally Jones", 50000);

        // When: class method invokes
        john.raiseSalary(10)
        sally.raiseSalary(50)

        // Then: class variables as expected
        expect(john.name).toBe("John Smith");
        expect(john.salary).toBe(66000);
        expect(sally.name).toBe("Sally Jones");
        expect(sally.salary).toBe(75000);

        // And: if salary accessed directly
        john.salary = 200000

        // Then: salary can be set directly (i.e. NOT private!)
        expect(john.salary).toBe(200000)
    })

})