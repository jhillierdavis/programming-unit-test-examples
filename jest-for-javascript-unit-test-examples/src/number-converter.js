function toDecimalFromBinary(input) {
    return parseInt(input, 2) // see https://www.w3schools.com/jsref/jsref_parseint.asp
 }

 function toBinaryFromDecimal(input) {
    return parseInt(input.toString(2));
 }

 module.exports.toBinaryFromDecimal = toBinaryFromDecimal
 module.exports.toDecimalFromBinary = toDecimalFromBinary