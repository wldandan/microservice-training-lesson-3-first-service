#!/usr/bin/env bash

SEED_FILE_NAME='events-with-id.json'
mongoimport --db test --collection event --type json --file $SEED_FILE_NAME
