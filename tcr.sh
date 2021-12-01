#/bin/sh
mvn test && git commit -anm "TDD TCR WIP" || git reset --hard