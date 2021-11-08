'use strict'

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