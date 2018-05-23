# Reefcoin Mobile Wallet (Android)

## How to contribute
1. `cd project dir`
2. `echo 'BUILD_NUMBER' = 99999 >> version.properties`
3. `echo 'VERSION' = 1.0.0 >> version.properties`
4. Ask for debug.properties and 'keystores' folder.
5. Copy both item into root dir.
6. Run the project.

## Git flow
1. branch off develop.
2. create `features-what-your-working`, `bugfix-what-bug-your-fixing` branch.
3. push branch upstream to develop.
4. merge into develop, after code review.
5. build for release.