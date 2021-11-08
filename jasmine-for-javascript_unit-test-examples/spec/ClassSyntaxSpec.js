'use strict'

describe("Explore JavaScript class syntax (JS does not really have classes, just constructor functions)", function() {

    it("Employee.raiseSalary()", function() {
        // Given: instances of Employee
        let john = new Employee("John Smith", 60000);
        let sally = new Employee("Sally Jones", 50000);

        // When: class method invokes
        john.raiseSalary(10)
        sally.raiseSalary(50)

        // Then: class variables as expected
        expect(john.name).toBe("John Smith");
        expect(john.salary).toBe(66000);
        expect(sally.name).toBe("Sally Jones");
        expect(sally.salary).toBe(75000);
    })

})