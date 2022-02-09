const each = require("jest-each").default;

String.prototype.equalsIgnoreCase = function(str) {
  return (str != null &&
    typeof str === 'string' &&
    this.toUpperCase() === str.toUpperCase());
}

function reverseString(str) {
    return str.split("").reverse().join("");
}

function stripSpaceAndPunctuation(str) {
	let cleansed = str.replace(/\s/g, '');
        return cleansed.replace(/[\p{P}$+<=>^`|~]/gu, '')
}

function isPalindrome(str) {
	let normalised = stripSpaceAndPunctuation(str)
	if (normalised.length == 0)	{
		return false
	}
	return normalised.equalsIgnoreCase(reverseString(normalised))
}

describe("isPalindrome", () => {
  each([
    ["madam", true],
    ["Hannah", true], // Mixed case
    ["redivider", true],
    ["deified", true],
    ["a", true],
    ["race car", true],
    ["never odd or even", true],
    ["A man, a plan, a canal. Panama", true],
    ["Madam, I'm Adam", true],
    ["car", false],
    ["wrong", false],
    ["paliindrome", false],
    ["almostomla", false],
    ["", false],
    [" ", false],
  ]).it("when the input is '%s'", (text, expected) => {
    expect(isPalindrome(text)).toBe(expected);
  });
});
