import pytest

from cryptographic_functions import hash_using_sha256

def test_hash_using_sha256():
    assert hash_using_sha256('john_smith@bogus.com') == '0a17a7d96dfaa2302f567b663aac9571fded7fe80d780fe8a0586852c4b7acdc'