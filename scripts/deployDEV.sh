pip freeze > requirements.txt
docker build -t moneymgr:localdev . && docker compose --env-file .env -f docker/docker-compose-dev.yml up