import pytest

from cryptographic_functions import hash_using_sha256, generate_encryption_key, encrypt_using_key, decrypt_using_key

def test_hash_using_sha256():
    assert hash_using_sha256('john_smith@bogus.com') == '0a17a7d96dfaa2302f567b663aac9571fded7fe80d780fe8a0586852c4b7acdc'


def test_encrypt_and_decrypt_using_fernet():
    original_message = 'Keep this secret!'

    key = generate_encryption_key()

    encrypted_message = encrypt_using_key(original_message, key)
    assert original_message != encrypted_message
    
    decrypted_message = decrypt_using_key(encrypted_message, key)
    assert encrypted_message != decrypted_message
    assert original_message == decrypted_message
