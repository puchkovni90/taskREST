#!/bin/bash
#make me executable
psql -U postgres --file="`dirname \"$0\"`jerseyWeb.sql"