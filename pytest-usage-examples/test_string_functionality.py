import pytest

"""

Unit Tests, using PyTest, exploring basic String (textual) manipulation 
-----------------------------------------------------------------------

Exploration via examples of:
 
* trimming of space/tab chars (e.g. leading &/or trailing)
* sub-string

"""

def test_space_char_trimming_using_strip():
	# Given: a test string with leading & trailing white space
	input = "  \t  Some text in here!   \t   "
	
	# When: the string function strip is invoked
	stripped = input.strip()
	
	# Then: the returned string has leading & trailing spaces removed
	expected = "Some text in here!"
	assert len(stripped) == 18
	assert stripped == expected
	
	# Plus: lstrip() or rstrip() can be used to trim only leading or trailing space chars (including tabs) respectively
	assert input.lstrip() == "Some text in here!   \t   "
	assert input.rstrip() == "  \t  Some text in here!"
	
	
def test_substring():
	# Given: a test string
	input = "Encapsulated!"
	
	# Expect: fragments to be obtained when substring invoked via array brackets
	assert "capsulated!" == input[2:]
	assert "capsulated" == input[2:-1]
	assert "capsulated" == input[len("En"):-1]
	assert "Encapsulated" == input[:-1]
	assert "late" == input[7:11]
	
def test_replace():
	"Explore sub-string replacement in Python"

	# Given: a test string
	input = '"Quoted"'
	
	# Expect: quotes to be removed when replaced with blanks
	assert input.replace('"','') == "Quoted"
	
	#And: further examples
	assert "Transformed".replace("form", "ferr") == "Transferred"
	assert "Zoom".replace("o","ooo") == "Zoooooom"

def test_contains():
	"Explore how to find out whether a string contains another (sub-string) in Python"

	# Given: a test string
	input = "Live in the present!"

	assert "present" in input
	assert "absent" not in input

