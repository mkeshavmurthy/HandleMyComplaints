echo "Cleaning up Selenium..."
docker-compose stop

echo  "Launching Selenium..."
docker-compose up -d

echo "##"
echo "# Running ALL tests"
echo "##"
# Not sure why it was using docker when it could use docker compose and have internal ports.
docker-compose run maven mvn test -DhubUrl=http://selenium-hub:4444 -DbrowserName=chrome  -DconfigPath=./env/stagging.properties