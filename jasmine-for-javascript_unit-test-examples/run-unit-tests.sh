# Requires NodeJS (e.g. via 'nvm' - node version manager)

# Configured via ./spec/support/jasmine.json (by default) e.g. for location of spec. files

#npx jasmine
#npx jasmine --config=spec/support/jasmine.json
npx jasmine-node --verbose --junitreport --noColor spec
