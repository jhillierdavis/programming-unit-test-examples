import pytest
import json
import os.path


"""
Unit Tests using PyTest: 

* JSON serialization/marshalling examples

Ref.: https://python.readthedocs.io/en/stable/library/json.html

"""

def _generate_json():
    data = """{
        "president": {
            "name": "Zaphod Beeblebrox",
            "species": "Betelgeusian"
        }
    }"""
    return json.loads(data)

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
    json_data = _generate_json()

    # When: serialize JSON to output file
    with open("sample-output.json", "w") as write_file:
        json.dump(json_data, write_file, indent=4)
    write_file.close()

    # Them: file is created
    assert(True == os.path.exists("sample-output.json") )

    # And: when JSON content is read
    read_json_data = _read_json_from_file("sample-output.json")

    # Then: read JSON matches original JSON data
    assert(read_json_data.get("president").get("name") == "Zaphod Beeblebrox")

    # Clean-up:
    _output_file_cleanup("sample-output.json")






