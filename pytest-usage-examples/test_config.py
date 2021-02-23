import pytest
import configparser

# Current properties file (see TestConfigFile.properties) content:
#
# [DatabaseSection]
# database.dbname=unitTest
# database.user=bogus
# database.password=Change1t!

def _read_config_from_file():
    config = configparser.RawConfigParser()
    config.read('TestConfigFile.properties')
    return config

def test_read_valid_config_entries():
    # Given: configuration read from a properties file
    config = _read_config_from_file()

    # Then: configuration entry values are as expected
    assert("unitTest" == config.get('DatabaseSection', 'database.dbname'))
    assert("bogus" == config.get('DatabaseSection', 'database.user'))
    assert("Change1t!" == config.get('DatabaseSection', 'database.password'))

def test_no_option_error():
    # Given: configuration read from a properties file
    config = _read_config_from_file()

    # Then: missing configuration entry values raises an exception
    with pytest.raises(configparser.NoOptionError):
        config.get('DatabaseSection', 'database.missing.option')

def test_no_section_error():
    # Given: configuration read from a properties file
    config = _read_config_from_file()

    # Then: missing configuration section raises an exception
    with pytest.raises(configparser.NoSectionError):
        config.get('MissingSection', 'database.user')