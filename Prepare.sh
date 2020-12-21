#!/bin/bash

# See https://sdkman.io/install
apt-get update
apt-get -q -y install curl zip unzip git
curl -s https://get.sdkman.io | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk install java 15.0.1.j9-adpt