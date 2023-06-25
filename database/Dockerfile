# syntax=docker/dockerfile:1
FROM mongo:5.0

ENV MONGO_INITDB_DATABASE Notes

ADD initdb.js /docker-entrypoint-initdb.d/
