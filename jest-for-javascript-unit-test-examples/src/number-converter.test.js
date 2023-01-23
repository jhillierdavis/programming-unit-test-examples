const each = require("jest-each").default;
 
 const nc = require('./number-converter')

describe("parameterised test toDecimalFromBinary", () => {
    each([
        [100000, 32],        
        [101010, 42],
        [1000001, 65],        
        [1011001, 89],
        [1101111, 111],
        [1110010, 114],        
        [1110101, 117],
        [1110111, 119],     
    ]).it("when the input is '%s'", (input, expected) => {
      expect(nc.toDecimalFromBinary(input)).toBe(expected)
    });
});

describe("parameterised test toBinaryFromDecimal", () => {
    each([
        [32, 100000],        
        [42, 101010],
        [65, 1000001],        
        [89, 1011001],
        [111, 1101111],
        [114, 1110010],        
        [117, 1110101],
        [119, 1110111],     
    ]).it("when the input is '%s'", (input, expected) => {
      expect(nc.toBinaryFromDecimal(input)).toBe(expected)
    });
});

/*
test('test toDecimalFromBinary', () => {
    expect(toDecimalFromBinary(1011001)).toBe(89)
})
*/
  