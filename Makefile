all: help

SHELL := /bin/bash

EXECUTABLES=docker docker-compose gradle npm widdershins

ifeq (logs, $(firstword $(MAKECMDGOALS)))
   logargs := $(wordlist 2, $(words $(MAKECMDGOALS)), $(MAKECMDGOALS))
   $(eval $(logargs):;@true)
endif

##	build:			Build or rebuild hermes services
.PHONY : build
build:
	@docker-compose logs -f stack/services.yaml build

 ## 	up:			Build and UP de environment
.PHONY : up
up:
	@docker-compose -f stack/services.yaml up -d --build

## 	down:			Brings the environment down
 .PHONY : down
 down:
	@docker-compose -f stack/services.yaml down -v
## 	down:			Brings the environment down
 .PHONY : logs
 logs:
	@docker-compose -f stack/services.yaml logs