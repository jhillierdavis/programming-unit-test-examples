import pytest
import json

"""
Unit Tests using PyTest: 

* JSON deserialization/unmarshalling examples
"""

def _load_json_from_file(json_filename: str):
    with open(json_filename, 'r') as f:
        data = json.load(f)
    return data

def test_marshalling_from_file():
    # Given: a JSON object
    json = _load_json_from_file('sample.json')

    # Then: Python type for a JSON object is 'dict' (dictionary)
    type(json) == dict

    # Then: expected instance values are present
    assert json.get('id') == 12345, "ID should be 12345 !"

def test_marshalling_from_string():
    # Given: some example json
    json_string = """
    {
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

    # When: deserialized
    json_data = json.loads(json_string)

    # Then: Python type for a JSON object is 'dict' (dictionary)
    type(json_data) == dict

    # Then: expected instance values are present
    assert json_data.get("researcher").get("name") == "Ford Prefect", "Name should be 'Ford Prefect'!"