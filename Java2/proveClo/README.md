# Build
mvn clean package && docker build -t it.ciacformazione/proveClo .

# RUN

docker rm -f proveClo || true && docker run -d -p 8080:8080 -p 4848:4848 --name proveClo it.ciacformazione/proveClo 