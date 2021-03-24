import pytest
import csv

"""

Unit Tests, using PyTest, exploring basic File operations 
---------------------------------------------------------

Exploration via examples of:
 
* Read lines from a text file
* TODO: Read entries from a CSV (Comma Separated Value) file

"""

"""
Content of test file(s):

% cat sample.txt
Alpha
Beta
Gamma


% cat sample.csv
alpha|beta|gamma

"""

def test_read_lines_from_text_file():
	# Setup: Open a text file for reading
	f = open('sample.txt','r')
	
	# When: content is read
	content = ""
	for x in f:
		content += x.replace('\n',' ');

	# Then: read content matches file content
	assert content == "Alpha Beta Gamma "
	
	# Cleanup: close the file handler 
	f.close() 
	
	
	
def test_read_a_line_from_text_file():
	# Setup: Open a text file for reading
	f = open('sample.txt','r')
	
	# When: first 2 lines are read
	line1 = f.readline()
	line2 = f.readline()
	line3 = f.readline()
	line4 = f.readline()

	# Then: read content matches file content
	assert line2.rstrip('\n') == "Beta"
	assert line4 == '' # non-existent
	
	# Cleanup: close the file handler 
	f.close() 	



def test_read_all_lines_from_text_file():
	# Setup: Open a text file for reading
	f = open('sample.txt','r')
	
	# When: entire content is read & split into lines
	content = f.read().splitlines()
	
	# Then: read content matches file content
	assert content[0] == "Alpha"
	assert content[1] == "Beta"
	assert content[2] == "Gamma"
	
	# Cleanup: close the file handler 
	f.close() 	
	
	
def test_read_csv_lines():
	with open('sample.csv', newline='') as csvfile:
		reader = csv.reader(csvfile, delimiter='|', quotechar='"')
		result = ""
		for row in reader:
			result += ', '.join(row)
	
	assert result == "alpha, beta, gamma"
	
	
	
