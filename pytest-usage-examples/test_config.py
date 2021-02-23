import pytest
import configparser

# Current properties file (see TestConfigFile.properties) content:
#
# [DatabaseSection]
# database.dbname=unitTest
# database.user=bogus
# database.password=Change1t!

def test_read_config_entries():
    # Given: configuration read from a properties file
    config = configparser.RawConfigParser()
    config.read('TestConfigFile.properties')

    # Then: configuration entry values are as expected
    assert("unitTest" == config.get('DatabaseSection', 'database.dbname'))
    assert("bogus" == config.get('DatabaseSection', 'database.user'))
    assert("Change1t!" == config.get('DatabaseSection', 'database.password'))