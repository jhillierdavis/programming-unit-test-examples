import pytest

"""

Unit Tests using PyTest as a unit test framework
------------------------------------------------

Exploration via examples of:
  
* Unit test - via simple boolean assertion
* Parameterised tests - variant coverage via test data
* Exception handling - assert expected exception thrown
* Ignore - ability to skip unit tests

"""

def test_sum():
    # Expect: sum to correctly aggregate values from a list ()
    assert sum([1, 2, 3]) == 6, "Should be 6" # Validate via a simple assertion



def test_string_size():
    # Expect: string length to match expected size
	assert( len("pytest") == 6) # Validate via a simple assertion

# Parameterised test data
@pytest.mark.parametrize(
    "str,expectedSize",
    [
        pytest.param("pytest", 6),
		pytest.param("Antidisestablishmentarianism", 28),
		pytest.param("Supercalifragilisticexpialidocious", 34),
		pytest.param("Pneumonoultramicroscopicsilicovolcanoconiosis", 45),
    ],
)
def test_parameterised_string_size(str, expectedSize):
    # Expect: data string lengths to match their expected size
	assert len(str) == expectedSize


def test_zero_division():
    # Expect: a specific exception
    with pytest.raises(ZeroDivisionError):
        # When: do something silly
        1 / 0

# Ignore / skip
@pytest.mark.skip(reason="example of intentionally skipped / ignored test")
def test_ignore():
    # Intentionally failing tested (to be skipped)
	assert(True == False)
