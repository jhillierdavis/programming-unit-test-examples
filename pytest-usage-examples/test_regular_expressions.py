import pytest
import re # Regular expressions

def test_regex_match():
    txt = "The rain in Spain"

    # When:
    result = re.search("^The.*Spain$", txt)

    # Check: if the string starts with "The" and ends with "Spain"
    assert(txt, result)