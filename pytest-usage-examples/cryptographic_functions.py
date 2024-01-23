import hashlib


def hash_using_sha256(input):
    return hashlib.sha256((input).encode()).hexdigest()

from cryptography.fernet import Fernet # pip install cryptography

# Fernet us an implementation of symmetiuc authentication cryptography (see https://cryptography.io/en/latest/fernet/ )

ASCII_TEXT = 'ascii'

def generate_encryption_key():
    key = Fernet.generate_key()
    return key

def encrypt_using_key(input, key):
    f = Fernet(key)
    #binary_input = bytes(input, ASCII_TEXT)
    binary_input = input.encode(ASCII_TEXT)
    return f.encrypt(binary_input)

def decrypt_using_key(input, key):
    f = Fernet(key)
    binary_output =  f.decrypt(input)
    return binary_output.decode(ASCII_TEXT)