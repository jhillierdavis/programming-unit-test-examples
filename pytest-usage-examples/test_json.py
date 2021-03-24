import pytest
import json
import os.path


"""
Unit Tests, using PyTest, exploring JSON (JavaScript Object Notation) functionality 
-----------------------------------------------------------------------------------

* JSON deserialization/unmarshalling examples
* JSON serialization/marshalling examples

Ref.: https://python.readthedocs.io/en/stable/library/json.html

"""

# Given: some example json
test_hitchhikers_guide_json_string = """{
    "researcher": {
        "name": "Ford Prefect",
        "species": "Betelgeusian",
        "relatives": [
            {
                "name": "Zaphod Beeblebrox",
                "species": "Betelgeusian"
            }
        ]
    }
}
"""

def _load_json_from_file(json_filename: str):
    with open(json_filename, 'r') as f:
        data = json.load(f) # use json.load() to deserialize from a file
    return data

def test_deserialize_json_from_file():
    # Given: a JSON object
    json = _load_json_from_file('sample.json')

    # Then: Python type for a JSON object is 'dict' (dictionary)
    type(json) == dict

    # Then: expected instance values are present
    assert json.get('id') == 12345, "ID should be 12345 !"

def test_deserialize_json_from_string():
    # When: deserialize some example json
    json_data = json.loads(test_hitchhikers_guide_json_string) # use json.loads() to deserialize from string

    # Then: Python type for a JSON object is 'dict' (dictionary)
    type(json_data) == dict

    # Then: expected instance values are present
    assert json_data.get("researcher").get("name") == "Ford Prefect", "Name should be 'Ford Prefect'!"

def _read_json_from_file(json_filename: str):
    with open(json_filename, "r") as read_file:
        json_data = json.load(read_file)
        read_file.close()
    return json_data

def _output_file_cleanup(filename:str):
    if os.path.exists(filename):
        os.remove(filename)

def test_serialize_json_to_file():
    # Setup: remove any existing output
    _output_file_cleanup("sample-output.json")
    json_data = json.loads(test_hitchhikers_guide_json_string)

    # When: serialize JSON to output file
    with open("sample-output.json", "w") as write_file:
        json.dump(json_data, write_file, indent=4)
    write_file.close()

    # Them: file is created
    assert(True == os.path.exists("sample-output.json") )

    # And: when JSON content is read
    read_json_data = _read_json_from_file("sample-output.json")

    # Then: read JSON matches original JSON data
    assert(read_json_data.get("researcher").get("relatives")[0].get("name") == "Zaphod Beeblebrox")

    # Clean-up:
    _output_file_cleanup("sample-output.json")
