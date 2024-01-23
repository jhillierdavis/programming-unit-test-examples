import hashlib

def hash_using_sha256(input):
    return hashlib.sha256((input).encode()).hexdigest()