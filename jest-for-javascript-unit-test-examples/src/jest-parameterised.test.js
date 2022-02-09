const each = require("jest-each").default;

String.prototype.equalsIgnoreCase = function(str) {
  return (str != null &&
    typeof str === 'string' &&
    this.toUpperCase() === str.toUpperCase());
}

function reverseString(str) {
    return str.split("").reverse().join("");
}

function isPalindrome(str) {
	return str.equalsIgnoreCase(reverseString(str))
}

describe("isPalindrome", () => {
  each([
    ["madam", true],
    ["Hannah", true], // Mixed case
    ["redivider", true],
    ["deified", true],
    ["car", false],
    ["wrong", false],
  ]).it("when the input is '%s'", (text, expected) => {
    expect(isPalindrome(text)).toBe(expected);
  });
});
