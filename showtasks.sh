#!/usr/bin/env bash

export RUNCRUD_HOME=~/Documents/tasks/runcrud.sh

open_browser(){
  if open -a "google chrome" http://localhost:8080/crud/v1/task/getTasks;
  then
    echo "Browser has been successfully opened."
    else
      echo "Browser cannot be opened."
      fi
}

end(){
  echo "The script is finished."
}

fail(){
  echo "Errors occured while running the script."
}

if $RUNCRUD_HOME; then
  open_browser
  end
else
  fail
  fi