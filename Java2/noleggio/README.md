# Build
mvn clean package && docker build -t it.ciacformazione/noleggio2 .

# RUN

docker rm -f noleggio2 || true && docker run -d -p 8080:8080 -p 4848:4848 --name noleggio2 it.ciacformazione/noleggio2 