import pytest

"""

Unit Tests using PyTest
-----------------------

Exploration via examples of:
  
* Unit test - via simple boolean assertion
* Parameterised tests - variant coverage via test data
* Exception handling - assert expected exception thrown
* Ignore - ability to skip unit tests

"""

# Simple assertion
def test_sum():
    assert sum([1, 2, 3]) == 6, "Should be 6"	


# Simple assertion
def test_string_size():
	assert( len("pytest") == 6)

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
	assert len(str) == expectedSize

# Exception handling
def test_zero_division():
    with pytest.raises(ZeroDivisionError):
        1 / 0

# Ignore / skip
@pytest.mark.skip(reason="example of intentionally skipped / ignored test")
def test_ignore():
	assert(true == false)
	
