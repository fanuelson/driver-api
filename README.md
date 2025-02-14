# driver-api

# Project example simple saving direct to mongo

## Using k6
<hr/>

### Install k6 
https://grafana.com/docs/k6/latest/set-up/install-k6/
<hr/>

### Examples using k6 for stress test

```k6 run --duration 10s ./src/test/k6/create-driver-k6-test.js```

```k6 run --duration 10s --vus 2 ./src/test/k6/create-driver-k6-test.js```