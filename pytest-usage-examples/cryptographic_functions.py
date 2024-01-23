import hashlib


def hash_using_sha256(input):
    return hashlib.sha256((input).encode()).hexdigest()

import base64
from cryptography.fernet import Fernet # pip install cryptography
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC

# Fernet us an implementation of symmetiuc authentication cryptography (see https://cryptography.io/en/latest/fernet/ )

ASCII_TEXT = 'ascii'

def generate_encryption_key():
    key = Fernet.generate_key()
    return key

def generate_encryption_key_using_password(password, salt='salt'):

    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt.encode(ASCII_TEXT),
        iterations=480000,
    )    
    key = base64.urlsafe_b64encode(kdf.derive(password.encode(ASCII_TEXT)))
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