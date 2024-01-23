const cryptography = require('./cryptography')


test('check Jest is working', () => {
    hashed_email = cryptography.hash('john_smith@bogus.com')

    expect(hashed_email).toBe('0a17a7d96dfaa2302f567b663aac9571fded7fe80d780fe8a0586852c4b7acdc')
  })