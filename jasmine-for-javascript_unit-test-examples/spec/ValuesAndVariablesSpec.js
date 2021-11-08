describe("Javascript basics - values & variables", function() {

  it ("Type checks via typeof operator", function() {

      // Numbers
      expect(typeof(123456789)).toBe('number')
      expect(typeof(3.14)).toBe('number')

      // Strings
      expect(typeof("foo")).toBe('string')
      expect(typeof('bar')).toBe("string")
      expect(typeof('')).toBe("string")

      // Booleans
      expect(typeof(true)).toBe('boolean')
      expect(typeof(false)).toBe('boolean')

      // Miscellaneous
      expect(typeof(True)).toBe('undefined')
      expect(typeof(null)).toBe('object')
      expect(typeof(NaN)).toBe('number')
      expect(typeof(0/0)).toBe('number') // NaN
      expect(typeof(Infinity)).toBe('number')
      expect(typeof(1/0)).toBe('number') // Infinity
      expect(typeof('undefined')).toBe('string')

      // Objects
      let thing = { id: 123, name: "Instance"}
      expect(typeof(thing)).toBe('object')
      expect(typeof(thing.id)).toBe('number')
      expect(typeof(thing.name)).toBe('string')

      // Arrays (which as objects in JavaScript)
      expect(typeof([])).toBe('object') // Array (empty)
      expect(typeof(['alpha', 'beta', "gamma"])).toBe("object") // Array (populated)
      expect(Array.isArray(['alpha', 'beta', "gamma"])).toBe(true) // Array (populated)
  }),

  it("Use of let vs const to declare variables", function() {
    let mutable = "Unchanged";
    const immutable = "Unchanged"

    expect(function() { mutable = 'Changed' }).not.toThrow()
    expect(mutable).toBe('Changed')

    // Via Node execution:
    // expect(function() {immutable = 'This will fail!'}).toThrow(TypeError("Assignment to constant variable."))
    // In web browser:
    // expect(function() {immutable = 'This will fail!'}).toThrow(TypeError("Attempted to assign to readonly property."))
    // Generic:
    expect(function() {immutable = 'This will fail!'}).toThrow()
    expect(immutable).toBe('Unchanged')
  })
  
  it("Incrementing with ++", function() {
    // example from 'Modern Javascript for the impatient' (P.10)
    let counter = 0

    let riddle = counter++
    let enigma = ++counter

    expect(riddle).toBe(0);
    expect(enigma).toBe(2);
  })

  it("Addition exercise with different types", function() {
    // exercise 1 from 'Modern Javascript for the impatient' (P.24)
    expect(NaN + 0).toBeNaN();
    expect(Infinity + 0).toBe(Infinity);
    expect(false + 0).toBe(0);
    expect(true + 0).toBe(1);
    expect(null + 0).toBe(0);
    expect(undefined + 0).toBeNaN();
  })

  it("Addition/subtraction exercise with objects/arrays", function() {
    // exercise 2 from 'Modern Javascript for the impatient' (P.25)
    expect(typeof([] + [])).toBe('string')
    expect({} + []).toBe('[object Object]')
    expect(typeof({} + [])).toBe('string')
    expect([] + {}).toBe('[object Object]')
    expect(typeof([] + {})).toBe('string')
    expect([] + {}).toBe('[object Object]')
    expect(typeof([] + {})).toBe('string')
    expect([] - {}).toBeNaN()
    expect(typeof([] - {})).toBe('number')

  })

  it("Negative numbers are odd when odd in JavaScript", function() {
    // exercise 3 from 'Modern Javascript for the impatient' (P.25)

    // Even
    expect(4 % 2).toBe(0)
    expect(-4 % 2).toBe(0) 

    // Odd (is odd when number is negative)
    expect(3 % 2).toBe(1)
    expect(-3 % 2).toBe(-1) // Unlike Python (but like Java & C++) according to book

    // Decimals
    expect(4.00 % 2).toBe(0) 
    expect(-4.00 % 2).toBe(0) 
    expect(3.14 % 2).toBe(1.1400000000000001) 
    expect(-3.14 % 2).toBe(-1.1400000000000001)     
  })

  it("Normalise degress of rotation between 0 (inclusive) and 360 (exclusive)", function() {
    // exercise 4 from 'Modern Javascript for the impatient' (P.25)
    function normalise(angle) {
      return angle % 360
    }

    expect(normalise(0)).toBe(0)
    expect(normalise(90)).toBe(90)
    expect(normalise(180)).toBe(180)
    expect(normalise(360)).toBe(0)
    expect(normalise(540)).toBe(180)
  })


})
