'use strict' // Strict mode (Modern JS only!)

class Employee  {
    constructor(name, salary) {
        this.name = name
        this.salary = salary
    }

    raiseSalary(percent) {
        let value = this.salary * (1 + (percent / 100) )
        this.salary = Math.trunc(value)
    }
}

class Manager extends Employee {
    static DEFAULT_BONUS = 2000 // static field

    constructor(name, salary, bonus = Manager.DEFAULT_BONUS) {
        super(name, salary)
        this.bonus = bonus
    }

    raiseSalary(percent) {
        super.raiseSalary(percent)
        this.salary += this.bonus
    }
}

if (typeof module !== 'undefined') {
    // Support for standalone exection (e.g. via Node.js)
    module.exports = {
        Employee: Employee,
        Manager: Manager
    }
}
