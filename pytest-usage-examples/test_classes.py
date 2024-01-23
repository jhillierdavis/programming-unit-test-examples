import pytest
from datetime import date

class Person:
    "Class representing a person"

    # Class variables - shared by ALL instances of this class!
    type = "Human"

    def __init__(self, name: str, dob: date):
        # Instance variables - different per instance
        self.name = name
        self.dob = dob

    def get_age(self):
        # Get the current date
        today = date.today()

        # Calculate age (in years) from DOB (date of birth)
        age_in_years = today.year - self.dob.year
        if today.month < self.dob.month or (today.month == self.dob.month and today.day < self.dob.day):
            age_in_years -= 1
        return age_in_years

        return age

    def is_adult(self) -> bool:
        return self.get_age() >= 18

def test_age_restriction():
    # Setup
    today = date.today()
    
    man_dob  = date(today.year - 18, today.month, today.day) # 18th birthday today 
    man = Person("Adam Apple", man_dob)

    woman_dob = date(today.year - 17, today.month, today.day) # 17th birthday today 
    woman = Person("Eve Eden", woman_dob)

    # Check: class data & behaviour as expected
    assert man.type == "Human"
    assert man.name == "Adam Apple"
    assert man.is_adult() == True

    assert woman.type == "Human"
    assert woman.name == "Eve Eden"
    assert woman.is_adult() == False


class TlsConnectionInfo():
    "Class representing simple TLS info. e.g. for an SSL connection"
    def __init__(self, domain: str, port: int, tls_version: float, cipher: str):
        self.domain = domain
        self.port = port
        self.tls_version = tls_version
        self.cipher = cipher

    def is_compliant(self) -> bool:
        return self.tls_version > 1.1


# E.g. check whether TLS1.2 supported:
#
# openssl s_client -connect tls-v1.1.badssl.com:1011 -tls1_2


def test_tls_connection_info():
    # Setup: some TLS connections covering compliant (>= 1.2) & non-compliant (< 1.2) versions
    compliant = TlsConnectionInfo("bbc.co.uk", 443, 1.2, "ECDHE-RSA-AES128-GCM-SHA256")
    non_compliant = TlsConnectionInfo("tls-v1.1.badssl.com",1011, 1.1,  "ECDHE-RSA-AES256-SHA")

    # Compliance is as expected
    assert compliant.is_compliant()
    assert False == non_compliant.is_compliant()

